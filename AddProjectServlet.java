package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProjectServlet
 */
@WebServlet(description = "Adds a new project to the database", urlPatterns = { "/AddProjectServlet" })
public class AddProjectServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Project project = new Project();
		
		
		PrintWriter printWriter = response.getWriter();
		try {
			String stateReturned = project.addProject(request.getParameter("theId"), request.getParameter("theTitle"));
			printWriter.println(stateReturned);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
