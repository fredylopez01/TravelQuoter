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
import javax.swing.JPasswordField;

import co.edu.uptc.view.Constants;

public class JDVerifyIdentity extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblPassword;
	private JPasswordField password;
	private JButton btnUser;
	private ImageIcon imgUser;
	
	public JDVerifyIdentity(ActionListener listener, JFrame father) {
		super(father, true);
		setTitle("Comprobar Credenciales");
		setSize(350, 170);
		setLocation(500, 275);
		getContentPane().setBackground(Color.WHITE);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblPassword = new JLabel("Contraseña: ");
		lblPassword.setFont(Constants.FONTNAV);
		lblPassword.setForeground(Constants.COLORBACKGROUNDHEADER);
		gbc.insets = new Insets(3, 0, 15, 0);
		add(lblPassword, gbc);
		
		password = new JPasswordField(10);
		password.setFont(Constants.FONTNAV);
		gbc.gridy = 1;
		gbc.insets = new Insets(3, 0, 3, 0);
		add(password, gbc);
		
		btnUser = new JButton("Verificar");
		imgUser = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/blueAccount.png"));
		btnUser.setIcon(imgUser);
		btnUser.setIconTextGap(5);
		styleButton(btnUser, "verifyPassword", listener, new Insets(2, 25, 2, 25));
		gbc.gridy = 2;
		add(btnUser, gbc);
	}
	
	public void styleButton(JButton btn, String comand, ActionListener listener, Insets insets) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Constants.COLORBACKGROUNDHEADER);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonProfile(Constants.COLORBACKGROUNDPANELTWO));
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	
}
