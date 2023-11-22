package co.edu.uptc.view.body.write;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelFlightAdd extends PanelEdit {
	private static final long serialVersionUID = 1L;
	private JLabel lblStartingPlace;
	private JTextField startingPlace;
	private JLabel lblClass;
	private JTextField classF;
	
	public PanelFlightAdd(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("VUELOS");
		
		lblStartingPlace = new JLabel("Origen");
		lblStartingPlace.setFont(font);
		
		startingPlace = new JTextField(15);
		startingPlace.setFont(font);
		
		lblPlace = new JLabel("Destino");
		lblPlace.setFont(font);
		
		place = new JTextField(15);
		place.setFont(font);
		
		lblClass = new JLabel("Clase");
		lblClass.setFont(font);
		
		classF = new JTextField(15);
		classF.setFont(font);
		
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
		add(lblClass, gbc);
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(classF, gbc);
		
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
		String startingP = startingPlace.getText().toUpperCase();
		String placeS = place.getText().toUpperCase();
		String classFf = (String) classF.getText().toUpperCase();
		String priceS = String.valueOf(price.getValue());
		return new String[] {startingP, placeS, classFf, priceS};
	}
	
	public void setDates(String[] dates) {
		startingPlace.setText(dates[0]);
		place.setText(dates[1]);
		classF.setText(dates[2]);
		price.setValue(Double.parseDouble(dates[3]));
	}

	public JTextField getStartingPlace() {
		return startingPlace;
	}

	public void setStartingPlace(JTextField startingPlace) {
		this.startingPlace = startingPlace;
	}

	public JTextField getClassF() {
		return classF;
	}

	public void setClassF(JTextField classF) {
		this.classF = classF;
	}

}
