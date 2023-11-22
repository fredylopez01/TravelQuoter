package co.edu.uptc.view.body.search;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class PanelPackage extends PanelService {
	private static final long serialVersionUID = 1L;
	private JLabel lblNumberS;
	private JSpinner numberService;
	
	public PanelPackage(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("¡TODO EN UN SOLO LUGAR!");
		
		lblPlace = new JLabel("Lugar");
		lblPlace.setFont(font);
		
		place = new JComboBox<String>(new String[] {"Seleccionar","Bogotá", "Medellin", "Bucaramanga", "Cartagena"});
		place.setFont(font);
		

		lblNumberS = new JLabel("Número de Servicios");
		lblNumberS.setFont(font);
		
		numberService = new JSpinner();
		numberService.setFont(font);
		
		btnSearch.setActionCommand("searchPackage");
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
		gbc.insets = new Insets(0, 0, 5, 260);
		add(lblPlace, gbc);
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 5, 300);
		add(lblPrice, gbc);
		
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 13, 150);
		add(price, gbc);
		gbc.gridx = 0;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(place, gbc);
		
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 260);
		add(lblNumberS, gbc);
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(numberService, gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 10, 0);
		add(btnSearch, gbc);
	}
	
	public String[] getDates() {
		String numberServiceS = String.valueOf(numberService.getValue());
		String placeS = (String) place.getSelectedItem();
		String priceS = String.valueOf(price.getValue());
		return new String[] {numberServiceS, placeS, priceS};
	}
}
