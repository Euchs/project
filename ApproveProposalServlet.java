package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApproveProposalServlet
 */
@WebServlet(description = "Approve a submitted proposal", urlPatterns = { "/ApproveProposalServlet" })
public class ApproveProposalServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Proposal proposal = new Proposal();
		
		PrintWriter printWriter = response.getWriter();
		try {
			
			String stateReturned = proposal.approveProposal(request.getParameter("theNum"));
			printWriter.println(stateReturned);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
