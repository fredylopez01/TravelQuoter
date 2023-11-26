package co.edu.uptc.view.body.write;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.header.ShapedButtonProfile;

public class PanelPackageAdd extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnAddFligth;
	private JButton btnAddHouse;
	private JButton btnAddCar;
	private JButton btnAddMess;
	private JButton  btnAddActivity;
	private JLabel advertaisment;
	
	public PanelPackageAdd(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		Insets insetsBtn = new Insets(5,10,5, 10);
		advertaisment = new JLabel("<html><body>Para agregar un paquete, "
				+ "primero debe agregar un primer servicio <br>para que se cree el paquete, "
				+ "luego podrá editarlo a su gusto</body></html>");
		advertaisment.setFont(Constants.FONTNAV);
		advertaisment.setForeground(Constants.COLORBACKGROUNDHEADER);
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = insetsBtn;
		gbc.gridx = 1;
		add(advertaisment, gbc);
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		
		btnAddFligth = new JButton("Agregar Vuelo");
		styleButton(btnAddFligth, "addFlightPackage", listener, new Insets(5,22,5, 22));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(btnAddFligth, gbc);
		
		btnAddHouse = new JButton("Agregar Alquiler");
		styleButton(btnAddHouse, "addHousePackage", listener, new Insets(5,17,5, 17));
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(btnAddHouse, gbc);
		
		btnAddCar = new JButton("Agregar automovil");
		styleButton(btnAddCar, "addCarPackage", listener, new Insets(5,10,5, 10));
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(btnAddCar, gbc);
		
		btnAddMess = new JButton("Agregar traslado");
		styleButton(btnAddMess, "addMessPackage", listener, new Insets(5,13,5, 13));
		gbc.gridx = 3;
		gbc.gridy = 1;
		add(btnAddMess, gbc);
		
		btnAddActivity = new JButton("Agregar actividad");
		styleButton(btnAddActivity, "addActivityPackage", listener, new Insets(5,11,5, 11));
		gbc.gridx = 4;
		gbc.gridy = 1;
		add(btnAddActivity, gbc);
	}
	
	public void styleButton(JButton btn, String comand, ActionListener listener, Insets insets) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonProfile(Constants.GREEN));
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
	}
}
