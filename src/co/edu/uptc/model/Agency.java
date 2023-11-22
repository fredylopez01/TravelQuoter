package co.edu.uptc.model;

import java.util.ArrayList;

public class Agency {
	private String password;
	private ArrayList<Flight> flights;
	private ArrayList<HouseRental> houses;
	private ArrayList<CarRental> cars;
	private ArrayList<Mess> messes;
	private ArrayList<Activity> activities;
	private ArrayList<PackageService> packages;
	
	public Agency() {
		flights = new ArrayList<Flight>();
		houses = new ArrayList<>();
		cars = new ArrayList<>();
		messes = new ArrayList<>();
		activities = new ArrayList<>();
		packages = new ArrayList<PackageService>();
	}
	
	public ArrayList<Service> searchService(double price, String place, String type){
		ArrayList<Service> servicesResult = new ArrayList<>();
		ArrayList<Service> services = new ArrayList<>();
		switch(type) {
		case "flight" -> services.addAll(flights);
		case "houseRental" -> services.addAll(houses);
		case "carRental" -> services.addAll(cars);
		case "mess" -> services.addAll(messes);
		case "activity" -> services.addAll(activities);
		}
		for(Service i: services) {
			if(i.getType().equals(type) && i.getPlace().equals(place)) {
				if(i.getCost() >= (price-50000) && i.getCost() <= (price+50000)) {
					servicesResult.add(i);
				}
			}
		}
		return servicesResult;
	}
	
	public ArrayList<Flight> searchFlight(ArrayList<Service> flightsP, String startingPlace, String clas){
		ArrayList<Flight> flightsResult = new ArrayList<>();
		for(Service i: flightsP) {
			Flight f = (Flight) i;
			if (f.getStartingPlace().equals(startingPlace) && f.gettClass().equals(clas)){
				flightsResult.add(f);
			}
		}
		return flightsResult;
	}
	
	public ArrayList<HouseRental> searchHouseRental(ArrayList<Service> housesP, int numberRooms, int numberBathrooms, int sizeMeters){
		ArrayList<HouseRental> housesResult = new ArrayList<>();
		for(Service i: housesP) {
			HouseRental h =  (HouseRental) i;
			if (h.getNumberRooms() == numberRooms && h.getNumberBathrooms() == numberBathrooms 
					&& h.getSizeMeters() == sizeMeters) {
				housesResult.add(h);
			}
		}
		return housesResult;
	}
	
	public ArrayList<CarRental> searchCarRental(ArrayList<Service> carsP, String brand, int model){
		ArrayList<CarRental> carsResult = new ArrayList<>();
		for(Service i: carsP) {
			CarRental c =  (CarRental) i;
			if (c.getBrand().equals(brand) && c.getModel() == model) {
				carsResult.add(c);
			}
		}
		return carsResult;
	}
	
	public ArrayList<Mess> searchMess(ArrayList<Service> messesP, int sizeKg, String startingPlace){
		ArrayList<Mess> messesResult = new ArrayList<>();
		for(Service i: messesP) {
			Mess m =  (Mess) i;
			if (m.getSizeKg() == sizeKg && m.getStartingPlace().equals(startingPlace)) {
				messesResult.add(m);
			}
		}
		return messesResult;
	}
	
	public ArrayList<Activity> searchActivities(ArrayList<Service> activitiesP, String nameActivity){
		ArrayList<Activity> activitiesResult = new ArrayList<>();
		for(Service i: activitiesP) {
			Activity a =  (Activity) i;
			if (a.getNameActivity().equals(nameActivity)) {
				activitiesResult.add(a);
			}
		}
		return activitiesResult;
	}
	
	public ArrayList<PackageService> searchPackage(double price, int numberServices, String place){
		ArrayList<PackageService> activitiesResult = new ArrayList<>();
		for(PackageService i: packages) {
			if (i.getNumberServices() == numberServices && place.equals(i.getPlace())) {
				if(i.getCost() > (price-50000) && i.getCost() < (price+50000)) {
					activitiesResult.add(i);
				}
			}
		}
		return activitiesResult;
	}
	
	public String[] placesFlight() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Flight i: flights) {
			if(!items.contains(i.getPlace())) {
				items.add(i.getPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] placesSFlight() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Flight i: flights) {
			if(!items.contains(i.getStartingPlace())) {
				items.add(i.getStartingPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] classFlight() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Flight i: flights) {
			if(!items.contains(i.gettClass())) {
				items.add(i.gettClass());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] placesHouses() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(HouseRental i: houses) {
			if(!items.contains(i.getPlace())) {
				items.add(i.getPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] brandsCars() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(CarRental i: cars) {
			if(!items.contains(i.getBrand())) {
				items.add(i.getBrand());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] modelsCars() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(CarRental i: cars) {
			if(!items.contains(String.valueOf(i.getModel()))) {
				items.add(String.valueOf(i.getModel()));
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] placesCars() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(CarRental i: cars) {
			if(!items.contains(i.getPlace())) {
				items.add(i.getPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] sPlacesMess() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Mess i: messes) {
			if(!items.contains(i.getStartingPlace())) {
				items.add(i.getStartingPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] placesMess() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Mess i: messes) {
			if(!items.contains(i.getPlace())) {
				items.add(i.getPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] placesActivities() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Activity i: activities) {
			if(!items.contains(i.getPlace())) {
				items.add(i.getPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] activities() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(Activity i: activities) {
			if(!items.contains(i.getNameActivity())) {
				items.add(i.getNameActivity());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] placesPackages() {
		ArrayList<String> items = new ArrayList<>();
		items.add("Seleccionar");
		for(PackageService i: packages) {
			if(!items.contains(i.getPlace())) {
				items.add(i.getPlace());
			}
		}
		return arrayListToArray(items);
	}
	
	public String[] arrayListToArray(ArrayList<String> items) {
		String[] itemsR = new String[items.size()];
		for(int i = 0; i < items.size(); i++) {
			itemsR[i] = items.get(i);
		}
		return itemsR;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public ArrayList<PackageService> getPackages() {
		return packages;
	}

	public void setPackages(ArrayList<PackageService> packages) {
		this.packages = packages;
	}
	
}
