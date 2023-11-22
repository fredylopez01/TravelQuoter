package co.edu.uptc.view.body.search;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.header.ShapedNavPanelUI;

public class PanelService extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JLabel title;
	protected JLabel lblPlace;
	protected JComboBox<String> place;
	protected JLabel lblPrice;
	protected JSpinner price;
	protected JButton btnSearch;
	protected ImageIcon imgSearch;
	protected Font font;
	
	public PanelService(ActionListener listener) {
		setBorder(new EmptyBorder(5,15,5,15));
		setUI(new ShapedNavPanelUI(Constants.COLORBACKGROUNDPANEL, Constants.COLORBACKGROUNDPANELTHREE));
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
		
		btnSearch = new JButton("Buscar");
		imgSearch = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/whiteSearch.png"));
		btnSearch.setIcon(imgSearch);
		btnSearch.setFont(font);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Constants.COLORBLUE);
		btnSearch.setFocusPainted(false);
		btnSearch.setBorderPainted(false);
		btnSearch.addActionListener(listener);
	}
	
	public JComboBox<String> getPlace() {
		return place;
	}

	public void setPlace(JComboBox<String> place) {
		this.place = place;
	}

	public JSpinner getPrice() {
		return price;
	}

	public void setPrice(JSpinner price) {
		this.price = price;
	}
	
}
