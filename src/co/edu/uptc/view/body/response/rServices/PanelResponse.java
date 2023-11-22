package co.edu.uptc.view.body.response.rServices;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.model.Activity;
import co.edu.uptc.model.CarRental;
import co.edu.uptc.model.Flight;
import co.edu.uptc.model.HouseRental;
import co.edu.uptc.model.Mess;
import co.edu.uptc.view.body.response.tables.ResponseService;

public class PanelResponse extends JPanel {
	private static final long serialVersionUID = 1L;
	protected ResponseService responseFlight;
	protected ResponseService responseHouse;
	protected ResponseService responseCar;
	protected ResponseService responseMess;
	protected ResponseService responseActivity;
	
	public PanelResponse() {
		responseFlight = new ResponseService("Vuelos");
		responseHouse = new ResponseService("Viviendas");
		responseCar = new ResponseService("Vehiculos");
		responseMess = new ResponseService("Traslados");
		responseActivity = new ResponseService("Actividades");
	}
	
	public void showResultFligths(ArrayList<Flight> fligths) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Origen");
		model.addColumn("Destino");
		model.addColumn("Clase");
		model.addColumn("Precio");
		String[] flightArray = new String[4];
		for (Flight f: fligths) {
			flightArray[0] = f.getStartingPlace();
			flightArray[1] = f.getPlace();
			flightArray[2] = f.gettClass();
			flightArray[3] = String.valueOf(f.getCost());
			model.addRow(flightArray);
		}
		responseFlight.showResults(model);
		responseFlight.styleTable();
	}
	
	public void showResultHouses(ArrayList<HouseRental> houses) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Lugar");
		model.addColumn("N. de Habitaciones");
		model.addColumn("N. de Baños");
		model.addColumn("Tamañon(m^2)");
		model.addColumn("Precio");
		String[] houseArray = new String[5];
		for (HouseRental h: houses) {
			houseArray[0] = h.getPlace();
			houseArray[1] = String.valueOf(h.getNumberRooms());
			houseArray[2] = String.valueOf(h.getNumberBathrooms());
			houseArray[3] = String.valueOf(h.getSizeMeters());
			houseArray[4] = String.valueOf(h.getCost());
			model.addRow(houseArray);
		}
		responseHouse.showResults(model);
		responseHouse.styleTable();
	}
	
	public void showResultCars(ArrayList<CarRental> cars) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Lugar");
		model.addColumn("Precio");
		String[] carArray = new String[4];
		for (CarRental h: cars) {
			carArray[0] = h.getBrand();
			carArray[1] = String.valueOf(h.getModel());
			carArray[2] = h.getPlace();
			carArray[3] = String.valueOf(h.getCost());
			model.addRow(carArray);
		}
		responseCar.showResults(model);
		responseCar.styleTable();
	}
	
	public void showResultMesses(ArrayList<Mess> messes) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Origen");
		model.addColumn("Destino");
		model.addColumn("Tamaño");
		model.addColumn("Precio");
		String[] messArray = new String[4];
		for (Mess m: messes) {
			messArray[0] = m.getStartingPlace();
			messArray[1] = m.getPlace();
			messArray[2] = String.valueOf(m.getSizeKg());
			messArray[3] = String.valueOf(m.getCost());
			model.addRow(messArray);
		}
		responseMess.showResults(model);
		responseMess.styleTable();
	}
	
	public void showResultActivities(ArrayList<Activity> activities) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Lugar");
		model.addColumn("Actividad");
		model.addColumn("Precio");
		String[] activitiesArray = new String[3];
		for (Activity a: activities) {
			activitiesArray[0] = a.getPlace();
			activitiesArray[1] = a.getNameActivity();
			activitiesArray[2] = String.valueOf(a.getCost());
			model.addRow(activitiesArray);
		}
		responseActivity.showResults(model);
		responseActivity.styleTable();
	}

	public ResponseService getResponseFlight() {
		return responseFlight;
	}

	public void setResponseFlight(ResponseService responseFlight) {
		this.responseFlight = responseFlight;
	}

	public ResponseService getResponseHouse() {
		return responseHouse;
	}

	public void setResponseHouse(ResponseService responseHouse) {
		this.responseHouse = responseHouse;
	}

	public ResponseService getResponseCar() {
		return responseCar;
	}

	public void setResponseCar(ResponseService responseCar) {
		this.responseCar = responseCar;
	}

	public ResponseService getResponseMess() {
		return responseMess;
	}

	public void setResponseMess(ResponseService responseMess) {
		this.responseMess = responseMess;
	}

	public ResponseService getResponseActivity() {
		return responseActivity;
	}

	public void setResponseActivity(ResponseService responseActivity) {
		this.responseActivity = responseActivity;
	}
	
}
