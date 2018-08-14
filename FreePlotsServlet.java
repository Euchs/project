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
 * Servlet implementation class FreePlotsServlet
 */
@WebServlet(description = "checks for free plots", urlPatterns = { "/getFreePlots" })
public class FreePlotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Plots plots = new Plots();
		
		PrintWriter printWriter = response.getWriter();
		try {
			ArrayList<String> list = plots.checkFreePlots();
			printWriter.println("Here are all the availabble free plots ");
			for(int i=0; i<list.size();i++) {printWriter.println("Plot: "+list.get(i));}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		

}
