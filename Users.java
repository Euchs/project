package manageProjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {
	//Variables: name, id, password, role
	ConnectorToDb con = new ConnectorToDb();
	String id, name, password, role;
	
	//Methods: registerLecturer, registerStudent, getThoseRegistered, isRegisterd, login, getThoseLogged, isLogged, logout
	
	//Get those who have already registered
	public ArrayList<String> getThoseRegistered() throws SQLException {
		
		ArrayList<String> ids = new ArrayList<String>();
		String query = "select id from users";
		
		ResultSet results = con.statement.executeQuery(query);
		while(results.next()){
			ids.add(results.getString("id"));
		}
		return ids;
		}
	
	//Is a particular user registered
	public static Boolean isRegistered(String userId) throws SQLException {
		
		Users users = new Users();
		ArrayList<String> allUsers=users.getThoseRegistered();
		int i=0;Boolean userRegistered = false;
		while(i<allUsers.size() & userRegistered != true) {
			if(!userId.equalsIgnoreCase(allUsers.get(i))) {userRegistered = false;}else {userRegistered = true;}i++;
		}
		
		return userRegistered;
		}
	
	//Register a lecturer
	public String registerLecturer(String employeeNumber, String lecName, String passWord) throws SQLException {
		
		String success;String theRole="Lecturer";
		if(!isRegistered(employeeNumber)) {
			 con.statement.executeUpdate("insert into `users`(id, name, role, logged, passcode) values ('"+employeeNumber+"', '"+lecName+"', '"+theRole+"', false, '"+passWord+"')");
			 success="Registration Successful";}else {success="You had already Registered";}
			return success;
		}
	
	//Register a student
		public String registerStudent(String regNumber, String studentName, String passWord) throws SQLException {
			String success;String theRole="Student";
			if(!isRegistered(regNumber)) {
				 con.statement.executeUpdate("insert into `users`(id, name, role, logged, passcode) values ('"+regNumber+"', '"+studentName+"', '"+theRole+"', false, '"+passWord+"')");
				 success="Registration Successful";}else {success="You had already Registered";}
				return success;}
		
	//Get those who have already Logged in
		public ArrayList<String> getThoseLogged() throws SQLException {
			
			ArrayList<String> ids = new ArrayList<String>();
			String query = "select id from users where logged=true";
			
			ResultSet results = con.statement.executeQuery(query);
			while(results.next()){
				ids.add(results.getString("id"));
			}
			return ids;
			}
		
	//Is a particular user Logged in
		public static Boolean isLogged(String userId) throws SQLException {
			
			Users users = new Users();
			ArrayList<String> allUsersLogged=users.getThoseLogged();
			int i=0;Boolean userLogged = false;
			while(i<allUsersLogged.size() & userLogged != true) {
				if(!userId.equalsIgnoreCase(allUsersLogged.get(i))) {userLogged = false;}else {userLogged = true;}i++;
			}
			
			return userLogged;
			}
		
	//Get Password
	public String getUserPasswordFromDb(String userId) throws SQLException {
		
		String password;
		String query = "select passcode from users where id='"+userId+"'";
		
		ResultSet results = con.statement.executeQuery(query);
		results.next();
		password=results.getString("passcode");
		return password;
		}
		
	//Check Password
		
	public Boolean isPasswordCorrect(String userId, String enteredPassword) throws SQLException{
		Boolean correct=false;
		String storedPassword = new Users().getUserPasswordFromDb(userId);
		
		if(enteredPassword.equals(storedPassword)) {correct=true;}else {correct=false;}
		
		return correct;
	
	}
	
	//Get user role
	public String getUserRoleFromDb(String userId) throws SQLException {
		
		String rolea;
		String query = "select role from users where id='"+userId+"'";
		
		ResultSet results = con.statement.executeQuery(query);
		results.next();
		rolea=results.getString("role");
		return rolea;
		}	
	
		
	//LogIn
		public String login(String userId, String passWord) throws SQLException {
			
			
			
			String success = null;
			if(isRegistered(userId) && (!isLogged(userId) || isLogged(userId)) && isPasswordCorrect(userId, passWord)) {
				 //Add plot owner to plot details
				 con.statement.executeUpdate("update `users` set logged = true where id='"+userId+"'");
				success=new Users().getUserRoleFromDb(userId);
			}else if(!isRegistered(userId)){
				success="You haven't Registered";
			}else if(isRegistered(userId) && !isPasswordCorrect(userId, passWord)){
				success="Password Incorrect";
			}
			return success;
			
			}
		
		//LogOut
				public void logout(String userId) throws SQLException {
						 //Add plot owner to plot details
						 con.statement.executeUpdate("update `users` set logged = false where id='"+userId+"'");
			
				}
		
}
