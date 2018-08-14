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
 * Servlet implementation class SubmittedProposalsServlet
 */
@WebServlet(description = "Check the submitted proposals", urlPatterns = { "/SubmittedProposalsServlet" })
public class SubmittedProposalsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Proposal proposal = new Proposal();
		
		PrintWriter printWriter = response.getWriter();
		try {
			ArrayList<String> list = proposal.checkSubmittedProposalsIds();
			printWriter.println("Here are the students who have already submitted their proposals ");
			for(int i=0; i<list.size();i++) {printWriter.println("Student Reg Number: " + list.get(i));}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
