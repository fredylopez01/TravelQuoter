package co.edu.uptc.view.body.response.rServices;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import co.edu.uptc.model.PackageService;
import co.edu.uptc.view.body.response.tables.ResponseService;

public class PanelResponseService extends PanelResponse {
	private static final long serialVersionUID = 1L;
	protected ResponseService responsePackages;
	
	public PanelResponseService() {
		super();
		setLayout(new CardLayout());
		add(responseFlight, "responsefligths");
		add(responseHouse, "responsehouses");
		add(responseCar, "responsecars");
		add(responseMess, "responsemesses");
		add(responseActivity, "responseactivities");
		responsePackages = new ResponseService("Paquetes");
		add(responsePackages, "responsepackages");
	}
	
	public void showResultPackages(ArrayList<PackageService> packages, ActionListener listener, boolean isAdministrator) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Lugar");
		model.addColumn("Número de Servicios");
		model.addColumn("Precio");
		model.addColumn("Ver");
		Object[] packagesArray = new String[4];
		for (PackageService a: packages) {
			packagesArray[0] = a.getPlace();
			packagesArray[1] = String.valueOf(a.getNumberServices());
			packagesArray[2] = String.valueOf(a.getCost());
			model.addRow(packagesArray);
		}
		responsePackages.showResults(model);
		responsePackages.styleTable();
		responsePackages.optionsPackage(listener, isAdministrator);
	}
	
	public ResponseService getResponsePackages() {
		return responsePackages;
	}

	public void setResponsePackages(ResponseService responsePackages) {
		this.responsePackages = responsePackages;
	}
}
