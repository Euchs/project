package manageProjects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Project {
	
	ConnectorToDb con = new ConnectorToDb();
	
	//Check available projects
	public ArrayList<String> checkAvailableProjects() throws SQLException {
		
		ArrayList<String> owner = new ArrayList<String>();
		String query = "select owner, title from project where owner IS NOT NULL";
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			owner.add(results.getString("owner"));
			owner.add(results.getString("title"));
		}
		return owner;
	}
	
	//Does project Exist
public  static Boolean doesProjectExist(String projectId) throws Exception  {
		
		Project project= new Project();
		ArrayList<String> testaProjectId=project.checkAvailableProjects();
		int i=0;Boolean projectAvailable = false;
		while(i<testaProjectId.size() & projectAvailable != true) {
			if(!projectId.equalsIgnoreCase(testaProjectId.get(i))) {projectAvailable = false;}else {projectAvailable = true;}i++;
		}
		
		return projectAvailable;
	}
	
	//Add Project
	public String addProject(String owner, String title) throws Exception {
		
		String state = null;
		if(!doesProjectExist(owner) && Proposal.isProposalApproved(owner) && Users.isRegistered(owner)) {	
			 con.statement.executeUpdate("insert into `project`(owner, title)" + "values ('"+owner+"', '"+title+"')");
			state="Project Added Successfully";
		}else if(doesProjectExist(owner)){state="There is already an ongoing project. Can't add another";
		}else if(!Users.isRegistered(owner)) {state = "Student has not registered Yet";
			
		}else if(!Proposal.isProposalApproved(owner)) {state="The Student's Proposal Has Not Been Approved Yet";}else if(!Proposal.doesProposalExist(owner)) {state="Student Has Not Forwarded A Proposal Yet";}
			
			return state;
	}
	
	//Add comment. Returns a confirmation message.
	public String addComment(String owner, String comment) throws Exception {
		
		String state;
		if(doesProjectExist(owner)) {
		 PreparedStatement prep = con.connection.prepareStatement("update `project` set comments = '"+comment+"' where owner = ?");
	     prep.setString(1, owner);
	     prep.executeUpdate(); state="Comment Added";}else {state="No such ProjectID. No such project exists";}
	     return state;
	}
	
	//view comment. Returns the comment.
	public String viewComment(String owner) throws Exception{
		 
		String commenta = null;
		if(doesProjectExist(owner)) {
		 PreparedStatement prep = con.connection.prepareStatement("select comments from `project` where owner = ?");
	     prep.setString(1, owner);
	     ResultSet resultSet = prep.executeQuery();
	     resultSet.next();
	     commenta=resultSet.getString("comments");}else {commenta="Could not retrieve comment. The ID provided does not exist";}
		return commenta;
		}
	
}
