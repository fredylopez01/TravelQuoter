package co.edu.uptc.view.body.write;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class PanelMessAdd extends PanelEdit {
	private static final long serialVersionUID = 1L;
	private JLabel lblStartingPlace;
	private JTextField startingPlace;
	private JLabel lblSizeKg;
	private JSpinner sizeKg;
	
	
	public PanelMessAdd(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("TRASTEOS");
		
		lblStartingPlace = new JLabel("Origen");
		lblStartingPlace.setFont(font);
		
		startingPlace = new JTextField(15);
		startingPlace.setFont(font);
		
		lblPlace = new JLabel("Destino");
		lblPlace.setFont(font);
		
		place = new JTextField(15);
		place.setFont(font);
		
		lblSizeKg = new JLabel("Tamaño kg");
		lblSizeKg.setFont(font);
		
		sizeKg = new JSpinner();
		sizeKg.setFont(font);
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
		gbc.insets = new Insets(0, 0, 5, 340);
		add(lblStartingPlace, gbc);
		gbc.gridx = 1;
		add(lblPlace, gbc);
		
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(place, gbc);
		gbc.gridx = 0;
		add(startingPlace, gbc);
		
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 340);
		add(lblSizeKg, gbc);
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(sizeKg, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 5, 340);
		add(lblPrice, gbc);
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(price, gbc);
		
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 0, 10, 0);
		add(btnAddEdit, gbc);
	}
	
	public String[] getDates() {
		String sPlaceS = startingPlace.getText().toUpperCase();
		String placeS = place.getText().toUpperCase();
		String priceS = String.valueOf(price.getValue());
		String size = String.valueOf(sizeKg.getValue());
		return new String[] {sPlaceS, placeS, size, priceS};
	}
	
	public void setDates(String[] dates) {
		place.setText(dates[0]);
		startingPlace.setText(dates[1]);
		sizeKg.setValue(Integer.parseInt(dates[2]));
		price.setValue(Double.parseDouble(dates[3]));
	}

	public JTextField getStartingPlace() {
		return startingPlace;
	}

	public void setStartingPlace(JTextField startingPlace) {
		this.startingPlace = startingPlace;
	}

	public JSpinner getSizeKg() {
		return sizeKg;
	}

	public void setSizeKg(JSpinner sizeKg) {
		this.sizeKg = sizeKg;
	}
	
}