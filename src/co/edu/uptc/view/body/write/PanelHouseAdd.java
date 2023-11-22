package co.edu.uptc.view.body.write;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class PanelHouseAdd extends PanelEdit {
	private static final long serialVersionUID = 1L;
	private JLabel lblRooms;
	private JSpinner numRooms;
	private JLabel lblBathrooms;
	private JSpinner numBathrooms;
	private JLabel lblSizeM;
	private JSpinner sizeM;
	
	public PanelHouseAdd(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("VUELOS");
		lblPlace = new JLabel("Lugar");
		lblPlace.setFont(font);
		place = new JTextField(15);
		place.setFont(font);
		lblRooms = new JLabel("Número de Habitaciones");
		lblRooms.setFont(font);
		numRooms = new JSpinner();
		numRooms.setFont(font);
		lblBathrooms = new JLabel("Número de Baños");
		lblBathrooms.setFont(font);
		numBathrooms = new JSpinner();
		numBathrooms.setFont(font);
		lblSizeM = new JLabel("Metros cuadrados");
		lblSizeM.setFont(font);
		sizeM = new JSpinner();
		sizeM.setFont(font);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 0, 15, 0);
		add(title, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 5, 250);
		add(lblPlace, gbc);
		gbc.gridx = 1;
		add(lblRooms, gbc);
		
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(numRooms, gbc);
		gbc.gridx = 0;
		add(place, gbc);
		
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 250);
		add(lblBathrooms, gbc);
		gbc.gridx = 1;
		add(lblSizeM, gbc);
		
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(sizeM, gbc);
		gbc.gridx = 0;
		add(numBathrooms, gbc);
		
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 5, 250);
		add(lblPrice, gbc);
		gbc.gridy = 6;
		gbc.insets = new Insets(0, 0, 10, 200);
		add(price, gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10, 0, 10, 0);
		add(btnAddEdit, gbc);
	}
	
	public String[] getDates() {
		String nRooms = String.valueOf(numRooms.getValue());
		String nBaths = String.valueOf(numBathrooms.getValue());
		String size = String.valueOf(sizeM.getValue());
		String placeS = place.getText().toUpperCase();
		String priceS = String.valueOf(price.getValue());
		return new String[] {placeS, nRooms, nBaths, size, priceS};
	}
	
	public void setDates(String[] dates) {
		place.setText(dates[0]);
		numRooms.setValue(Integer.parseInt(dates[1]));
		numBathrooms.setValue(Integer.parseInt(dates[2]));
		sizeM.setValue(Integer.parseInt(dates[3]));
		price.setValue(Double.parseDouble(dates[4]));
	}

	public JSpinner getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(JSpinner numRooms) {
		this.numRooms = numRooms;
	}

	public JSpinner getNumBathrooms() {
		return numBathrooms;
	}

	public void setNumBathrooms(JSpinner numBathrooms) {
		this.numBathrooms = numBathrooms;
	}

	public JSpinner getSizeM() {
		return sizeM;
	}

	public void setSizeM(JSpinner sizeM) {
		this.sizeM = sizeM;
	}
	
	

}
