package manageProjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookPlotServlet
 */
@WebServlet(description = "Booking A Plot", urlPatterns = { "/BookPlotServlet" })
public class BookPlotServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Plots plots = new Plots();
		//RequestDispatcher rDispatcher = request.getRequestDispatcher("target.jsp");
		
		
		try {
			String plotLabel = request.getParameter("theLabel");
			String regNo = request.getParameter("theReg");
			PrintWriter printWriter = response.getWriter();
			String state = plots.bookPlot(plotLabel, regNo);
			printWriter.println(state);
			/*request.setAttribute("plots", list);
			rDispatcher.forward(request, response);*/
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
