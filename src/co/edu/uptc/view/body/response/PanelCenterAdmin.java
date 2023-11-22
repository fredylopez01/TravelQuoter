package co.edu.uptc.view.body.response;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import co.edu.uptc.view.body.write.PanelAdd;

public class PanelCenterAdmin extends PanelCenter {
	private static final long serialVersionUID = 1L;
	private PanelAdd panelAdd;
	private CardLayout layoutAdd;
	
	public PanelCenterAdmin(ActionListener listener) {
		super(listener);
		initComponentsTwo(listener);
	}

	public void initComponentsTwo(ActionListener listener) {
		panelAdd = new PanelAdd(listener);
		layoutAdd = (CardLayout) panelAdd.getLayout();
		layoutAdd.show(panelAdd, "fligthsAdd");
		add(panelAdd, "panelAdd");
		
	}
	
	public void changePanelAdd(String panel) {
		layoutAdd.show(panelAdd, panel+"Add");
	}
	
	public void buttonsAdd() {
		panelAdd.getFligths().getBtnAddEdit().setActionCommand("addFlight");
		panelAdd.getFligths().getBtnAddEdit().setText("Agregar Vuelo");
		panelAdd.getHouses().getBtnAddEdit().setActionCommand("AddHouse");
		panelAdd.getHouses().getBtnAddEdit().setText("Agregar Alquiler");
		panelAdd.getCars().getBtnAddEdit().setActionCommand("addCar");
		panelAdd.getCars().getBtnAddEdit().setText("Agregar Vehículo");
		panelAdd.getMesses().getBtnAddEdit().setActionCommand("addMess");
		panelAdd.getMesses().getBtnAddEdit().setText("Agregar Traslado");
		panelAdd.getActivities().getBtnAddEdit().setActionCommand("addActivity");
		panelAdd.getActivities().getBtnAddEdit().setText("Agregar actividad");
	}
	
	public void buttonsEddit() {
		panelAdd.getFligths().getBtnAddEdit().setActionCommand("edditFlight");
		panelAdd.getFligths().getBtnAddEdit().setText("Editar Vuelo");
		panelAdd.getHouses().getBtnAddEdit().setActionCommand("edditHouse");
		panelAdd.getHouses().getBtnAddEdit().setText("Editar Alquiler");
		panelAdd.getCars().getBtnAddEdit().setActionCommand("edditCar");
		panelAdd.getCars().getBtnAddEdit().setText("Editar Vehículo");
		panelAdd.getMesses().getBtnAddEdit().setActionCommand("edditMess");
		panelAdd.getMesses().getBtnAddEdit().setText("Editar Traslado");
		panelAdd.getActivities().getBtnAddEdit().setActionCommand("edditActivity");
		panelAdd.getActivities().getBtnAddEdit().setText("Editar actividad");
	}
	
	
	public String[] addFligth() {
		return panelAdd.getFligths().getDates();
	}
	
	public void setDatesAddFlight(String[] dates) {
		panelAdd.getFligths().setDates(dates);
	}
	
	public String[] addHouse() {
		return panelAdd.getHouses().getDates();
	}
	
	public void setDatesAddHouse(String[] dates) {
		panelAdd.getHouses().setDates(dates);
	}
	
	public String[] addCar() {
		return panelAdd.getCars().getDates();
	}
	
	public void setDatesAddCar(String[] dates) {
		panelAdd.getCars().setDates(dates);
	}
	
	public String[] addMess() {
		return panelAdd.getMesses().getDates();
	}
	
	public void setDatesAddMess(String[] dates) {
		panelAdd.getMesses().setDates(dates);
	}
	
	public String[] addActivity() {
		return panelAdd.getActivities().getDates();
	}
	
	public void setDatesAddActivity(String[] dates) {
		panelAdd.getActivities().setDates(dates);
	}
	
//	public String[] addPackage() {
//		return panelAdd.getPackages().getDates();
//	}
}
