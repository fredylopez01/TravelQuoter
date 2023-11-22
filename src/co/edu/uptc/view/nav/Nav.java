package co.edu.uptc.view.nav;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.view.Constants;

public class Nav extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnFlight;
	private ImageIcon imgFlightBlue;
	private ImageIcon imgFlightOrange;
	private JButton btnHouse;
	private ImageIcon imgHouseOrange;
	private ImageIcon imgHouseBlue;
	private JButton btnCar;
	private ImageIcon imgCarOrange;
	private ImageIcon imgCarBlue;
	private JButton btnMess;
	private ImageIcon imgMessOrange;
	private ImageIcon imgMessBlue;
	private JButton btnActivity;
	private ImageIcon imgActivityOrange;
	private ImageIcon imgActivityBlue;
	private JButton btnPackage;
	private ImageIcon imgPackageOrange;
	private ImageIcon imgPackageBlue;
	
	public Nav(ActionListener listener, MouseListener mListener) {
		setBackground(Constants.GRAY);
		setBorder(new EmptyBorder(15, 23, 5, 23));
		initComponents(listener, mListener);
		addComponents();
	}

	private void initComponents(ActionListener listener, MouseListener mListener) {
		btnFlight = new JButton("Vuelos");
		imgFlightBlue = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/blueFlight.png"));
		imgFlightOrange = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/flightNormal.png"));
		styleButton(btnFlight, imgFlightBlue, "fligths", listener, mListener);
		btnFlight.setBackground(Constants.COLORBACKGROUNDPANEL);
		btnFlight.setForeground(Constants.COLORBLUE);
		
		btnHouse = new JButton("Alquiler");
		imgHouseOrange = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/homeNormal.png"));
		imgHouseBlue = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/blueHome.png"));
		styleButton(btnHouse, imgHouseOrange, "houses", listener, mListener);
		
		btnCar = new JButton("Vehículos");
		imgCarOrange = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/carNormal.png"));
		imgCarBlue = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/blueCar.png"));
		styleButton(btnCar, imgCarOrange, "cars", listener, mListener);
		
		btnMess = new JButton("Traslados");
		imgMessOrange = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/truckNormal.png"));
		imgMessBlue = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/blueMess.png"));
		styleButton(btnMess, imgMessOrange, "messes", listener, mListener);
		
		btnActivity = new JButton("Actividades");
		imgActivityOrange = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/activityNormal.png"));
		imgActivityBlue = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/blueActivity.png"));
		styleButton(btnActivity, imgActivityOrange, "activities", listener, mListener);
		
		btnPackage = new JButton("Paquetes");
		imgPackageOrange = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/packageNormal.png"));
		imgPackageBlue = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/nav/bluePackage.png"));
		styleButton(btnPackage, imgPackageOrange, "packages", listener, mListener);
	}
	
	public void styleButton(JButton btn, ImageIcon icon, String comand, ActionListener listener, MouseListener mListener) {
		btn.setIcon(icon);
		btn.setFont(Constants.FONTNAV);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBackground(Constants.COLORBLUE);
		btn.setForeground(Constants.COLORBACKGROUNDPANEL);
		btn.setBorderPainted(false);
		btn.setIconTextGap(5);
		btn.setMargin(new Insets(5, 10, 5, 10));
		btn.setFocusPainted(false);
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
		btn.addMouseListener(mListener);
	}

	private void addComponents() {
		setLayout(new GridLayout(1, 6));
		add(btnFlight);
		add(btnHouse);
		add(btnCar);
		add(btnMess);
		add(btnActivity);
		add(btnPackage);
	}
	
	public void buttonSelect(JButton btn, ImageIcon icon) {
		buttonsClean();
		btn.setIcon(icon);
		btn.setBackground(Constants.COLORBACKGROUNDPANEL);
		btn.setForeground(Constants.COLORBLUE);
	}
	
	public void buttonsClean() {
		buttonClean(btnFlight, imgFlightOrange);
		buttonClean(btnHouse, imgHouseOrange);
		buttonClean(btnCar, imgCarOrange);
		buttonClean(btnMess, imgMessOrange);
		buttonClean(btnActivity, imgActivityOrange);
		buttonClean(btnPackage, imgPackageOrange);
	}
	
	public void buttonHover(JButton btn) {
		btn.setBackground(Constants.COLORBACKGROUNDPANELTWO);
		btn.setForeground(Constants.COLORBACKGROUNDHEADER);
	}
	
	public void buttonNormal(JButton btn) {
		btn.setBackground(Constants.COLORBLUE);
		btn.setForeground(Constants.COLORBACKGROUNDPANEL);
	}
	
	public void buttonClean(JButton btn, ImageIcon icon) {
		btn.setIcon(icon);
		btn.setBackground(Constants.COLORBLUE);
		btn.setForeground(Constants.COLORBACKGROUNDPANEL);
	}

	public JButton getBtnFlight() {
		return btnFlight;
	}

	public void setBtnFlight(JButton btnFlight) {
		this.btnFlight = btnFlight;
	}

	public ImageIcon getImgFlightBlue() {
		return imgFlightBlue;
	}

	public void setImgFlightBlue(ImageIcon imgFlightBlue) {
		this.imgFlightBlue = imgFlightBlue;
	}

	public ImageIcon getImgFlightOrange() {
		return imgFlightOrange;
	}

	public void setImgFlightOrange(ImageIcon imgFlightOrange) {
		this.imgFlightOrange = imgFlightOrange;
	}

	public JButton getBtnHouse() {
		return btnHouse;
	}

	public void setBtnHouse(JButton btnHouse) {
		this.btnHouse = btnHouse;
	}

	public ImageIcon getImgHouseOrange() {
		return imgHouseOrange;
	}

	public void setImgHouseOrange(ImageIcon imgHouseOrange) {
		this.imgHouseOrange = imgHouseOrange;
	}

	public ImageIcon getImgHouseBlue() {
		return imgHouseBlue;
	}

	public void setImgHouseBlue(ImageIcon imgHouseBlue) {
		this.imgHouseBlue = imgHouseBlue;
	}

	public JButton getBtnCar() {
		return btnCar;
	}

	public void setBtnCar(JButton btnCar) {
		this.btnCar = btnCar;
	}

	public ImageIcon getImgCarOrange() {
		return imgCarOrange;
	}

	public void setImgCarOrange(ImageIcon imgCarOrange) {
		this.imgCarOrange = imgCarOrange;
	}

	public ImageIcon getImgCarBlue() {
		return imgCarBlue;
	}

	public void setImgCarBlue(ImageIcon imgCarBlue) {
		this.imgCarBlue = imgCarBlue;
	}

	public JButton getBtnMess() {
		return btnMess;
	}

	public void setBtnMess(JButton btnMess) {
		this.btnMess = btnMess;
	}

	public ImageIcon getImgMessOrange() {
		return imgMessOrange;
	}

	public void setImgMessOrange(ImageIcon imgMessOrange) {
		this.imgMessOrange = imgMessOrange;
	}

	public ImageIcon getImgMessBlue() {
		return imgMessBlue;
	}

	public void setImgMessBlue(ImageIcon imgMessBlue) {
		this.imgMessBlue = imgMessBlue;
	}

	public JButton getBtnActivity() {
		return btnActivity;
	}

	public void setBtnActivity(JButton btnActivity) {
		this.btnActivity = btnActivity;
	}

	public ImageIcon getImgActivityOrange() {
		return imgActivityOrange;
	}

	public void setImgActivityOrange(ImageIcon imgActivityOrange) {
		this.imgActivityOrange = imgActivityOrange;
	}

	public ImageIcon getImgActivityBlue() {
		return imgActivityBlue;
	}

	public void setImgActivityBlue(ImageIcon imgActivityBlue) {
		this.imgActivityBlue = imgActivityBlue;
	}

	public JButton getBtnPackage() {
		return btnPackage;
	}

	public void setBtnPackage(JButton btnPackage) {
		this.btnPackage = btnPackage;
	}

	public ImageIcon getImgPackageOrange() {
		return imgPackageOrange;
	}

	public void setImgPackageOrange(ImageIcon imgPackageOrange) {
		this.imgPackageOrange = imgPackageOrange;
	}

	public ImageIcon getImgPackageBlue() {
		return imgPackageBlue;
	}

	public void setImgPackageBlue(ImageIcon imgPackageBlue) {
		this.imgPackageBlue = imgPackageBlue;
	}
	
}
