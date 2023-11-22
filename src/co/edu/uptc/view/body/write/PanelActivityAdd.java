package co.edu.uptc.view.body.write;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelActivityAdd extends PanelEdit {
	private static final long serialVersionUID = 1L;
	private JLabel lblNameActivity;
	private JTextField activity;	
	
	public PanelActivityAdd(ActionListener listener) {
		super(listener);
		initComponents();
		addComponents();
	}

	private void initComponents() {
		title.setText("¡VIVE EXPERIENCIAS ÚNICAS!");
		
		lblNameActivity = new JLabel("Nombre Actividad");
		lblNameActivity.setFont(font);
		
		activity = new JTextField(15);
		activity.setFont(font);
		
		lblPlace = new JLabel("Lugar");
		lblPlace.setFont(font);
		
		place = new JTextField(15);
		place.setFont(font);
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
		add(btnAddEdit, gbc);
	}
	
	public String[] getDates() {
		String activityS = activity.getText().toUpperCase();
		String placeS = place.getText().toUpperCase();
		String priceS = String.valueOf(price.getValue());
		return new String[] {placeS, activityS, priceS};
	}
	
	public void setDates(String[] dates) {
		place.setText(dates[0]);
		activity.setText(dates[1]);
		price.setValue(Double.parseDouble(dates[2]));
	}

	public JTextField getActivity() {
		return activity;
	}

	public void setActivity(JTextField activity) {
		this.activity = activity;
	}
	
}
