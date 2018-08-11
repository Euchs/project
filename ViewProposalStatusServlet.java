package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProposalStatusServlet
 */
@WebServlet(description = "Check if a proposal has been approved", urlPatterns = { "/ViewProposalStatusServlet" })
public class ViewProposalStatusServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Proposal proposal = new Proposal();
		//RequestDispatcher rDispatcher = request.getRequestDispatcher("target.jsp");
		PrintWriter printWriter = response.getWriter();
		try {
			
			String stateReturned = proposal.viewProposalStatus(request.getParameter("theNum"));
			printWriter.println(stateReturned);
			/*request.setAttribute("plots", list);
			rDispatcher.forward(request, response);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
