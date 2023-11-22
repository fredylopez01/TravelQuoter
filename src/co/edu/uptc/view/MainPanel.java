package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.uptc.model.Activity;
import co.edu.uptc.model.CarRental;
import co.edu.uptc.model.Flight;
import co.edu.uptc.model.HouseRental;
import co.edu.uptc.model.Mess;
import co.edu.uptc.model.PackageService;
import co.edu.uptc.view.body.Body;
import co.edu.uptc.view.header.Header;
import co.edu.uptc.view.header.JDChangeProfile;
import co.edu.uptc.view.header.JDMessage;
import co.edu.uptc.view.header.JDVerifyIdentity;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Header header;
	private Body body;
	private JDChangeProfile jd;
	private boolean isUser;
	private JDVerifyIdentity jdPassword;
	private JDMessage jdMessage;
	
	public MainPanel(ActionListener listener, JFrame father, MouseListener mListener) {
		initComponents(listener, father, mListener);
	}

	private void initComponents(ActionListener listener, JFrame father, MouseListener mListener) {
		setLayout(new BorderLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		header = new Header(listener);
		add(header, BorderLayout.NORTH);
				
		gbc.gridy = 3;
		body = new Body(listener, mListener);
		add(body, BorderLayout.CENTER);
		jd = new JDChangeProfile(listener, father);
		isUser = true;
		jdPassword = new JDVerifyIdentity(listener, father);
		jdMessage = new JDMessage(listener, father);
	}
	
	public void changeProfile(JFrame father) {
//		father.setVisible(false);
		jd.setVisible(true);
	}
	
	public void closeChoseProfile(JFrame father) {
		jd.dispose();
//		father.setVisible(true);
	}
	
	public void panelUser() {
		body.getcPanelCenter().show(body.getPanelCenter(), "panelUser");
		isUser = true;
	}
	
	public void panelAdmnistrator() {
		jdPassword.getPassword().setText("");
		jdPassword.setVisible(true);
	}
	
	public void panelAdministrator() {
		panelAdmnistrator();
	}
	
	public void passwordCorrect() {
		body.getcPanelCenter().show(body.getPanelCenter(), "panelAdministrator");
		isUser = false;
		jdPassword.dispose();
	}
	
	public void showDatesAdministrator(ArrayList<Flight> f, ArrayList<HouseRental> h, ArrayList<CarRental> c,
			ArrayList<Mess> m, ArrayList<Activity> a,ArrayList<PackageService> p, ActionListener listener) {
		body.getPanelCenter().showDatesAdministrator(f, h, c, m, a, p, listener);
	}
	
	public void message(String message) {
		jdMessage.getLblMessage().setText(message);
		jdMessage.setVisible(true);
	}
	
	public void ok() {
		jdMessage.dispose();
	}
	
	public void changePanelCenter(String comand) {
		body.getPanelCenter().changePanelCenter(comand, isUser);
	}
	
	public void btnFligthSelect() {
		body.getNav().buttonSelect(body.getNav().getBtnFlight(), body.getNav().getImgFlightBlue());
	}
	
	public String btnHover(JButton btn) {
		String comand = "";
		if(btn.getBackground().equals(Constants.COLORBACKGROUNDPANEL)) {
			comand = btn.getActionCommand();
		}
		body.getNav().buttonHover(btn);
		return comand;
	}
	
	public void btnNormal(JButton btn, boolean isSelect) {
		if(isSelect) btn.setBackground(Constants.COLORBACKGROUNDPANEL);
		else 	body.getNav().buttonNormal(btn);
	}
	
	public void btnHouseSelect() {
		body.getNav().buttonSelect(body.getNav().getBtnHouse(), body.getNav().getImgHouseBlue());
	}
	
	public void btnCarSelect() {
		body.getNav().buttonSelect(body.getNav().getBtnCar(), body.getNav().getImgCarBlue());
	}
	
	public void btnMessSelect() {
		body.getNav().buttonSelect(body.getNav().getBtnMess(), body.getNav().getImgMessBlue());
	}
	
	public void btnActivitySelect() {
		body.getNav().buttonSelect(body.getNav().getBtnActivity(), body.getNav().getImgActivityBlue());
	}
	
	public void btnPackageSelect() {
		body.getNav().buttonSelect(body.getNav().getBtnPackage(), body.getNav().getImgPackageBlue());
	}
	
	public String[] datesSearchFlights() {
		return body.getPanelCenter().searchFligth();
	}
	
	public void showResultsFlight(ArrayList<Flight> flights) {
		body.getPanelCenter().showResultFligths(flights);
	}
	
	public String[] datesSearchHouse() {
		return body.getPanelCenter().searchHouse();
	}
	
	public void showResultsHouse(ArrayList<HouseRental> houses) {
		body.getPanelCenter().showResultHouses(houses);
	}
	
	public String[] datesSearchCar() {
		return body.getPanelCenter().searchCar();
	}
	
	public void showResultsCar(ArrayList<CarRental> cars) {
		body.getPanelCenter().showResultCars(cars);
	}
	
	public String[] datesSearchMess() {
		return body.getPanelCenter().searchMess();
	}
	
	public void showResultsMess(ArrayList<Mess> messes) {
		body.getPanelCenter().showResultMess(messes);
	}
	
	public String[] datesSearchActivity() {
		return body.getPanelCenter().searchActivity();
	}
	
	public void showResultsActivity(ArrayList<Activity> activities) {
		body.getPanelCenter().showResultActivity(activities);
	}
	
	public String[] datesSearchPackage() {
		return body.getPanelCenter().searchPackage();
	}
	
	public void showResultsPackage(ArrayList<PackageService> packages, ActionListener listener) {
		body.getPanelCenter().showResultPackage(packages, listener, !isUser);
	}
	
	public int packageSelected() {
		return body.getPanelCenter().packageSelect();
	}
	
	public void showPackage(PackageService packageSelect) {
		body.getPanelCenter().showPackage(packageSelect);
	}
	
	public void showPackageAdmi(PackageService packageSelect) {
		body.getPanelCenter().showPackageAdmi(packageSelect);
	}
	
	public void valuesFlights(String[] places, String[] Splaces, String[] classP) {
		body.getPanelS().valuesFlights(places, Splaces, classP);
	}
	
	public void valuesHouses(String[] places) {
		body.getPanelS().valuesHouses(places);
	}
	
	public void valuesCars(String[] brands, String[] models, String[] places) {
		body.getPanelS().valuesCars(brands, models, places);
	}
	
	public void valuesMess(String[] places, String[] placesS) {
		body.getPanelS().valuesMess(places, placesS);
	}
	
	public void valuesActivities(String[] places, String[] activitiesV) {
		body.getPanelS().valuesActivities(places, activitiesV);
	}
	
	public void valuesPackages(String[] places) {
		body.getPanelS().valuesPackages(places);
	}
	
	public int flightSelectAdmin() {
		return body.getPanelCenter().flightSelectAdmin();
	}
	
	public void deletingFlight(int row) {
		body.getPanelCenter().deleteFlight(row);
	}
	
	public int houseSelectAdmin() {
		return body.getPanelCenter().houseSelectAdmin();
	}
	
	public void deletingHouse(int row) {
		body.getPanelCenter().deleteHouse(row);
	}
	
	public int carSelectAdmin() {
		return body.getPanelCenter().carSelectAdmin();
	}
	
	public void deletingCar(int row) {
		body.getPanelCenter().deleteCar(row);
	}
	
	public int messSelectAdmin() {
		return body.getPanelCenter().messSelectAdmin();
	}
	
	public void deletingMess(int row) {
		body.getPanelCenter().deleteMess(row);
	}
	
	public int activitySelectAdmin() {
		return body.getPanelCenter().activitySelectAdmin();
	}
	
	public void deletingActivity(int row) {
		body.getPanelCenter().deleteActivity(row);
	}
	
	public int packageSelectAdmin() {
		return body.getPanelCenter().packageSelectAdmin();
	}
	
	public void deletingPackage(int row) {
		body.getPanelCenter().deletePackage(row);
	}
	
	public void openPanelAdd(String comand) {
		cleanDates();
		body.getPanelCenter().openPanelAdd(comand);
	}
	
	public void cleanDates() {
		String[] i =  new String[] {"", "", "", "0"};
		setDatesAddFlights(i);
		String[] house =  new String[] {"", "0", "0", "0", "0"};
		setDatesAddHouse(house);
		setDatesAddCar(i);
		String[] m =  new String[] {"", "", "0", "0"};
		setDatesAddMess(m);
		String[] activity =  new String[] {"","", "0"};
		setDatesAddActivity(activity);
	}
	
	public void openPanelEddit(String comand) {
		body.getPanelCenter().openPanelEddit(comand);
	}
	
	public String[] datesAddFlights() {
		return body.getPanelCenter().datesAddFligth();
	}
	
	public void setDatesAddFlights(String[] dates){
		body.getPanelCenter().setDatesAddFlight(dates);
	}
	
	public void addFlightTable(String[] f) {
		body.getPanelCenter().addFlightTable(f);;
	}
	
	public String[] datesAddHouse() {
		return body.getPanelCenter().datesAddHouse();
	}
	
	public void setDatesAddHouse(String[] dates){
		body.getPanelCenter().setDatesAddHouse(dates);
	}
	
	public void addHouseTable(String[] h) {
		body.getPanelCenter().addHouseTable(h);;
	}
	
	public String[] datesAddCar() {
		return body.getPanelCenter().datesAddCar();
	}
	
	public void setDatesAddCar(String[] dates){
		body.getPanelCenter().setDatesAddCar(dates);
	}
	
	public void addCarTable(String[] c) {
		body.getPanelCenter().addCarTable(c);
	}
	
	public String[] datesAddMess() {
		return body.getPanelCenter().datesAddMess();
	}
	
	public void setDatesAddMess(String[] dates){
		body.getPanelCenter().setDatesAddMess(dates);
	}
	
	public void addMessTable(String[] f) {
		body.getPanelCenter().addMessTable(f);;
	}
	
	public String[] datesAddActivity() {
		return body.getPanelCenter().datesAddActivity();
	}
	
	public void setDatesAddActivity(String[] dates){
		body.getPanelCenter().setDatesAddActivity(dates);
	}
	
	public void addActivityTable(String[] f) {
		body.getPanelCenter().addActivityTable(f);
	}

	public JDVerifyIdentity getJdPassword() {
		return jdPassword;
	}

	public void setJdPassword(JDVerifyIdentity jdPassword) {
		this.jdPassword = jdPassword;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	
}
