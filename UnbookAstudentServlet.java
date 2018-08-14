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
 * Servlet implementation class UnbookAstudentServlet
 */
@WebServlet(description = "Removes A booker from the database", urlPatterns = { "/UnbookAstudentServlet" })
public class UnbookAstudentServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Plots plots = new Plots();

		try {
			String regNo = request.getParameter("theReg");
			PrintWriter printWriter = response.getWriter();
			String state = plots.unbook(regNo);
			printWriter.println(state);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
