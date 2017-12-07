package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.*;
import utils.*;

@WebServlet(urlPatterns = { "/makeReservation" })
public class MakeReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MakeReservationServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String queryString = request.getQueryString();
		if (queryString == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		String airline = request.getParameter("airline");
		String flight = request.getParameter("flight");
		String departAirport = request.getParameter("depart");
		String arriveAirport = request.getParameter("arrive");
		
		// find stopNo of the departId and arriveAiportId -> can be stop 1 and stop 4 meaning all stops
		// between 1 and 4. Total fare = f.Fare * 4, currentDate, random reservation number
		
		// int [] stops = DBUtils.getStopDifference(departAirport, arriveAirport);
		// double fare = (stops[1] - stops[0] + 1) * findFare(airline, flight);
		
		// pass in all args and fare
		Connection conn = MyUtils.getStoredConnection(request);

		String errorString = null;

		request.setAttribute("errorString", errorString);
		request.setAttribute("airline", airline);
		request.setAttribute("flight", flight);
		request.setAttribute("departAirport", departAirport);
		request.setAttribute("arriveAirport", arriveAirport);
		if (flight != null) {
			String seatNum = DBUtils.generateSeatNumber(conn, airline, Integer.parseInt(flight));
			request.setAttribute("seatNum", seatNum);
		}
		

		
		// jsp should have options to select for meal and seat
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/makeReservation.jsp");
		dispatcher.forward(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// get meal and seat #
		int numSeats = Integer.parseInt(request.getParameter("numSeats"));
		String seat = request.getParameter("seatNum");
		// fill in rest of info that's stored
		Reservation reservation = new Reservation();
//		request.setAttribute("newReservation", reservation);
		// user goes to checkout and makes reservation if they "successfully" pay
		response.sendRedirect(request.getContextPath() + "/checkout");
		
 
	}

}