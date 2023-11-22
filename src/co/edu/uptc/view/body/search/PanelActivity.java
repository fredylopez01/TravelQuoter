package co.edu.uptc.view.body.search;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelActivity extends PanelService {
	private static final long serialVersionUID = 1L;
	private JLabel lblNameActivity;
	private JComboBox<String> activity;	
	
	public PanelActivity(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("¡VIVE EXPERIENCIAS ÚNICAS!");
		
		lblNameActivity = new JLabel("Nombre Actividad");
		lblNameActivity.setFont(font);
		
		activity = new JComboBox<String>(new String[] {"Seleccionar", "Primera Clase", "Segunda Clase",});
		activity.setFont(font);
		
		lblPlace = new JLabel("Lugar");
		lblPlace.setFont(font);
		
		place = new JComboBox<String>(new String[] {"Seleccionar","Bogotá", "Medellin", "Bucaramanga", "Cartagena"});
		place.setFont(font);
		
		btnSearch.setActionCommand("searchActivity");
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
		add(lblPlace, gbc);
		gbc.gridx = 1;
		add(lblPrice, gbc);
		
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(price, gbc);
		gbc.gridx = 0;
		add(place, gbc);
		
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 340);
		add(lblNameActivity, gbc);
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 13, 200);
		add(activity, gbc);
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 0, 10, 0);
		add(btnSearch, gbc);
	}
	
	public String[] getDates() {
		String activityS = ((String) activity.getSelectedItem()).toUpperCase();
		String placeS = ((String) place.getSelectedItem()).toUpperCase();
		String priceS = String.valueOf((int) price.getValue());
		return new String[] {activityS, placeS, priceS};
	}

	public JComboBox<String> getActivity() {
		return activity;
	}

	public void setActivity(JComboBox<String> activity) {
		this.activity = activity;
	}
	
}
