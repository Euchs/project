package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterLecturerServlet
 */
@WebServlet(description = "Adds lecturer's details to the database", urlPatterns = { "/RegisterLecturerServlet" })
public class RegisterLecturerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Users users = new Users();
		
		PrintWriter printWriter = response.getWriter();
		try {
			String stateReturned = users.registerLecturer(request.getParameter("empnumber"), request.getParameter("empname"), request.getParameter("emppass"));
			printWriter.println(stateReturned);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
