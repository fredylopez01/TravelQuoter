package co.edu.uptc.model;

public class CarRental extends Service {
	private String brand;
	private int model;
	
	public CarRental(double cost, String place, String brand, int model) {
		super(cost, place, "carRental");
		this.brand = brand;
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	
}
