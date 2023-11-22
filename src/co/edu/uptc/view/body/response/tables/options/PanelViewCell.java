package co.edu.uptc.view.body.response.tables.options;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.response.tables.ShapedButtonTable;

public class PanelViewCell extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon iconView;
	private JButton btnView;
	
	public PanelViewCell(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		iconView = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/body/vista.png"));
		btnView = new JButton(iconView);
		btnView.setContentAreaFilled(false);
		btnView.setCursor(Constants.HANDCURSOR);
		btnView.setActionCommand("viewPackage");
		btnView.addActionListener(listener);
		btnView.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnView.setUI(new ShapedButtonTable());
		add(btnView, gbc);
	}
}
