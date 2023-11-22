package co.edu.uptc.view.header;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.view.Constants;

public class Header extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private ImageIcon logo;
	private JLabel slogan;
	private JButton btnAccount;
	private ImageIcon imgAccount;
	
	public Header(ActionListener listener) {
		setBackground(Constants.COLORBACKGROUNDHEADER);
		setBorder(new EmptyBorder(5, 70, 5, 70));
		setUI(new ShapedNavPanelUI(Constants.COLORBACKGROUNDPANEL, Constants.COLORBACKGROUNDHEADER));
		initComponents(listener);
		addComponents();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	private void initComponents(ActionListener listener) {
		logo = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/logo.png"));
		lblLogo = new JLabel(logo);
		
		
		slogan = new JLabel("\"EXPLORA SIN PREOCUPACIONES\"");
		slogan.setFont(new Font("Sans Serif", Font.BOLD, 22));
		slogan.setForeground(Constants.COLORFONTHEADER);
		
		btnAccount = new JButton();
		imgAccount = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/header/changeAccount.png"));
		btnAccount.setIcon(imgAccount);
		btnAccount.setContentAreaFilled(false);
		btnAccount.setBorderPainted(false);
		btnAccount.setCursor(Constants.HANDCURSOR);
		btnAccount.setMargin(new Insets(6, 6, 7, 6));
		btnAccount.setFocusPainted(false);
		btnAccount.setActionCommand("account");
		btnAccount.addActionListener(listener);
	}
	
	public void addComponents() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		add(lblLogo, gbc);
		
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 150, 0, 0);
		add(slogan, gbc);
		
		gbc.gridx = 2;
		gbc.insets = new Insets(0, 150, 0, 0);
		add(btnAccount, gbc);
	}
}
