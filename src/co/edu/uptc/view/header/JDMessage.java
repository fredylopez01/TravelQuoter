package co.edu.uptc.view.header;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.uptc.view.Constants;

public class JDMessage extends JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon imgMessage;
	private JLabel lblMessage;
	private JButton ok;
	
	public JDMessage(ActionListener listener, JFrame father) {
		super(father, true);
		setTitle("Advertencia");
		setSize(350, 170);
		setLocation(500, 275);
		getContentPane().setBackground(Constants.COLORBACKGROUNDPANEL);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		imgMessage = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/advertence.png"));
		
		lblMessage = new JLabel("Ups!");
		lblMessage.setIcon(imgMessage);
		lblMessage.setFont(Constants.FONTNAV);
		lblMessage.setForeground(Constants.COLORBACKGROUNDHEADER);
		gbc.insets = new Insets(3, 0, 15, 0);
		add(lblMessage, gbc);
		
		
		ok = new JButton("Aceptar");
		ok.setIconTextGap(5);
		styleButton(ok, "ok", listener, new Insets(2, 25, 2, 25));
		gbc.gridy = 2;
		add(ok, gbc);
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

	public JLabel getLblMessage() {
		return lblMessage;
	}

	public void setLblMessage(JLabel lblMessage) {
		this.lblMessage = lblMessage;
	}
	
}
