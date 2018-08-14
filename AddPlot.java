package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPlot
 */
@WebServlet(description = "Adds a new plot to the database", urlPatterns = { "/AddPlot" })
public class AddPlot extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Plots plots = new Plots();
		
		
		PrintWriter printWriter = response.getWriter();
		try {
			String stateReturned = plots.addPlot(request.getParameter("theLabel"));
			
			/*printWriter.print("<html><head>");
			printWriter.print("<script type=\"text/javascript\">alert("+stateReturned+"");
			printWriter.print("</head><body></body></html>");*/
			printWriter.println(stateReturned);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
