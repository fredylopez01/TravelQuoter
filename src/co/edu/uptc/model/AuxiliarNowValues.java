package co.edu.uptc.model;

import java.util.ArrayList;

public class AuxiliarNowValues {
	private ArrayList<PackageService> nowPackages;
	private String btnSelectNow;
	private int flightEdditing;
	private int houseEdditing;
	private int carEdditing;
	private int messEdditing;
	private int activityEddint;

	public ArrayList<PackageService> getNowPackages() {
		return nowPackages;
	}

	public void setNowPackages(ArrayList<PackageService> nowPackages) {
		this.nowPackages = nowPackages;
	}

	public String getBtnSelectNow() {
		return btnSelectNow;
	}

	public void setBtnSelectNow(String btnSelectNow) {
		this.btnSelectNow = btnSelectNow;
	}

	public int getFlightEdditing() {
		return flightEdditing;
	}

	public void setFlightEdditing(int flightEdditing) {
		this.flightEdditing = flightEdditing;
	}

	public int getHouseEdditing() {
		return houseEdditing;
	}

	public void setHouseEdditing(int houseEdditing) {
		this.houseEdditing = houseEdditing;
	}

	public int getCarEdditing() {
		return carEdditing;
	}

	public void setCarEdditing(int carEdditing) {
		this.carEdditing = carEdditing;
	}

	public int getMessEdditing() {
		return messEdditing;
	}

	public void setMessEdditing(int messEdditing) {
		this.messEdditing = messEdditing;
	}

	public int getActivityEddint() {
		return activityEddint;
	}

	public void setActivityEddint(int activityEddint) {
		this.activityEddint = activityEddint;
	}
	
}
