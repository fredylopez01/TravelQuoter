package co.edu.uptc.view.body.write;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelAdd extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelFlightAdd fligths;
	private PanelHouseAdd houses;
	private PanelCarAdd cars;
	private PanelMessAdd messes;
	private PanelActivityAdd activities;
//	private PanelPackage packages;

	public PanelAdd(ActionListener listener) {
		setLayout(new CardLayout(0, 0));
		
		fligths = new PanelFlightAdd(listener);
		add(fligths, "fligthsAdd");
		
		houses = new PanelHouseAdd(listener);
		add(houses, "housesAdd");
		
		cars = new PanelCarAdd(listener);
		add(cars, "carsAdd");
		
		messes = new PanelMessAdd(listener);
		add(messes, "messesAdd");
		
		activities = new PanelActivityAdd(listener);
		add(activities, "activitiesAdd");
//		
//		packages = new PanelPackage(listener);
//		add(packages, "packagesAdd");
	}
	

	public PanelFlightAdd getFligths() {
		return fligths;
	}

	public void setFligths(PanelFlightAdd fligths) {
		this.fligths = fligths;
	}

	public PanelHouseAdd getHouses() {
		return houses;
	}

	public void setHouses(PanelHouseAdd houses) {
		this.houses = houses;
	}

	public PanelCarAdd getCars() {
		return cars;
	}

	public void setCars(PanelCarAdd cars) {
		this.cars = cars;
	}

	public PanelMessAdd getMesses() {
		return messes;
	}

	public void setMesses(PanelMessAdd messes) {
		this.messes = messes;
	}

	public PanelActivityAdd getActivities() {
		return activities;
	}

	public void setActivities(PanelActivityAdd activities) {
		this.activities = activities;
	}
//
//	public PanelPackage getPackages() {
//		return packages;
//	}
//
//	public void setPackages(PanelPackage packages) {
//		this.packages = packages;
//	}
	
}
