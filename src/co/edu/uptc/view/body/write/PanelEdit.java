package co.edu.uptc.view.body.write;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.header.ShapedNavPanelUI;

public class PanelEdit extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JLabel title;
	protected JLabel lblPlace;
	protected JTextField place;
	protected JLabel lblPrice;
	protected JSpinner price;
	protected JButton btnAddEdit;
	protected ImageIcon imgAddEdit;
	protected Font font;
	
	public PanelEdit(ActionListener listener) {
		setBorder(new EmptyBorder(5,15,5,15));
		setUI(new ShapedNavPanelUI(Constants.COLORBACKGROUNDPANELTWO, Constants.COLORBACKGROUNDPANEL));
		superInitComponents(listener);
	}
	
	public void superInitComponents(ActionListener listener) {
		font = Constants.FONTNORMAL;
		
		title = new JLabel();
		title.setFont(Constants.FONTTITLEPANEL);
		
		lblPrice = new JLabel("Precio");
		lblPrice.setFont(font);
		price = new JSpinner();
		price.setFont(font);
		
		btnAddEdit = new JButton("Buscar");
		imgAddEdit = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/listo.png"));
		btnAddEdit.setIcon(imgAddEdit);
		btnAddEdit.setFont(font);
		btnAddEdit.setForeground(Constants.GREEN);
		btnAddEdit.setBackground(Constants.COLORBACKGROUNDHEADER);
		btnAddEdit.setFocusPainted(false);
		btnAddEdit.setBorderPainted(false);
		btnAddEdit.addActionListener(listener);
	}
	
	public JTextField getPlace() {
		return place;
	}

	public void setPlace(JTextField place) {
		this.place = place;
	}

	public JSpinner getPrice() {
		return price;
	}

	public void setPrice(JSpinner price) {
		this.price = price;
	}

	public JButton getBtnAddEdit() {
		return btnAddEdit;
	}

	public void setBtnAddEdit(JButton btnAddEdit) {
		this.btnAddEdit = btnAddEdit;
	}
	
}
