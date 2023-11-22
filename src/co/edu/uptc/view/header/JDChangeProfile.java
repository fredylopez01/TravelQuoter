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

public class JDChangeProfile extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblChoseProfile;
	private JButton btnUser;
	private ImageIcon imgUser;
	private JButton btnManage;
	public ImageIcon imgManage;
	
	public JDChangeProfile(ActionListener listener, JFrame father) {
		super(father, true);
		setTitle("Cambiar Perfil");
		setSize(350, 170);
		setLocation(500, 275);
		getContentPane().setBackground(Color.WHITE);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblChoseProfile = new JLabel("Seleciona el perfil: ");
		lblChoseProfile.setFont(Constants.FONTNAV);
		lblChoseProfile.setForeground(Constants.COLORBACKGROUNDHEADER);
		gbc.insets = new Insets(3, 0, 15, 0);
		add(lblChoseProfile, gbc);
		
		btnUser = new JButton("Usuario");
		imgUser = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/blueAccount.png"));
		btnUser.setIcon(imgUser);
		btnUser.setIconTextGap(5);
		styleButton(btnUser, "userProfile", listener, new Insets(2, 6, 2, 43));
		gbc.gridy = 1;
		gbc.insets = new Insets(3, 0, 3, 0);
		add(btnUser, gbc);
		
		btnManage = new JButton("Administrador");
		imgManage = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/manage.png"));
		btnManage.setIcon(imgManage);
		styleButton(btnManage, "administratorProfile", listener, new Insets(2, 6, 2, 6));
		gbc.gridy = 2;
		add(btnManage, gbc);
	}
	
	public void styleButton(JButton btn, String comand, ActionListener listener, Insets insets) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonProfile(Constants.COLORBACKGROUNDHEADER));
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
	}

}
