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
 * Servlet implementation class AllBookersServlet
 */
@WebServlet(description = "See The Students who have booked a plot", urlPatterns = { "/AllBookersServlet" })
public class AllBookersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Plots plots = new Plots();
		
		PrintWriter printWriter = response.getWriter();
		try {
			ArrayList<String> list = plots.checkAvailableBookers();
			printWriter.println("Here are the students who have booked plots already ");
			int i=0;
			while(i<list.size()) {printWriter.print("Reg Number: "+list.get(i) + "   ");printWriter.println("Plot Booked: "+list.get(i+1));i=i+2;}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
