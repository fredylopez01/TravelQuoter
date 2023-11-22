package co.edu.uptc.model;

import java.util.ArrayList;

public class PackageService {
	private ArrayList<Flight> flights;
	private ArrayList<HouseRental> houses;
	private ArrayList<CarRental> cars;
	private ArrayList<Mess> messes;
	private ArrayList<Activity> activities;
	private double cost;
	private int numberServices;
	private String place;
	
	public PackageService() {
		flights = new ArrayList<Flight>();
		houses = new ArrayList<HouseRental>();
		cars = new ArrayList<CarRental>();
		messes = new ArrayList<Mess>();
		activities = new ArrayList<Activity>();
	}
	
	public boolean addService(Service service) {
		boolean isAdd= false;
		if(verifyPlace(service)) {
			switch (service.getType()) {
			case "flight" -> isAdd = flights.add((Flight) service);
			case "houseRental" -> isAdd = houses.add((HouseRental) service);
			case "carRental" -> isAdd = cars.add((CarRental) service);
			case "mess" -> isAdd = messes.add((Mess) service);
			case "activity" -> isAdd = activities.add((Activity) service);
			}
		}
		getCost();
		getNumberServices();
		return isAdd;
	}
	
	public boolean verifyPlace(Service service) {
		boolean isSamePlace = false;
		if(place == null) {
			place = service.getPlace();
			isSamePlace = true;
		} else if(place.equals(service.getPlace())){
			isSamePlace = true;
		}
		return isSamePlace;
	}
	
	public double getCost() {
		cost = getCostFlights();
		cost += getCostHouses();
		cost += getCostCars();
		cost += getCostMesses();
		cost += getCostActivities();
		return cost;
	}
	
	public double getCostFlights() {
		double costType = 0;
		for(Flight i: flights) {
			costType += i.getCost();
		}
		return costType;
	}
	
	public double getCostHouses() {
		double costType = 0;
		for(HouseRental i: houses) {
			costType += i.getCost();
		}
		return costType;
	}
	
	public double getCostCars() {
		double costType = 0;
		for(CarRental i: cars) {
			costType += i.getCost();
		}
		return costType;
	}
	
	public double getCostMesses() {
		double costType = 0;
		for(Mess i: messes) {
			costType += i.getCost();
		}
		return costType;
	}
	
	public double getCostActivities() {
		double costType = 0;
		for(Activity i: activities) {
			costType += i.getCost();
		}
		return costType;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getNumberServices() {
		numberServices = flights.size();
		numberServices += houses.size();
		numberServices += cars.size();
		numberServices += messes.size();
		numberServices += activities.size();
		return numberServices;
	}

	public void setNumberServices(int numberServices) {
		this.numberServices = numberServices;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	public ArrayList<HouseRental> getHouses() {
		return houses;
	}

	public void setHouses(ArrayList<HouseRental> houses) {
		this.houses = houses;
	}

	public ArrayList<CarRental> getCars() {
		return cars;
	}

	public void setCars(ArrayList<CarRental> cars) {
		this.cars = cars;
	}

	public ArrayList<Mess> getMesses() {
		return messes;
	}

	public void setMesses(ArrayList<Mess> messes) {
		this.messes = messes;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

}
