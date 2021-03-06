package classes;
public class ReservationPassenger {
	Reservation reservation;
	Passenger passenger;
	private String seatNo;
	private String flightClass;
	private String meal;
	
	public ReservationPassenger () {
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}
}
