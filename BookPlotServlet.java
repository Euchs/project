package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookPlotServlet
 */
@WebServlet(description = "Booking A Plot", urlPatterns = { "/BookPlotServlet" })
public class BookPlotServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Plots plots = new Plots();
		HttpSession session = request.getSession(false);
		
		
		try {
			if(session!=null) {
			String plotLabel = request.getParameter("theLabel");
			
			String regNo = (String)session.getAttribute("userId");
			PrintWriter printWriter = response.getWriter();
			String state = plots.bookPlot(plotLabel, regNo);
			printWriter.println(state);}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
