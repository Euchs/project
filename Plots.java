package manageProjects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Plots {
	
	ConnectorToDb con = new ConnectorToDb();
	String success;
	
	public ArrayList<String> checkAvailablePlots() throws SQLException {
		//Check in the plot entries in the database where the owners column is null
		//Return the an array of the plot labels
		
		ArrayList<String> label = new ArrayList<String>();
		String query = "select label from plots";
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			label.add(results.getString("label"));
		}
		return label;
	}
	
	//Does Plot really exist
	public  static Boolean doesPlotExist(String testaPlotLabel) throws Exception  {
		
		Plots plots = new Plots();
		ArrayList<String> testaLabelPlot=plots.checkAvailablePlots();
		int i=0;Boolean plotAvailable = false;
		while(i<testaLabelPlot.size() & plotAvailable != true) {
			if(!testaPlotLabel.equalsIgnoreCase(testaLabelPlot.get(i))) {plotAvailable = false;}else {plotAvailable = true;}i++;
		}
		
		return plotAvailable;
	}

	
	
	//Retrieve free plots
	public ArrayList<String> checkFreePlots() throws SQLException {
		
		ArrayList<String> labelFree = new ArrayList<String>();
		String query = "select label from plots where owner IS NULL";
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			labelFree.add(results.getString("label"));

		}
		return labelFree;
	}
	
	//Check if the user attempting to book already has a plot to avoid double booking
	
	public  static Boolean hasAplotAlready(String reg) throws Exception  {
		
		Plots plots = new Plots();
		ArrayList<String> testaOwner=plots.checkAvailableBookers();
		int i=0;Boolean personExists = false;
		while(i<testaOwner.size() & personExists != true) {
			if(!reg.equalsIgnoreCase(testaOwner.get(i))) {personExists = false;}else {personExists = true;}i++;
		}
		
		return personExists;
	}
	
	//Is plot free??
public  static Boolean isPlotFree(String checkedLabel) throws Exception  {
	Plots plots = new Plots();
	Boolean plotFree = false;
	if(doesPlotExist(checkedLabel)) {
		
		ArrayList<String> testaLabel=plots.checkFreePlots();
		int i=0;
		while(i<testaLabel.size() & plotFree != true) {
			if(!checkedLabel.equalsIgnoreCase(testaLabel.get(i))) {plotFree = false;}else {plotFree = true;}i++;
		}
	}
		
		return plotFree;
	}
	
	public String addPlot(String label) throws Exception {
		//Add the plot id passed into the database. Plot labels are unique. We only add a plot that isn't in the database yet

		if(!doesPlotExist(label)) {
		 con.statement.executeUpdate("insert into `plots`(label) values ('"+label+"')");
		 success="Plot Added Successfully";}else {success="Plot Already Exists";}
		return success;
	}
	public String bookPlot(String plotLabel, String regNo) throws Exception {
		//Check if the plot passed is in the plotsAvailable list. If not return plot already booked.
		//If it is there, add user to the owner's column for that particular plot.
		//We only book an existing plot.
		//Allow not double book.
		
		if(doesPlotExist(plotLabel) && isPlotFree(plotLabel) && !hasAplotAlready(regNo)) {
			 //Add plot owner to plot details
			 con.statement.executeUpdate("update `plots` set owner = '"+regNo+"' where owner IS NULL and label='"+plotLabel+"'");
			success="Booking Successful";
		}else if(hasAplotAlready(regNo)){
			success="Already have a plot. Can't book twice";
		}else if(doesPlotExist(plotLabel) && !isPlotFree(plotLabel)){
			success="Block Taken";
		}else if(!doesPlotExist(plotLabel)){
			success="Plot Does Not Exist";
			}
		return success;
	}
	
	
	//Retrieve those who have booked
	public ArrayList<String> checkAvailableBookers() throws SQLException {
		
		ArrayList<String> owner = new ArrayList<String>();
		String query = "select owner from plots where owner IS NOT NULL";
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			owner.add(results.getString("owner"));
		}
		return owner;
	}
	
	//Unbook
	public String unbook(String studentReg) throws Exception {
		
		if(hasAplotAlready(studentReg)) {
		con.statement.executeUpdate("update plots set owner = null where owner='"+studentReg+"';");
		success="Successfully Unbooked " + studentReg;
		}else {success="Invalid registration number. The booker does not exist";}
		
		return success;
		
		
	}
	
}
