package projectManagerrJava;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Plots {
	ArrayList<String> label = new ArrayList<String>();
	
	ConnectorToDb con = new ConnectorToDb();
	String success;
	
	public ArrayList<String> checkAvailablePlots() throws SQLException {
		//Check in the plot entries in the database where the owners column is null
		//Return the an array of the plot labels
		
		
		String query = "select label from plots";
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			label.add(results.getString("label"));
			/*String aString = results.getString("label");
			System.out.println(aString);*/
		}
		return label;
	}
	
	public String addPlot(String label) throws SQLException {
		//Add the plot id passed into the database. Plot labels are unique. We only add a plot that isn't in the database yet
		
		Plots plots = new Plots();
		ArrayList<String> adda = plots.checkAvailablePlots();
		int i=0;String plotExists = "No";
		while(i<adda.size() & plotExists!="Yes") {
			if(!label.equalsIgnoreCase(adda.get(i))) {plotExists = "No";i++;}else {plotExists = "Yes";i++;}
		}
		if(plotExists == "No") {
		 con.statement.executeUpdate("insert into `plots`(label) values ('"+label+"')");
		 success="Plot Added Successfully";}else {success="Plot Already Exists";}
		return success;
	}
	public String bookPlot(String plotLabel, String regNo) throws SQLException {
		//Check if the plot passed is in the plotsAvailable list. If not return plot already booked.
		//If it is there, add user to the owner's column for that particular plot.
		//We only book an existing plot.
		
		Plots plots = new Plots();
		ArrayList<String> booker = plots.checkAvailablePlots();
		int i=0;String plotExists = "No";
		while(i<booker.size() & plotExists != "Yes") {
			if(!plotLabel.equalsIgnoreCase(booker.get(i))) {plotExists = "No";}else {plotExists = "Yes";}i++;

		}
		if(plotExists == "Yes") {
			System.out.println("Ok upto here");
			 //Add plot owner to plot details
			 //con.statement.executeUpdate("insert into `plots`(owner)" + "values ('"+regNo+"')" + "where label = '"+plotLabel+"'");
			 con.statement.executeUpdate("update `plots` set owner = '"+regNo+"' where owner IS NULL");
			 success="Booking Successful";
		}else {success="Block Taken";}
		return success;
	}
}
