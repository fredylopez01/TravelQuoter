package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import co.edu.uptc.model.Activity;
import co.edu.uptc.model.Agency;
import co.edu.uptc.model.AuxiliarNowValues;
import co.edu.uptc.model.CarRental;
import co.edu.uptc.model.Flight;
import co.edu.uptc.model.HouseRental;
import co.edu.uptc.model.Mess;
import co.edu.uptc.model.PackageService;
import co.edu.uptc.model.Service;
import co.edu.uptc.persistence.PersistenceJSON;
import co.edu.uptc.view.ViewAgency;

public class Presenter implements ActionListener, MouseListener, WindowListener {
	private Agency agencyTest;
	private ViewAgency viewTest;
	private PersistenceJSON persistenceTest;
	private AuxiliarNowValues auxuliarNow;
	
	public Presenter() {
		persistenceTest = new PersistenceJSON("data/agency.json");
		agencyTest = new Agency();
		readDatesJSON();
		viewTest = new ViewAgency(this, this, this);
		loadView();
		auxuliarNow = new AuxiliarNowValues();
		auxuliarNow.setBtnSelectNow("fligths");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		switch (comand){
		case "account"-> openChangeProfile();
		case "userProfile" -> userProfile();
		case "administratorProfile" -> administratorProfile();
		case "verifyPassword" -> verifyPassword();
		case "fligths" -> fligthNav(comand);
		case "houses" -> houseNav(comand);
		case "cars" -> carNav(comand);
		case "messes" -> messNav(comand);
		case "activities" -> activityNav(comand);
		case "packages" -> packageNav(comand);
		case "searchFlight" -> searchFlight();
		case "searchHouse" -> searchHouse();
		case "searchCar" -> searchCar();
		case "searchMess" -> searchMess();
		case "searchActivity" -> searchActivities();
		case "searchPackage" -> searchPackage();
		case "back" -> back();
		case "ok" -> viewTest.getPanelWindow().ok();
		case "viewPackage" -> viewPackage();
		case "deleteService" -> deleteService();
		case "editService" -> editService();
		case "edditFlight" -> addFlight(true);
		case "edditHouse" -> addHouse(true);
		case "edditCar" -> addCar(true);
		case "edditMess" -> addMess(true);
		case "edditActivity" -> addAcitivity(true);
		case "addService" -> addService();
		case "addFlight" -> addFlight(false);
		case "AddHouse" -> addHouse(false);
		case "addCar" -> addCar(false);
		case "addMess" -> addMess(false);
		case "addActivity" -> addAcitivity(false);
		}
	}
	
	public void readDatesJSON() {
		try {
			agencyTest = persistenceTest.readDates();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadView() {
		viewTest.getPanelWindow().valuesFlights(agencyTest.placesFlight(), agencyTest.placesSFlight(), agencyTest.classFlight());
		viewTest.getPanelWindow().valuesHouses(agencyTest.placesHouses());
		viewTest.getPanelWindow().valuesCars(agencyTest.brandsCars(), agencyTest.modelsCars(), agencyTest.placesCars());
		viewTest.getPanelWindow().valuesMess(agencyTest.placesMess(), agencyTest.sPlacesMess());
		viewTest.getPanelWindow().valuesActivities(agencyTest.placesActivities(), agencyTest.activities());
		viewTest.getPanelWindow().valuesPackages(agencyTest.placesPackages());
	}
	
	public void saveDatesJSON() {
		try {
			persistenceTest.writeDates(agencyTest);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new Presenter();
	}
	
	public void openChangeProfile() {
		viewTest.getPanelWindow().changeProfile(viewTest);
	}
	
	public void userProfile() {
		viewTest.getPanelWindow().panelUser();
		viewTest.getPanelWindow().btnFligthSelect();
		loadView();
		changePanelCenter("fligths");
		viewTest.getPanelWindow().closeChoseProfile(viewTest);
	}
	
	public void administratorProfile() {
		viewTest.getPanelWindow().panelAdministrator();
		viewTest.getPanelWindow().showDatesAdministrator(agencyTest.getFlights(), agencyTest.getHouses(), 
				agencyTest.getCars(), agencyTest.getMesses(), agencyTest.getActivities(), 
				agencyTest.getPackages(), this);
		viewTest.getPanelWindow().btnFligthSelect();
		changePanelCenter("fligths");
		viewTest.getPanelWindow().closeChoseProfile(viewTest);
	}
	
	public void verifyPassword() {
		char[] password = viewTest.getPanelWindow().getJdPassword().getPassword().getPassword();
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < password.length; i++) {
			pass.append(password[i]);
		}
		if(pass.toString().equals(agencyTest.getPassword())) {
			viewTest.getPanelWindow().passwordCorrect();
		} else {
			viewTest.getPanelWindow().message("Contraseña Incorrecta");
		}
	}
	
	public void fligthNav(String comand) {
		viewTest.getPanelWindow().btnFligthSelect();
		changePanelCenter(comand);
	}
	
	public void houseNav(String comand) {
		viewTest.getPanelWindow().btnHouseSelect();
		changePanelCenter(comand);
	}
	
	public void carNav(String comand) {
		viewTest.getPanelWindow().btnCarSelect();
		changePanelCenter(comand);
	}
	
	public void messNav(String comand) {
		viewTest.getPanelWindow().btnMessSelect();
		changePanelCenter(comand);
	}
	
	public void activityNav(String comand) {
		viewTest.getPanelWindow().btnActivitySelect();
		changePanelCenter(comand);
	}
	
	public void packageNav(String comand) {
		viewTest.getPanelWindow().btnPackageSelect();
		changePanelCenter(comand);
	}
	
	public void changePanelCenter(String comand) {
		viewTest.getPanelWindow().changePanelCenter(comand);
		auxuliarNow.setBtnSelectNow(comand);
	}
	
	public void searchFlight() {
		String[] dates = viewTest.getPanelWindow().datesSearchFlights(); 
		if(!dates[0].equals("Seleccionar") && !dates[1].equals("Seleccionar") && !dates[1].equals("Seleccionar")) {
			ArrayList<Service> flights = agencyTest.searchService(Double.parseDouble(dates[3]), dates[1], "flight");
			ArrayList<Flight> results = agencyTest.searchFlight(flights, dates[0], dates[2]);
			viewTest.getPanelWindow().showResultsFlight(results);
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void searchHouse() {
		String[] dates = viewTest.getPanelWindow().datesSearchHouse();
		if(!dates[3].equals("Seleccionar")) {
			ArrayList<Service> houses = agencyTest.searchService(Double.parseDouble(dates[4]), dates[3], "houseRental");
			ArrayList<HouseRental> results = agencyTest.searchHouseRental(houses, Integer.valueOf(dates[0]), Integer.valueOf(dates[1]), Integer.valueOf(dates[2]));
			viewTest.getPanelWindow().showResultsHouse(results);
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void searchCar() {
		String[] dates = viewTest.getPanelWindow().datesSearchCar();
		if(!dates[0].equals("Seleccionar") && !dates[1].equals("Seleccionar") && !dates[2].equals("Seleccionar")) {
			ArrayList<Service> cars = agencyTest.searchService(Double.parseDouble(dates[3]), dates[2], "carRental");
			ArrayList<CarRental> results = agencyTest.searchCarRental(cars, dates[0], Integer.valueOf(dates[1]));
			viewTest.getPanelWindow().showResultsCar(results);
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void searchMess() {
		String[] dates = viewTest.getPanelWindow().datesSearchMess();
		if(!dates[0].equals("Seleccionar") && !dates[1].equals("Seleccionar")) {
			ArrayList<Service> messes = agencyTest.searchService(Double.parseDouble(dates[2]), dates[1], "mess");
			ArrayList<Mess> results = agencyTest.searchMess(messes, Integer.valueOf(dates[3]), dates[0]);
			viewTest.getPanelWindow().showResultsMess(results);
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void searchActivities() {
		String[] dates = viewTest.getPanelWindow().datesSearchActivity();
		if(!dates[0].equals("Seleccionar") && !dates[1].equals("Seleccionar")) {
			ArrayList<Service> activities = agencyTest.searchService(Double.parseDouble(dates[2]), dates[1], "activity");
			ArrayList<Activity> results = agencyTest.searchActivities(activities, dates[0]);
			viewTest.getPanelWindow().showResultsActivity(results);
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void searchPackage() {
		String[] dates = viewTest.getPanelWindow().datesSearchPackage();
		if(!dates[1].equals("Seleccionar")) {
			ArrayList<PackageService> results = agencyTest.searchPackage(Double.parseDouble(dates[2]), Integer.parseInt(dates[0]), dates[1]);
			viewTest.getPanelWindow().showResultsPackage(results, this);
			auxuliarNow.setNowPackages(results);
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void back() {
		viewTest.getPanelWindow().changePanelCenter(auxuliarNow.getBtnSelectNow());
	}
	
	public void viewPackage() {
		int packageSelected;
		PackageService packageSelect;
		if(viewTest.getPanelWindow().isUser()) {
			packageSelected = viewTest.getPanelWindow().packageSelected();
			packageSelect= auxuliarNow.getNowPackages().get(packageSelected);
			viewTest.getPanelWindow().showPackage(packageSelect);
		} else {
			packageSelected = viewTest.getPanelWindow().packageSelectAdmin();
			packageSelect = agencyTest.getPackages().get(packageSelected);
			viewTest.getPanelWindow().showPackageAdmi(packageSelect);
		}
	}
	
	public void deleteService() {
		switch (auxuliarNow.getBtnSelectNow()) {
		case "fligths" -> deleteFlight();
		case "houses" -> deleteHouse();
		case "cars" -> deleteCar();
		case "messes" -> deleteMess();
		case "activities" -> deleteActivity();
		case "packages" -> deletePackage();
		}
	}
	
	public void deleteFlight() {
		int serviceSelect = viewTest.getPanelWindow().flightSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			agencyTest.getFlights().remove(serviceSelect);
			viewTest.getPanelWindow().deletingFlight(serviceSelect);
		}
	}
	
	public void deleteHouse() {
		int serviceSelect = viewTest.getPanelWindow().houseSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			agencyTest.getHouses().remove(serviceSelect);
			viewTest.getPanelWindow().deletingHouse(serviceSelect);
		}
	}
	
	public void deleteCar() {
		int serviceSelect = viewTest.getPanelWindow().carSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			agencyTest.getCars().remove(serviceSelect);
			viewTest.getPanelWindow().deletingCar(serviceSelect);
		}
	}
	
	public void deleteMess() {
		int serviceSelect = viewTest.getPanelWindow().messSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			agencyTest.getMesses().remove(serviceSelect);
			viewTest.getPanelWindow().deletingMess(serviceSelect);
		}
	}
	
	public void deleteActivity() {
		int serviceSelect = viewTest.getPanelWindow().activitySelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			agencyTest.getActivities().remove(serviceSelect);
			viewTest.getPanelWindow().deletingActivity(serviceSelect);
		}
	}
	
	public void deletePackage() {
		int serviceSelect = viewTest.getPanelWindow().packageSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			agencyTest.getPackages().remove(serviceSelect);
			viewTest.getPanelWindow().deletingPackage(serviceSelect);
		}
	}
	
	public void editService() {
		switch (auxuliarNow.getBtnSelectNow()) {
		case "fligths" -> edditFlight();
		case "houses" -> edditHouse();
		case "cars" -> edditCar();
		case "messes" -> edditMess();
		case "activities" -> edditActivity();
		case "packages" -> viewTest.getPanelWindow().message("No disponible para esta sección");
		}
	}
	
	public void edditService() {
		String comand = auxuliarNow.getBtnSelectNow();
		if(!comand.equals("packages")) viewTest.getPanelWindow().openPanelEddit(comand);
		else viewTest.getPanelWindow().message("No disponible para esta sección");
	}
		
	public void edditFlight() {
		int serviceSelect = viewTest.getPanelWindow().flightSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			auxuliarNow.setFlightEdditing(serviceSelect);
			Flight f = agencyTest.getFlights().get(serviceSelect);
			String[] flight =  new String[] {f.getStartingPlace(), f.getPlace(), f.gettClass(), String.valueOf(f.getCost())};
			viewTest.getPanelWindow().setDatesAddFlights(flight);
			edditService();
		}
	}
	
	public void edditHouse() {
		int serviceSelect = viewTest.getPanelWindow().houseSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			auxuliarNow.setHouseEdditing(serviceSelect);
			HouseRental h = agencyTest.getHouses().get(serviceSelect);
			String[] house =  new String[] {h.getPlace(), String.valueOf(h.getNumberRooms()), 
					String.valueOf(h.getNumberBathrooms()), String.valueOf(h.getSizeMeters()), String.valueOf(h.getCost())};
			viewTest.getPanelWindow().setDatesAddHouse(house);
			edditService();
		}
	}
	
	public void edditCar() {
		int serviceSelect = viewTest.getPanelWindow().carSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			auxuliarNow.setCarEdditing(serviceSelect);
			CarRental c = agencyTest.getCars().get(serviceSelect);
			String[] car =  new String[] {c.getBrand(), String.valueOf(c.getModel()), c.getPlace(), String.valueOf(c.getCost())};
			viewTest.getPanelWindow().setDatesAddCar(car);
			edditService();
		}
	}
	
	public void edditMess() {
		int serviceSelect = viewTest.getPanelWindow().messSelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			auxuliarNow.setMessEdditing(serviceSelect);
			Mess m = agencyTest.getMesses().get(serviceSelect);
			String[] mess =  new String[] {m.getPlace(), m.getStartingPlace(), String.valueOf(m.getSizeKg()), String.valueOf(m.getCost())};
			viewTest.getPanelWindow().setDatesAddMess(mess);
			edditService();
		}
	}
	
	public void edditActivity() {
		int serviceSelect = viewTest.getPanelWindow().activitySelectAdmin();
		if(serviceSelect == -1) noSelect();
		else {
			auxuliarNow.setActivityEddint(serviceSelect);
			Activity a = agencyTest.getActivities().get(serviceSelect);
			String[] activity =  new String[] {a.getPlace(), a.getNameActivity(), String.valueOf(a.getCost())};
			viewTest.getPanelWindow().setDatesAddActivity(activity);
			edditService();
		}
	}
	
	public void noSelect() {
		viewTest.getPanelWindow().message("Debe seleccionar un servicio");
	}
	
	public void addService() {
		String comand = auxuliarNow.getBtnSelectNow();
		if(!comand.equals("packages")) viewTest.getPanelWindow().openPanelAdd(comand);
		else viewTest.getPanelWindow().message("No disponible para esta sección");
	}
	
	public void addFlight(boolean isEdditing) {
		String[] dates = viewTest.getPanelWindow().datesAddFlights(); 
		if(!dates[0].equals("") && !dates[1].equals("") && !dates[1].equals("")) {
			Flight f = new Flight(Double.parseDouble(dates[3]), dates[1], dates[0], dates[2]);
			if(isEdditing) {
				agencyTest.getFlights().remove(auxuliarNow.getFlightEdditing());
				viewTest.getPanelWindow().deletingFlight(auxuliarNow.getFlightEdditing());
			}
			agencyTest.getFlights().add(f);
			viewTest.getPanelWindow().addFlightTable(dates);
			viewTest.getPanelWindow().changePanelCenter("fligths");
			viewTest.getPanelWindow().message("Acción Exitosa");
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void addHouse(boolean isEdditing) {
		String[] dates = viewTest.getPanelWindow().datesAddHouse();
		if(!dates[0].equals("")) {
			HouseRental h = new HouseRental(Double.parseDouble(dates[4]), dates[0],Integer.parseInt(dates[1]),
					Integer.parseInt(dates[2]), Integer.parseInt(dates[3]));
			if(isEdditing) {
				agencyTest.getHouses().remove(auxuliarNow.getHouseEdditing());
				viewTest.getPanelWindow().deletingHouse(auxuliarNow.getHouseEdditing());
			} 
			agencyTest.getHouses().add(h);
			viewTest.getPanelWindow().addHouseTable(dates);
			viewTest.getPanelWindow().changePanelCenter("houses");
			viewTest.getPanelWindow().message("Acción Exitosa");
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void addCar(boolean isEdditing) {
		String[] dates = viewTest.getPanelWindow().datesAddCar();
		if(!dates[0].equals("") && !dates[1].equals("") && !dates[2].equals("")) {
			CarRental c = new CarRental(Double.parseDouble(dates[3]), dates[2], dates[0], Integer.parseInt(dates[1]));
			if(isEdditing) {
				agencyTest.getCars().remove(auxuliarNow.getMessEdditing());
				viewTest.getPanelWindow().deletingCar(auxuliarNow.getCarEdditing());
			}
			agencyTest.getCars().add(c);
			viewTest.getPanelWindow().addCarTable(dates);
			viewTest.getPanelWindow().changePanelCenter("cars");
			viewTest.getPanelWindow().message("Acción Exitosa");
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}

	public void addMess(boolean isEdditing) {
		String[] dates = viewTest.getPanelWindow().datesAddMess();
		if(!dates[0].equals("") && !dates[1].equals("")) {
			Mess m = new Mess(Double.parseDouble(dates[3]), dates[1], Integer.parseInt(dates[2]), dates[0]);
			if(isEdditing) {
				agencyTest.getMesses().remove(auxuliarNow.getMessEdditing());
				viewTest.getPanelWindow().deletingMess(auxuliarNow.getMessEdditing());
			} 
			agencyTest.getMesses().add(m);
			viewTest.getPanelWindow().addMessTable(dates);
			viewTest.getPanelWindow().changePanelCenter("messes");
			viewTest.getPanelWindow().message("Acción Exitosa");
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void addAcitivity(boolean isEdditing) {
		String[] dates = viewTest.getPanelWindow().datesAddActivity();
		if(!dates[0].equals("") && !dates[1].equals("")) {
			Activity a = new Activity(Double.parseDouble(dates[2]), dates[0], dates[1]);
			if(isEdditing) {
				agencyTest.getActivities().remove(auxuliarNow.getActivityEddint());
				viewTest.getPanelWindow().deletingActivity(auxuliarNow.getActivityEddint());
			} 
			agencyTest.getActivities().add(a);
			viewTest.getPanelWindow().addActivityTable(dates);
			viewTest.getPanelWindow().changePanelCenter("activities");
			viewTest.getPanelWindow().message("Acción Exitosa");
		} else {
			viewTest.getPanelWindow().message("Es necesario llenar todos los campos");
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		JButton a = (JButton) e.getSource();
		String comand = a.getActionCommand();
		switch (comand) {
		case "fligths" -> buttonHover(a);
		case "houses" -> buttonHover(a);
		case "cars" -> buttonHover(a);
		case "messes" -> buttonHover(a);
		case "activities" -> buttonHover(a);
		case "packages" ->	buttonHover(a);
		}
	}
	
	public void buttonHover(JButton a) {
		if(viewTest.getPanelWindow().btnHover(a).equals(a.getActionCommand())) {
				auxuliarNow.setBtnSelectNow(a.getActionCommand());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton a = (JButton) e.getSource();
		String comand = a.getActionCommand();
		switch (comand) {
		case "fligths" -> buttonNormal(a);
		case "houses" -> buttonNormal(a);
		case "cars" -> buttonNormal(a);
		case "messes" -> buttonNormal(a);
		case "activities" -> buttonNormal(a);
		case "packages" ->	buttonNormal(a);
		}
	}
	
	public void buttonNormal(JButton a) {
		if(auxuliarNow.getBtnSelectNow().equals(a.getActionCommand())) {
			viewTest.getPanelWindow().btnNormal(a, true);
		} else viewTest.getPanelWindow().btnNormal(a, false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		saveDatesJSON();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}