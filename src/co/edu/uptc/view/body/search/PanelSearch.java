package co.edu.uptc.view.body.search;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class PanelSearch extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelFlight fligths;
	private PanelHouse houses;
	private PanelCar cars;
	private PanelMess messes;
	private PanelActivity activities;
	private PanelPackage packages;

	public PanelSearch(ActionListener listener) {
		setLayout(new CardLayout(0, 0));
		
		fligths = new PanelFlight(listener);
		add(fligths, "fligths");
		
		houses = new PanelHouse(listener);
		add(houses, "houses");
		
		cars = new PanelCar(listener);
		add(cars, "cars");
		
		messes = new PanelMess(listener);
		add(messes, "messes");
		
		activities = new PanelActivity(listener);
		add(activities, "activities");
		
		packages = new PanelPackage(listener);
		add(packages, "packages");
	}
	
	public void valuesFlights(String[] places, String[] Splaces, String[] classP) {
		fligths.getPlace().setModel(new DefaultComboBoxModel<String>(places));
		fligths.getStartingPlace().setModel(new DefaultComboBoxModel<>(Splaces));
		fligths.getClassF().setModel(new DefaultComboBoxModel<String>(classP));
	}
	
	public void valuesHouses(String[] places) {
		houses.getPlace().setModel(new DefaultComboBoxModel<>(places));
	}
	
	public void valuesCars(String[] brands, String[] models, String[] places) {
		cars.getBrand().setModel(new DefaultComboBoxModel<>(brands));
		cars.getModel().setModel(new DefaultComboBoxModel<>(models));
		cars.getPlace().setModel(new DefaultComboBoxModel<>(places));
	}
	
	public void valuesMess(String[] places, String[] placesS) {
		messes.getPlace().setModel(new DefaultComboBoxModel<>(places));
		messes.getStartingPlace().setModel(new DefaultComboBoxModel<>(placesS));
	}
	
	public void valuesActivities(String[] places, String[] activitiesV) {
		activities.getPlace().setModel(new DefaultComboBoxModel<>(places));
		activities.getActivity().setModel(new DefaultComboBoxModel<>(activitiesV));
	}
	
	public void valuesPackages(String[] places) {
		packages.getPlace().setModel(new DefaultComboBoxModel<>(places));
	}

	public PanelFlight getFligths() {
		return fligths;
	}

	public void setFligths(PanelFlight fligths) {
		this.fligths = fligths;
	}

	public PanelHouse getHouses() {
		return houses;
	}

	public void setHouses(PanelHouse houses) {
		this.houses = houses;
	}

	public PanelCar getCars() {
		return cars;
	}

	public void setCars(PanelCar cars) {
		this.cars = cars;
	}

	public PanelMess getMesses() {
		return messes;
	}

	public void setMesses(PanelMess messes) {
		this.messes = messes;
	}

	public PanelActivity getActivities() {
		return activities;
	}

	public void setActivities(PanelActivity activities) {
		this.activities = activities;
	}

	public PanelPackage getPackages() {
		return packages;
	}

	public void setPackages(PanelPackage packages) {
		this.packages = packages;
	}
	
}
