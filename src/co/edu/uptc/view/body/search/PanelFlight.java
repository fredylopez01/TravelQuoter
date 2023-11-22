package co.edu.uptc.view.body.search;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelFlight extends PanelService {
	private static final long serialVersionUID = 1L;
	private JLabel lblStartingPlace;
	private JComboBox<String> startingPlace;
	private JLabel lblClass;
	private JComboBox<String> classF;
	
	public PanelFlight(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("VUELOS AL MEJOR PRECIO");
		
		lblStartingPlace = new JLabel("Origen");
		lblStartingPlace.setFont(font);
		
		startingPlace = new JComboBox<String>(new String[] {"Seleccionar","Bogotá", "Medellin"});
		startingPlace.setFont(font);
		
		lblPlace = new JLabel("Destino");
		lblPlace.setFont(font);
		
		place = new JComboBox<String>(new String[] {"Seleccionar","Bogotá", "Medellin", "Bucaramanga", "Cartagena"});
		place.setFont(font);
		
		lblClass = new JLabel("Clase");
		lblClass.setFont(font);
		
		classF = new JComboBox<String>(new String[] {"Seleccionar", "Primera Clase", "Segunda Clase",});
		classF.setFont(font);
		
		btnSearch.setActionCommand("searchFlight");
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
		add(btnSearch, gbc);
	}
	
	public String[] getDates() {
		String startingP = (String) startingPlace.getSelectedItem();
		String placeS = (String) place.getSelectedItem();
		String classFf = (String) classF.getSelectedItem();
		String priceS = String.valueOf((int) price.getValue());
		return new String[] {startingP, placeS, classFf, priceS};
	}

	public JComboBox<String> getStartingPlace() {
		return startingPlace;
	}

	public void setStartingPlace(JComboBox<String> startingPlace) {
		this.startingPlace = startingPlace;
	}

	public JComboBox<String> getClassF() {
		return classF;
	}

	public void setClassF(JComboBox<String> classF) {
		this.classF = classF;
	}
	
}
