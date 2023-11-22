package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ViewAgency extends JFrame {
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private MainPanel panelWindow;
	
	public ViewAgency(ActionListener listener, MouseListener mListener, WindowListener windowL) {
		super("Travel Quoter");
		setSize(1050, 600);
		initComponents(listener, mListener);
		addWindowListener(windowL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void initComponents(ActionListener listener, MouseListener mListener) {
		icon = new ImageIcon(getClass().getResource("images/icon.png"));
		setIconImage(icon.getImage());

		panelWindow = new MainPanel(listener, this, mListener);
		add(panelWindow);
	}

	public MainPanel getPanelWindow() {
		return panelWindow;
	}

	public void setPanelWindow(MainPanel panelWindow) {
		this.panelWindow = panelWindow;
	}
	
}
