package co.edu.uptc.view.body.response.rServices;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;

public class PanelNoResults extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton back;
	private ImageIcon iconBack;
	private JLabel message;
	private ImageIcon noResults;
	
	public PanelNoResults(ActionListener listener) {
		setBackground(Color.DARK_GRAY);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		iconBack = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/back.png"));
		back = new JButton();
		back.setIcon(iconBack);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setCursor(Constants.HANDCURSOR);
		back.setActionCommand("back");
		back.addActionListener(listener);
		iconBack = new ImageIcon();
		gbc.insets = new Insets(10, 5, 30, 100);
		add(back, gbc);
		
		noResults = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/noResults.png"));
		message = new JLabel("0 COINCIDENCIAS");
		message.setIcon(noResults);
		message.setFont(Constants.FONTNORESULTS);
		message.setForeground(Color.RED);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 5, 30, 85);
		add(message, gbc);
	}
}
