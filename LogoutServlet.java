package manageProjects;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "directs one back to the index page", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Users users = new Users();
		HttpSession session = request.getSession(false);

		try { if(session!=null) {
			users.logout((String)session.getAttribute("userId"));
			session.invalidate();
			response.sendRedirect("index.html");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
