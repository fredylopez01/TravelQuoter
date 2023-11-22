package co.edu.uptc.model;

public class Mess extends Service {
	private int sizeKg;
	private String startingPlace;
	
	public Mess(double cost, String place, int sizeKg, String startingPlace) {
		super(cost, place, "mess");
		this.sizeKg = sizeKg;
		this.startingPlace = startingPlace;
	}
	
	public int getSizeKg() {
		return sizeKg;
	}
	public void setSizeKg(int sizeKg) {
		this.sizeKg = sizeKg;
	}
	public String getStartingPlace() {
		return startingPlace;
	}
	public void setStartingPlace(String startingPlace) {
		this.startingPlace = startingPlace;
	}
	
}
