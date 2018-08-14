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
 * Servlet implementation class ViewProposalStatuslServlet
 */
@WebServlet(description = "lecturer view latest comments on student project", urlPatterns = { "/ViewProposalStatuslServlet" })
public class ViewProposalStatuslServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Proposal proposal = new Proposal();
		HttpSession session = request.getSession(false);
		
		PrintWriter printWriter = response.getWriter();
		try {
			
			if(session!=null) {
			String stateReturned = proposal.viewProposalStatus(request.getParameter("theNum"));
			printWriter.println(stateReturned);}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
