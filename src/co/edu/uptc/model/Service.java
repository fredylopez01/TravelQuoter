package co.edu.uptc.model;

public abstract class Service {
	double cost;
	String place;
	String type;
	
	public Service(double cost, String place, String type) {
		super();
		this.cost = cost;
		this.place = place;
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
