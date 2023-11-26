package co.edu.uptc.view.body.response.tables.options;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.header.ShapedButtonProfile;

public class OptionsAdmin extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon iconAdd;
	private JButton btnAdd;
	private ImageIcon iconEdit;
	private JButton btnEdit;
	private ImageIcon iconDelete;
	private JButton btnDelete;
	private ImageIcon iconAddService;
	private JButton btnAddService;
	
	public OptionsAdmin(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		iconEdit = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/edit.png"));
		btnEdit = new JButton("Editar");
		btnEdit.setActionCommand("editService");
		styleBtn(btnEdit, listener, iconEdit, Constants.COLORBACKGROUNDPANEL);
		gbc.insets = new Insets(5, 70, 5, 70);
		add(btnEdit, gbc);
		
		iconDelete = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/delete.png"));
		btnDelete = new JButton("Eliminar");
		btnDelete.setActionCommand("deleteService");
		styleBtn(btnDelete, listener, iconDelete, Constants.COLORBACKGROUNDPANEL);
		gbc.gridx = 1;
		add(btnDelete, gbc);
		
		iconAdd = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/agregar.png"));
		btnAdd = new JButton("Nuevo");
		btnAdd.setActionCommand("addService");
		styleBtn(btnAdd, listener, iconAdd, Constants.GREEN);
		gbc.gridx = 2;
		add(btnAdd, gbc);
		
		iconAddService = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/listo.png"));
		btnAddService = new JButton("Agregar al Paquete");
		btnAddService.setActionCommand("addServicePackage");
		styleBtn(btnAddService, listener, iconAddService, Constants.GREEN);
		gbc.gridy = 1;
		add(btnAddService, gbc);
		btnAddService.setVisible(false);
	}
	
	public void styleBtn(JButton btn, ActionListener listener, ImageIcon icon, Color color) {
		btn.setIcon(icon);
		btn.setFont(Constants.FONTNAV);
		btn.setForeground(color);
		btn.setContentAreaFilled(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.addActionListener(listener);
		btn.setMargin(new Insets(5, 20, 5, 20));
		btn.setUI(new ShapedButtonProfile(Constants.COLORBACKGROUNDHEADER));
	}
	
	public void btnAddService() {
		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		btnAdd.setVisible(false);
		btnAddService.setVisible(true);
	}
	
	public void btnAddServiceNo() {
		btnEdit.setVisible(true);
		btnDelete.setVisible(true);
		btnAdd.setVisible(true);
		btnAddService.setVisible(false);
	}

	public JButton getBtnAddService() {
		return btnAddService;
	}

	public void setBtnAddService(JButton btnAddService) {
		this.btnAddService = btnAddService;
	}
	
}
