package co.edu.uptc.view.body.response.tables;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;

public class CellEditorPackage extends DefaultCellEditor {
	private static final long serialVersionUID = 1L;
	private JPanel options;
	
	public CellEditorPackage(JPanel options) {
		super(new JCheckBox());
		this.options = options;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		options.setBackground(table.getBackground());
		return options;
	}
}
