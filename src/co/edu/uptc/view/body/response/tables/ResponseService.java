package co.edu.uptc.view.body.response.tables;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.response.tables.options.PanelViewCell;

public class ResponseService extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblType;
	private JScrollPane scroll;
	private JTable results;
	
	public ResponseService(String type) {
		initComponents(type);
	}

	private void initComponents(String type) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		lblType = new JLabel(type);
		lblType.setFont(Constants.FONTTITLEPANEL);
		add(lblType, gbc);
		
		results = new JTable();
		results.setFont(Constants.FONTNORMAL);
		scroll = new JScrollPane(results, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(800, 180));
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(scroll, gbc);
	}

	public void showResults(DefaultTableModel nModel) {
		results.setModel(nModel);
	}
	
	public void styleTable() {
		JTableHeader jth = results.getTableHeader();
		jth.setDefaultRenderer(new TitleCellRender());
		results.setTableHeader(jth);
		results.setRowHeight(30);
	}
	
	public void optionsPackage(ActionListener listener, boolean isAdministrator) {
		PanelViewCell options = new PanelViewCell(listener);
		results.getColumnModel().getColumn(3).setCellRenderer(new ViewCellRender(options));
		results.getColumnModel().getColumn(3).setCellEditor(new CellEditorPackage(options));
	}

	public JLabel getLblType() {
		return lblType;
	}

	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	public JTable getResults() {
		return results;
	}

	public void setResults(JTable results) {
		this.results = results;
	}
	
}
