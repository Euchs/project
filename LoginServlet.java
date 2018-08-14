package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Logs a user in to the system", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Users users = new Users();
		HttpSession session = request.getSession();
		PrintWriter printWriter = response.getWriter();
		
		try {
			String stateReturned = users.login(request.getParameter("theId"), request.getParameter("thePass"));
			if(stateReturned.equals("Student")) {
				session.setAttribute("userId", request.getParameter("theId"));
				response.sendRedirect("homes.jsp");
				//RequestDispatcher rDispatcher = request.getRequestDispatcher("homes.jsp");
			//rDispatcher.forward(request, response);

			}else if(stateReturned.equals("Lecturer")) {
				session.setAttribute("userId", request.getParameter("theId"));
				response.sendRedirect("homel.jsp");
				
				//RequestDispatcher rDispatcher = request.getRequestDispatcher("homel.jsp");
			//rDispatcher.forward(request, response);

			}else if(stateReturned.equals("Admin")) {
				
				session.setAttribute("userId", request.getParameter("theId"));
				response.sendRedirect("homea.jsp");
				
				//RequestDispatcher rDispatcher = request.getRequestDispatcher("homea.jsp");
			//rDispatcher.forward(request, response);

			}else{printWriter.println(stateReturned);}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
