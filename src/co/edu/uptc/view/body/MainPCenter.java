package co.edu.uptc.view.body;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.model.Activity;
import co.edu.uptc.model.CarRental;
import co.edu.uptc.model.Flight;
import co.edu.uptc.model.HouseRental;
import co.edu.uptc.model.Mess;
import co.edu.uptc.model.PackageService;
import co.edu.uptc.view.body.response.PanelCenter;
import co.edu.uptc.view.body.response.PanelCenterAdmin;
import co.edu.uptc.view.body.response.PanelCenterUser;
import co.edu.uptc.view.body.response.PanelMaxCenterAdmin;

public class MainPCenter extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelCenterUser panelUser;
	private CardLayout layoutUser;
	private PanelMaxCenterAdmin panelAdminist;
	private CardLayout layoutAdminist;
	
	public MainPCenter(ActionListener listener) {
		setLayout(new CardLayout());
		
		panelUser = new PanelCenterUser(listener);
		add(panelUser, "panelUser");
		layoutUser = (CardLayout) panelUser.getLayout();
		layoutUser.show(panelUser, "panelSearch");
		
		panelAdminist = new PanelMaxCenterAdmin(listener);
		add(panelAdminist, "panelAdministrator");
		layoutAdminist = (CardLayout) panelAdminist.getPanelC().getLayout();
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void changePanelCenter(String panel, boolean isUser) {
		if(isUser) {
			panelUser.changePanelSearch(panel);
			layoutUser.show(panelUser, "panelSearch");
		} else {
			panelAdminist.getPanelC().changePanelResponse(panel);
			panelAdminist.noBtnAddServicePackage();
			layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
		}
	}
	
	public String[] searchFligth() {
		return panelUser.getPanelSearch().getFligths().getDates();
	}
	
	public void showResultFligths(ArrayList<Flight> flights) {
		if(flights.size() != 0) {
			panelUser.showResultFligths(flights);
			layoutUser.show(panelUser, "panelResponse");
		} else noResults();
	}
	
	public String[] searchHouse() {
		return panelUser.getPanelSearch().getHouses().getDates();
	}
	
	public void showResultHouses(ArrayList<HouseRental> houses) {
		if(houses.size() != 0) {
			panelUser.showResultHouses(houses);
			layoutUser.show(panelUser, "panelResponse");
		} else noResults();
	}
	
	public String[] searchCar() {
		return panelUser.getPanelSearch().getCars().getDates();
	}

	public void showResultCars(ArrayList<CarRental> cars) {
		if(cars.size()!=0) {
			panelUser.showResultCars(cars);
			layoutUser.show(panelUser, "panelResponse");
		} else noResults();
	}
	
	public String[] searchMess() {
		return panelUser.getPanelSearch().getMesses().getDates();
	}
	
	public void showResultMess(ArrayList<Mess> mess) {
		if(mess.size()!= 0) {
			panelUser.showResultMess(mess);
			layoutUser.show(panelUser, "panelResponse");
		} else noResults();
	}
	
	public String[] searchActivity() {
		return panelUser.getPanelSearch().getActivities().getDates();
	}
	
	public void showResultActivity(ArrayList<Activity> activities) {
		if(activities.size() != 0) {
			panelUser.showResultActivity(activities);
			layoutUser.show(panelUser, "panelResponse");
		} else noResults();
	}
	
	public String[] searchPackage() {
		return panelUser.getPanelSearch().getPackages().getDates();
	}
	
	public void showResultPackage(ArrayList<PackageService> packages, ActionListener listener, boolean isAdministrator) {
		if(packages.size()!=0) {
			panelUser.showResultPackage(packages, listener, isAdministrator);
			layoutUser.show(panelUser, "panelResponse");
		} else noResults();
	}
	
	public void noResults() {
		layoutUser.show(panelUser, "panelNoResults");
	}
	
	public int packageSelect() {
		return panelUser.getPanelResponse().getResponsePackages().getResults().getSelectedRow();
	}
	
	public void showPackage(PackageService packageSelect) {
		panelUser.showPackage(packageSelect);
		layoutUser.show(panelUser, "panelShowPackage");
	}

	public void showDatesAdministrator(ArrayList<Flight> f, ArrayList<HouseRental> h, ArrayList<CarRental> c,
			ArrayList<Mess> m, ArrayList<Activity> a,ArrayList<PackageService> p, ActionListener listener) {
		showFlightsAdmi(f);
		showHousesAdmi(h);
		showCarsAdmi(c);
		showMessAdmi(m);
		showActivitiesAdmi(a);
		showPackagesAdmi(p, listener);
	}
	
	public void showFlightsAdmi(ArrayList<Flight> flights) {
		panelAdminist.getPanelC().showResultFligths(flights);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void showHousesAdmi(ArrayList<HouseRental> houses) {
		panelAdminist.getPanelC().showResultHouses(houses);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void showCarsAdmi(ArrayList<CarRental> c) {
		panelAdminist.getPanelC().showResultCars(c);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void showMessAdmi(ArrayList<Mess> m) {
		panelAdminist.getPanelC().showResultMess(m);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void showActivitiesAdmi(ArrayList<Activity> a) {
		panelAdminist.getPanelC().showResultActivity(a);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void showPackagesAdmi(ArrayList<PackageService> p, ActionListener listener) {
		panelAdminist.getPanelC().showResultPackage(p, listener, true);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelResponse");
	}
	
	public void showPackageAdmi(PackageService packageSelect) {
		panelAdminist.getPanelC().showPackage(packageSelect);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelShowPackage");
	}
	
	public int flightSelectAdmin() {
		return panelAdminist.getPanelC().getPanelResponse().getResponseFlight().getResults().getSelectedRow();
	}
	
	public void deleteFlight(int row) {
		if(panelAdminist.getPanelC().getPanelResponse().getResponseFlight().getResults().isEditing()) {
			panelAdminist.getPanelC().getPanelResponse().getResponseFlight().getResults().getCellEditor().stopCellEditing();
		}
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseFlight().getResults().getModel();
		model.removeRow(row);
	}
	
	public int houseSelectAdmin() {
		return panelAdminist.getPanelC().getPanelResponse().getResponseHouse().getResults().getSelectedRow();	
	}
	
	public void deleteHouse(int row) {
		if(panelAdminist.getPanelC().getPanelResponse().getResponseHouse().getResults().isEditing()) {
			panelAdminist.getPanelC().getPanelResponse().getResponseHouse().getResults().getCellEditor().stopCellEditing();
		}
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseHouse().getResults().getModel();
		model.removeRow(row);
	}
	
	public int carSelectAdmin() {
		return panelAdminist.getPanelC().getPanelResponse().getResponseCar().getResults().getSelectedRow();	
	}
	
	public void deleteCar(int row) {
		if(panelAdminist.getPanelC().getPanelResponse().getResponseCar().getResults().isEditing()) {
			panelAdminist.getPanelC().getPanelResponse().getResponseCar().getResults().getCellEditor().stopCellEditing();
		}
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseCar().getResults().getModel();
		model.removeRow(row);
	}
	
	public int messSelectAdmin() {
		return panelAdminist.getPanelC().getPanelResponse().getResponseMess().getResults().getSelectedRow();	
	}
	
	public void deleteMess(int row) {
		if(panelAdminist.getPanelC().getPanelResponse().getResponseMess().getResults().isEditing()) {
			panelAdminist.getPanelC().getPanelResponse().getResponseMess().getResults().getCellEditor().stopCellEditing();
		}
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseMess().getResults().getModel();
		model.removeRow(row);
	}
	
	public int activitySelectAdmin() {
		return panelAdminist.getPanelC().getPanelResponse().getResponseActivity().getResults().getSelectedRow();	
	}
	
	public void deleteActivity(int row) {
		if(panelAdminist.getPanelC().getPanelResponse().getResponseActivity().getResults().isEditing()) {
			panelAdminist.getPanelC().getPanelResponse().getResponseActivity().getResults().getCellEditor().stopCellEditing();
		}
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseActivity().getResults().getModel();
		model.removeRow(row);
	}
	
	public int packageSelectAdmin() {
		return panelAdminist.getPanelC().getPanelResponse().getResponsePackages().getResults().getSelectedRow();	
	}
	
	public void deletePackage(int row) {
		if(panelAdminist.getPanelC().getPanelResponse().getResponsePackages().getResults().isEditing()) {
			panelAdminist.getPanelC().getPanelResponse().getResponsePackages().getResults().getCellEditor().stopCellEditing();
		}
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponsePackages().getResults().getModel();
		model.removeRow(row);
	}
	
	public void openPanelAdd(String panel) {
		panelAdminist.getPanelC().buttonsAdd();
		panelAdminist.getPanelC().changePanelAdd(panel);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelAdd");
	}
	
	public void openPanelEddit(String panel) {
		panelAdminist.getPanelC().buttonsEddit();
		panelAdminist.getPanelC().changePanelAdd(panel);
		layoutAdminist.show(panelAdminist.getPanelC(), "panelAdd");
	}
	
	public String[] datesAddFligth() {
		return panelAdminist.getPanelC().addFligth();
	}
	
	public void setDatesAddFlight(String[] dates) {
		panelAdminist.getPanelC().setDatesAddFlight(dates);
	}
	
	public void addFlightTable(String[] flight) {
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseFlight().getResults().getModel();
		model.addRow(flight);
	}
	
	public String[] datesAddHouse() {
		return panelAdminist.getPanelC().addHouse();
	}
	
	public void setDatesAddHouse(String[] dates) {
		panelAdminist.getPanelC().setDatesAddHouse(dates);
	}
	
	public void addHouseTable(String[] house) {
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseHouse().getResults().getModel();
		model.addRow(house);
	}
	
	public String[] datesAddCar() {
		return panelAdminist.getPanelC().addCar();
	}
	
	public void setDatesAddCar(String[] dates) {
		panelAdminist.getPanelC().setDatesAddCar(dates);
	}
	
	public void addCarTable(String[] car) {
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseCar().getResults().getModel();
		model.addRow(car);
	}
	
	public String[] datesAddMess() {
		return panelAdminist.getPanelC().addMess();
	}
	
	public void setDatesAddMess(String[] dates) {
		panelAdminist.getPanelC().setDatesAddMess(dates);
	}
	
	public void addMessTable(String[] mess) {
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseMess().getResults().getModel();
		model.addRow(mess);
	}
	
	public String[] datesAddActivity() {
		return panelAdminist.getPanelC().addActivity();
	}
	
	public void setDatesAddActivity(String[] dates) {
		panelAdminist.getPanelC().setDatesAddActivity(dates);
	}
	
	public void addActivityTable(String[] activity) {
		DefaultTableModel model = (DefaultTableModel) panelAdminist.getPanelC().getPanelResponse().getResponseActivity().getResults().getModel();
		model.addRow(activity);
	}
	
	public PanelCenterUser getPanelCenterUser() {
		return panelUser;
	}

	public void setPanelCenterUser(PanelCenterUser panelCenterUser) {
		this.panelUser = panelCenterUser;
	}

	public PanelCenter getPanelCAdminist() {
		return panelAdminist.getPanelC();
	}

	public void setPanelCAdminist(PanelCenterAdmin panelCAdminist) {
		this.panelAdminist.setPanelC(panelCAdminist);
	}

	public PanelMaxCenterAdmin getPanelAdminist() {
		return panelAdminist;
	}

	public void setPanelAdminist(PanelMaxCenterAdmin panelAdminist) {
		this.panelAdminist = panelAdminist;
	}
}
