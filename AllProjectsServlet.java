package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllProjectsServlet
 */
@WebServlet(description = "retrieve all projects from the database", urlPatterns = { "/AllProjectsServlet" })
public class AllProjectsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Project project = new Project();
		
		PrintWriter printWriter = response.getWriter();
		try {
			ArrayList<String> list = project.checkAvailableProjects();
			printWriter.println("Here are the Projects currently in the database ");
			int i=0;
			while(i<list.size()) {printWriter.print("Reg Number: "+list.get(i) + "   ");printWriter.println("Project Title: "+list.get(i+1));i=i+2;}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
