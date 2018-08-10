package manageProject;
import java.sql.*;
	
public class ConnectorToDb {

		//Database connection and access variables
		Connection connection;
		Statement statement;
		//ResultSet results;

		//DatabaseConnect constructor
		public ConnectorToDb(){

			try{
				//Connecting to the database
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement?autoReconnect=true&useSSL=false", "root", "crazeardour09679");
				statement = connection.createStatement();

			}catch(Exception ex){
				System.out.println(ex);
			}
		}
}
