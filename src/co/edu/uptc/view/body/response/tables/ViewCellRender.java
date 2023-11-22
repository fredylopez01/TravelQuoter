package co.edu.uptc.view.body.response.tables;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewCellRender extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	private JPanel options;
	
	public ViewCellRender(JPanel options) {
		this.options = options;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		options.setBackground(comp.getBackground());
		options.setSize(comp.getWidth(), comp.getHeight()); 
		options.setPreferredSize(new Dimension(comp.getWidth(), comp.getHeight()));
		options.setBorder(new EmptyBorder(0, 0, 0, 0));
		return options;
	}
}
