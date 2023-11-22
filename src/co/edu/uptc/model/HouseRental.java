package co.edu.uptc.model;

public class HouseRental extends Service {
	private int numberRooms;
	private int numberBathrooms;
	private int sizeMeters;
	
	public HouseRental(double cost, String place,int numberRooms, int numberBathrooms, int sizeMeters) {
		super(cost, place, "houseRental");
		this.numberRooms = numberRooms;
		this.numberBathrooms = numberBathrooms;
		this.sizeMeters = sizeMeters;
	}
	public int getNumberRooms() {
		return numberRooms;
	}
	public void setNumberRooms(int numberRooms) {
		this.numberRooms = numberRooms;
	}
	public int getNumberBathrooms() {
		return numberBathrooms;
	}
	public void setNumberBathrooms(int numberBathrooms) {
		this.numberBathrooms = numberBathrooms;
	}
	public int getSizeMeters() {
		return sizeMeters;
	}
	public void setSizeMeters(int sizeMeters) {
		this.sizeMeters = sizeMeters;
	}
	
}
