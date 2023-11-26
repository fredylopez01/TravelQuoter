package co.edu.uptc.view.body;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.view.body.search.PanelSearch;
import co.edu.uptc.view.nav.Nav;

public class Body extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	private Nav nav;
	private MainPCenter panelCenter;
	private CardLayout cPanelCenter;
	
	public Body(ActionListener listener, MouseListener mListener) {
		initComponents(listener, mListener);
	}
	
	@Override
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/body1.png")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	public void initComponents(ActionListener listener, MouseListener mListener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		nav = new Nav(listener, mListener);
		gbc.gridy = 0;
		add(nav, gbc);
		
		gbc.gridy = 1;
		panelCenter = new MainPCenter(listener);
		add(panelCenter, gbc);
		cPanelCenter = (CardLayout) panelCenter.getLayout();
		cPanelCenter.show(panelCenter, "panelUser");
	}
	
	public void btnAddServicePackage() {
		panelCenter.getPanelAdminist().btnAddServicePackage();
	}
	
	public void noBtnAddServicePackage() {
		panelCenter.getPanelAdminist().noBtnAddServicePackage();
	}
	
	public Nav getNav() {
		return nav;
	}

	public void setNav(Nav nav) {
		this.nav = nav;
	}
	
	public MainPCenter getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(MainPCenter panelCenter) {
		this.panelCenter = panelCenter;
	}

	public PanelSearch getPanelS() {
		return panelCenter.getPanelCenterUser().getPanelSearch();
	}

	public void setPanelS(PanelSearch panelS) {
		panelCenter.getPanelCenterUser().setPanelSearch(panelS);
	}

	public CardLayout getcPanelCenter() {
		return cPanelCenter;
	}

	public void setcPanelCenter(CardLayout cPanelCenter) {
		this.cPanelCenter = cPanelCenter;
	}
	
}
