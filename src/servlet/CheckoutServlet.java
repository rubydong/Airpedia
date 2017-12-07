package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import classes.Reservation;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/checkout" })
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CheckoutServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        String queryString = request.getQueryString();
      
        System.out.println("-------------------" + queryString);
        
//		int numSeats = Integer.parseInt(request.getParameter("numPeople"));
//		String seat = request.getParameter("seatNum");
		String airline = request.getParameter("airline");
		String flight = request.getParameter("flight");
		String fare = request.getParameter("fare");
		String food = request.getParameter("food");
		String tripType = request.getParameter("tripType");
		String classType = request.getParameter("classType");
		String departLegNo = request.getParameter("depLegNo");
		String arriveLegNo = request.getParameter("arrLegNo");
		
		System.out.printf("helloCheckout \n airline: %s, flight: %s, departLegNo: %s, arriveLegNo: %s, fare: %s, food: %s, tripType: %s, classType: %s",
				airline, flight, departLegNo, arriveLegNo, fare, food, tripType, classType);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/checkoutView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        // add reservation
       
    }
 
}
