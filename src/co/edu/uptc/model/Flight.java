package co.edu.uptc.model;

public class Flight extends Service {
	String startingPlace;
	String tClass;
	
	public Flight(double cost, String place, String startingPlace, String tClass) {
		super(cost, place, "flight");
		this.startingPlace = startingPlace;
		this.tClass = tClass;
	}
	
	public String getStartingPlace() {
		return startingPlace;
	}
	public void setStartingPlace(String startingPlace) {
		this.startingPlace = startingPlace;
	}
	public String gettClass() {
		return tClass;
	}
	public void settClass(String tClass) {
		this.tClass = tClass;
	}	
}
