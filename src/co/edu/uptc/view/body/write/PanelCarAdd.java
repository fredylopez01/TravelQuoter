package co.edu.uptc.view.body.write;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelCarAdd extends PanelEdit {
	private static final long serialVersionUID = 1L;
	private JLabel lblBrand;
	private JTextField brand;
	private JLabel lblModel;
	private JTextField model;
	
	public PanelCarAdd(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("VEHÍCULOS");
		
		lblBrand = new JLabel("Marca");
		lblBrand.setFont(font);
		
		brand = new JTextField(15);
		brand.setFont(font);
		
		lblPlace = new JLabel("Lugar");
		lblPlace.setFont(font);
		
		place = new JTextField(15);
		place.setFont(font);
		
		lblModel = new JLabel("Modelo");
		lblModel.setFont(font);
		
		model = new JTextField(15);
		model.setFont(font);
		
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
		add(btnAddEdit, gbc);
	}
	
	public String[] getDates() {
		String brandS = brand.getText().toUpperCase();
		String modelS = model.getText();
		String placeS = place.getText().toUpperCase();
		String priceS = String.valueOf(price.getValue());
		return new String[] {brandS, modelS, placeS, priceS};
	}
	
	public void setDates(String[] dates) {
		brand.setText(dates[0]);
		model.setText(dates[1]);
		place.setText(dates[2]);
		price.setValue(Double.parseDouble(dates[3]));
	}

	public JTextField getBrand() {
		return brand;
	}

	public void setBrand(JTextField brand) {
		this.brand = brand;
	}

	public JTextField getModel() {
		return model;
	}

	public void setModel(JTextField model) {
		this.model = model;
	}
	
}
