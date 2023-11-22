package co.edu.uptc.view.body.search;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelCar extends PanelService {
	private static final long serialVersionUID = 1L;
	private JLabel lblBrand;
	private JComboBox<String> brand;
	private JLabel lblModel;
	private JComboBox<String> model;
	
	public PanelCar(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("NADA COMO LA COMODIDAD");
		
		lblBrand = new JLabel("Marca");
		lblBrand.setFont(font);
		
		brand = new JComboBox<String>(new String[] {"Seleccionar","Bogotá", "Medellin"});
		brand.setFont(font);
		
		lblPlace = new JLabel("Lugar");
		lblPlace.setFont(font);
		
		place = new JComboBox<String>(new String[] {"Seleccionar","Bogotá", "Medellin", "Bucaramanga", "Cartagena"});
		place.setFont(font);
		
		lblModel = new JLabel("Modelo");
		lblModel.setFont(font);
		
		model = new JComboBox<String>(new String[] {"Seleccionar", "Primera Clase", "Segunda Clase",});
		model.setFont(font);
		
		btnSearch.setActionCommand("searchCar");
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
		add(lblBrand, gbc);
		gbc.gridx = 1;
		add(lblModel, gbc);
		
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(model, gbc);
		gbc.gridx = 0;
		add(brand, gbc);
		
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 340);
		add(lblPlace, gbc);
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(place, gbc);
		
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
		String brandS = ((String) brand.getSelectedItem()).toUpperCase();
		String modelS = (String) model.getSelectedItem();
		String placeS = ((String) place.getSelectedItem()).toUpperCase();
		String priceS = String.valueOf((int) price.getValue());
		return new String[] {brandS, modelS, placeS, priceS};
	}

	public JComboBox<String> getBrand() {
		return brand;
	}

	public void setBrand(JComboBox<String> brand) {
		this.brand = brand;
	}

	public JComboBox<String> getModel() {
		return model;
	}

	public void setModel(JComboBox<String> model) {
		this.model = model;
	}
	
}
