package co.edu.uptc.view.body.response.rServices;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

import co.edu.uptc.model.PackageService;
import co.edu.uptc.view.Constants;

public class PanelResponseShowPackage extends PanelResponse {
	private static final long serialVersionUID = 1L;
	private PackageService packageSelected;
	
	public PanelResponseShowPackage() {
		super();
		setBorder(new EmptyBorder(15, 0, 5, 0));
		setBackground(Constants.COLORBACKGROUNDHEADER);
	}
	
	public void showPackage(PackageService packageSelect) {
		this.removeAll();
		this.packageSelected =  packageSelect;
		addComponents();
	}
	
	public void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets= new Insets(0, 0, 15, 0);
		int y = 0;
		if(packageSelected != null) {
			if(initFligths()) {
				y++;
				gbc.gridy = y;
				add(responseFlight, gbc);
			}
			if(initHouses()) {
				y++;
				gbc.gridy = y;
				add(responseHouse);
			}
			if(initCars()) {
				y++;
				gbc.gridy = y;
				add(responseCar);
			}
			if(initMess()) {
				y++;
				gbc.gridy = y;
				add(responseMess);
			}
			if(initActivities()) {
				y++;
				gbc.gridy = y;
				add(responseActivity);
			}
		}
	}
	
	public boolean initFligths() {
		if(packageSelected.getFlights().size()!=0) {
			showResultFligths(packageSelected.getFlights());
			return true;
		} else{
			return false;
		}
	}
	
	public boolean initHouses() {
		if(packageSelected.getHouses().size()!=0) {
			showResultHouses(packageSelected.getHouses());
			return true;
		} else{
			return false;
		}
	}
	
	public boolean initCars() {
		if(packageSelected.getCars().size()!=0) {
			showResultCars(packageSelected.getCars());
			return true;
		} else{
			return false;
		}
	}
	
	public boolean initMess() {
		if(packageSelected.getMesses().size()!=0) {
			showResultMesses(packageSelected.getMesses());
			return true;
		} else{
			return false;
		}
	}
	
	public boolean initActivities() {
		if(packageSelected.getActivities().size()!=0) {
			showResultActivities(packageSelected.getActivities());
			return true;
		} else{
			return false;
		}
	}
}
