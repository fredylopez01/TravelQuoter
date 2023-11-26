package co.edu.uptc.view.body.response;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import co.edu.uptc.view.body.response.tables.options.OptionsAdmin;

public class PanelMaxCenterAdmin extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelCenterAdmin panelC;
	private OptionsAdmin options;
	
	public PanelMaxCenterAdmin(ActionListener listener) {
		initComponenets(listener);
	}

	private void initComponenets(ActionListener listener) {
		setLayout(new BorderLayout());
		panelC = new PanelCenterAdmin(listener);
		add(panelC, BorderLayout.NORTH);
		
		options = new OptionsAdmin(listener);
		add(options, BorderLayout.SOUTH);
	}
	
	public void btnAddServicePackage() {
		options.btnAddService();
	}
	
	public void noBtnAddServicePackage() {
		options.btnAddServiceNo();
	}

	public PanelCenterAdmin getPanelC() {
		return panelC;
	}

	public void setPanelC(PanelCenterAdmin panelC) {
		this.panelC = panelC;
	}

	public OptionsAdmin getOptions() {
		return options;
	}

	public void setOptions(OptionsAdmin options) {
		this.options = options;
	}
	
}
