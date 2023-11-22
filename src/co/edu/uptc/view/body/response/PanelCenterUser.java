package co.edu.uptc.view.body.response;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import co.edu.uptc.view.body.response.rServices.PanelNoResults;
import co.edu.uptc.view.body.search.PanelSearch;

public class PanelCenterUser extends PanelCenter {
	private static final long serialVersionUID = 1L;
	private PanelSearch panelSearch;
	private PanelNoResults pNoResults;
	
	public PanelCenterUser(ActionListener listener) {
		super(listener);
		initComponentsTwo(listener);
	}

	public void initComponentsTwo(ActionListener listener) {
		panelSearch = new PanelSearch(listener);
		CardLayout c1 = (CardLayout) panelSearch.getLayout();
		c1.show(panelSearch, "fligths");
		add(panelSearch, "panelSearch");
		
		pNoResults = new PanelNoResults(listener);
		add(pNoResults, "panelNoResults");
	}
	
	public void changePanelSearch(String panel) {
		CardLayout c1 = (CardLayout) panelSearch.getLayout();
		c1.show(panelSearch, panel);
	}
	
	public String[] searchFligth() {
		return panelSearch.getFligths().getDates();
	}
	
	public String[] searchHouse() {
		return panelSearch.getHouses().getDates();
	}
	
	public String[] searchCar() {
		return panelSearch.getCars().getDates();
	}
	
	public String[] searchMess() {
		return panelSearch.getMesses().getDates();
	}
	
	public String[] searchActivity() {
		return panelSearch.getActivities().getDates();
	}
	
	public String[] searchPackage() {
		return panelSearch.getPackages().getDates();
	}
	
	public PanelSearch getPanelSearch() {
		return panelSearch;
	}

	public void setPanelSearch(PanelSearch panelSearch) {
		this.panelSearch = panelSearch;
	}
}
