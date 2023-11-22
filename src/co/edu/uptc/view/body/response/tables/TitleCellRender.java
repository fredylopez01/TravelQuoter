package co.edu.uptc.view.body.response.tables;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import co.edu.uptc.view.Constants;

public class TitleCellRender extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JComponent jc = null;
		jc = new JLabel((String) value);
		((JLabel)jc).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)jc).setSize(jc.getWidth()+5, jc.getHeight()+10);   
        ((JLabel)jc).setPreferredSize( new Dimension(jc.getWidth()+5, jc.getHeight()+10));
        jc.setFont(Constants.FONTNORMAL);
        jc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        jc.setOpaque(true);
		jc.setBackground(Constants.COLORBACKGROUNDHEADER);
		jc.setForeground(Color.WHITE);
		jc.setToolTipText("Tabla de Resultados");
		return jc;
	}
}
