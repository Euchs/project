package manageProjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Proposal{

	/*Variables: owner, title, the file
	Functions: place proposal(student), view proposal file(lecturer), approve proposal(lecturer), view proposal status(student)*/

	ConnectorToDb con = new ConnectorToDb();
	String done;
	
	
	

	//InputStream inpStream = new FileInputStream(new File(filePath));

	//Check which students have submitted their proposals
	public ArrayList<String> checkSubmittedProposalsIds() throws SQLException {
		
		
		String query = "select owner from proposal";
		ArrayList<String> owner = new ArrayList<String>();
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			owner.add(results.getString("owner"));
		}
		return owner;
	}
	
	//Does Proposal Exist
	public  static Boolean doesProposalExist(String proposalId) throws Exception  {
		
		Proposal proposal = new Proposal();
		ArrayList<String> testaProposalId=proposal.checkSubmittedProposalsIds();
		int i=0;Boolean proposalAvailable = false;
		while(i<testaProposalId.size() & proposalAvailable != true) {
			if(!proposalId.equalsIgnoreCase(testaProposalId.get(i))) {proposalAvailable = false;}else {proposalAvailable = true;}i++;
		}
		
		return proposalAvailable;
	}
	
	//Check if proposal has been approved
	public String viewProposalStatus(String owner) throws Exception{
		
		//First check if the proposal exists
		
		String state;
		if(doesProposalExist(owner)) {
		PreparedStatement prep = con.connection.prepareStatement("select state from proposal where owner=?");
		prep.setString(1, owner);

		ResultSet results=prep.executeQuery();
		results.next();
		state=results.getString("state");}else {state="proposal does not exist";}

		return state;
	}
	
	//Is proposal approved
		public  static Boolean isProposalApproved(String proposalId) throws Exception  {
			
			Proposal proposal = new Proposal();
			String testaProposalId=proposal.viewProposalStatus(proposalId);
			Boolean proposalApproved = false;
			
			if(testaProposalId.equalsIgnoreCase("Not Approved")) {proposalApproved = false;}else {proposalApproved = true;}
			return proposalApproved;
		}

	//Forward your proposal
	public String placeProposal(String filePath, String owner) throws Exception{

		//First check if the proposal does not exist

		InputStream inp = new FileInputStream(new File(filePath));
		String success = null;
		if(!doesProposalExist(owner) && Users.isRegistered(owner)) {
		
		PreparedStatement prep = con.connection.prepareStatement("insert into proposal (owner, proposalfile, state) values (?, ?, ?)");
		prep.setString(1, owner);
		
		prep.setBlob(2, inp);
		prep.setString(3, "Not Approved");

		prep.executeUpdate();success = "Successfully Added Your Proposal";}else if(doesProposalExist(owner))/*if proposal already exists*/{
			
			String defaultState= "Not Approved";
			PreparedStatement prep = con.connection.prepareStatement("update proposal set proposalfile=?, state='"+defaultState+"' where owner ='"+owner+"'");
			prep.setBlob(1, inp);
			prep.executeUpdate();
			
			success = "Successfully Replaced Your Proposal File. You had an existing proposal already.";
		}
		else if(!Users.isRegistered(owner)) {
			success = "Student has not registered. Can't place proposal...";
		}
		
		return success;

	}

	//View Proposal returns the path to the saved file
	public String viewProposal(String owner) throws Exception{
		
		//First check if the proposal exists
		String savedOrNot;
		int BUFFER_SIZE = 100000;
		String filePathSave = "C:\\Users\\Ouma\\Documents\\workspace-sts-3.9.5.RELEASE\\ProjectManagementSyst\\ProposalFiles\\myProposal.txt";
	
	    if(doesProposalExist(owner)) {
		PreparedStatement prep = con.connection.prepareStatement("select proposalfile from proposal where owner=?");
		prep.setString(1, owner);

		ResultSet resultSet = prep.executeQuery(); 
		resultSet.next();
		Blob blob = resultSet.getBlob("proposalFile");

		InputStream input = blob.getBinaryStream();
		
		OutputStream output = new FileOutputStream(new File(filePathSave ));
		int bytesRead = -1;
		byte[] buffer = new byte[BUFFER_SIZE];
		while((bytesRead=input.read(buffer))!=-1){
			output.write(buffer, 0, bytesRead);
		}
		input.close();
		output.close(); savedOrNot="Successfully Saved Your Proposal to "+ filePathSave;}else {savedOrNot="Proposal Does not Exist";}

		return savedOrNot;
	}
	
	
	
	//Approve proposal
	public String approveProposal(String owner) throws Exception {
		
		//First check if the proposal exists

		if(doesProposalExist(owner) && !isProposalApproved(owner)) {
			
			String defaultState= "Not Approved";
			String newtState= "Approved";
			con.statement.executeUpdate("update proposal set state='"+newtState+"' where owner ='"+owner+"' and state='"+defaultState+"'");
			done="Proposal Approved Successfully";
		}else if(!doesProposalExist(owner)){done="Proposal Does not Exist";}else if(isProposalApproved(owner)){done="Proposal Was Already Approved Previously";}
		return done;

	}
}