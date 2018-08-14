package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet(description = "Adds student's details to the database", urlPatterns = { "/RegisterStudentServlet" })
public class RegisterStudentServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Users users = new Users();
		
		PrintWriter printWriter = response.getWriter();
		try {
			String stateReturned = users.registerStudent(request.getParameter("theId"), request.getParameter("theName"), request.getParameter("thePass"));
			printWriter.println(stateReturned);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
