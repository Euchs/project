package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewCommentServlet
 */
@WebServlet(description = "See the latest comments by lecturer on your project", urlPatterns = { "/ViewCommentServlet" })
public class ViewCommentServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Project project= new Project();
		HttpSession session = request.getSession(false);
		
		PrintWriter printWriter = response.getWriter();
		try {
			
			if(session!=null) {
			String stateReturned = project.viewComment((String)session.getAttribute("userId"));
			printWriter.println(stateReturned);}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
