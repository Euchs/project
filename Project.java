package projectManagerrJava;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Project {
	//Variables
	//String owner, title, comments;
	ConnectorToDb con = new ConnectorToDb();
	
	//Functions
	//Add project-Lecturer
	//Place Comment-Lecturer
	//View Comment-student
	
	//Add Project
	public void addProject(String owner, String title) throws SQLException {
		
			 con.statement.executeUpdate("insert into `project`(owner, title)" + "values ('"+owner+"', '"+title+"')");
			 System.out.println("Done");
	}
	
	//Add comment. Returns a confirmation message.
	public String addComment(String owner, String comment) throws SQLException {
		
		 PreparedStatement prep = con.connection.prepareStatement("update `project` set comments = '"+comment+"' where owner = ?");
	     prep.setString(1, owner);
	     prep.executeUpdate();
	     return "Comment Added";
	}
	
	//view comment. Returns the comment.
	public String viewComment(String owner) throws SQLException{
		 String commenta;
		 PreparedStatement prep = con.connection.prepareStatement("select comments from `project` where owner = ?");
	     prep.setString(1, owner);
	     ResultSet resultSet = prep.executeQuery();
	     resultSet.next();
	     commenta=resultSet.getString("comments");
		return commenta;
		}
	
}
