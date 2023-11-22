package co.edu.uptc.view.body.response;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import co.edu.uptc.model.Activity;
import co.edu.uptc.model.CarRental;
import co.edu.uptc.model.Flight;
import co.edu.uptc.model.HouseRental;
import co.edu.uptc.model.Mess;
import co.edu.uptc.model.PackageService;
import co.edu.uptc.view.body.response.rServices.PanelResponseService;
import co.edu.uptc.view.body.response.rServices.PanelResponseShowPackage;

public class PanelCenter extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelResponseService panelResponse;
	private CardLayout layoutResponse;
	private JScrollPane scrollPanelShowP;
	private PanelResponseShowPackage pShowPackage;
	
	public PanelCenter(ActionListener listener) {
		initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		setLayout(new CardLayout());
		
		panelResponse = new PanelResponseService();
		layoutResponse = (CardLayout) panelResponse.getLayout();
		add(panelResponse, "panelResponse");
		
		pShowPackage = new PanelResponseShowPackage();
		scrollPanelShowP = new JScrollPane(pShowPackage, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanelShowP.setPreferredSize(new Dimension(800, 220));
		add(scrollPanelShowP, "panelShowPackage");
	}
	
	public void changePanelResponse(String panel) {
		layoutResponse.show(panelResponse, "response"+panel);
	}
	
	public void showResultFligths(ArrayList<Flight> fligths) {
		panelResponse.showResultFligths(fligths);
		layoutResponse.show(panelResponse, "responseflights");
	}
	
	public void showResultHouses(ArrayList<HouseRental> houses) {
		panelResponse.showResultHouses(houses);
		layoutResponse.show(panelResponse, "responsehouses");
	}

	public void showResultCars(ArrayList<CarRental> cars) {
		panelResponse.showResultCars(cars);
		layoutResponse.show(panelResponse, "responsecars");
	}
	
	public void showResultMess(ArrayList<Mess> mess) {
		panelResponse.showResultMesses(mess);
		layoutResponse.show(panelResponse, "responsemesses");
	}
	
	public void showResultActivity(ArrayList<Activity> activities) {
		panelResponse.showResultActivities(activities);
		layoutResponse.show(panelResponse, "responseactivities");
	}
	
	public void showResultPackage(ArrayList<PackageService> packages, ActionListener listener, boolean isAdministrator) {
		panelResponse.showResultPackages(packages, listener, isAdministrator);
		layoutResponse.show(panelResponse, "responsepackages");
	}
	
	public int packageSelect() {
		return panelResponse.getResponsePackages().getResults().getSelectedRow();
	}
	
	public void showPackage(PackageService packageSelect) {
		pShowPackage.showPackage(packageSelect);;
	}

	public PanelResponseService getPanelResponse() {
		return panelResponse;
	}

	public void setPanelResponse(PanelResponseService panelResponse) {
		this.panelResponse = panelResponse;
	}

	public CardLayout getLayoutResponse() {
		return layoutResponse;
	}

	public void setLayoutResponse(CardLayout layoutResponse) {
		this.layoutResponse = layoutResponse;
	}
	
}
