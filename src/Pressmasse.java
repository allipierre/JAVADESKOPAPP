/**
 * 
 */

/**
 * @author yotti
 *
 */
import java.awt.BorderLayout;

import javax.swing.JPanel;

import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Component;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Pressmasse extends JPanel {

	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	Pressmasse_Modell tm = new Pressmasse_Modell();
	/**
	 * Create the panel.
	 */
	public Pressmasse() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		
		
		

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyDialog m=new MyDialog(textField);
				m.setVisible(true);
			}
		});
		textField.setBounds(6, 45, 116, 32);
		textField.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textField.setAlignmentX(10.0f);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(136, 45, 116, 32);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(264, 45, 134, 32);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("DP");
		lblNewLabel_2.setBounds(183, 23, 17, 17);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_2);

		JLabel lblBp = new JLabel("BP");
		lblBp.setBounds(55, 23, 16, 17);
		lblBp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblBp);

		JLabel lblBop = new JLabel("BOP");
		lblBop.setBounds(315, 23, 26, 17);
		lblBop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblBop);

	}
	
	public String getDP1() {
		return textField_1.getText();
	}
	
	public String getBP1() {
		return textField.getText();
	}
	
	public String getBOP1() {
		return textField_2.getText();
	}

}
