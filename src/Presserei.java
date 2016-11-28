/**
 * 
 */

/**
 * @author yotti
 *
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
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

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Presserei extends JFrame {

	private JPanel contentPane;
	JTextField textFied_ArbeitsplanNr;
	JTextField textField_KommmissionNr;
	private JTextField textField_Position;
	private JTextField textField_Strich;
	private JTextField textField_Kunde;
	private JTextField textField_St_ck;
	private JLabel lblNewLabel_1;
	private JLabel lblPos;
	private JLabel lblStr;
	private JLabel lblStck;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPanel panel_3;
	private JTable table;
	public JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presserei frame = new Presserei();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Presserei(String s) {
		this.textField_11.setText(s);
	}

	public Presserei() throws SQLException {

		String sql = "";
		String ID = "", ID1 = "";
		Presserei1 qt = new Presserei1();
		textField_11 = new JTextField();
		textField_11.setText(qt.textField.getText());
		String d = textField_11.getText();
		System.out.println("dd" + d);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt = conn.createStatement();
			// String sql = "SELECT ENAME,EMPNO FROM emp";
			sql = "SELECT * FROM emp";
			ResultSet rset = stmt.executeQuery(sql);

			while (rset.next()) {
				System.out.println(rset.getString(1) + "   " + rset.getString(2) + "  " + rset.getString(3) + "   "
						+ rset.getString(4) + "  " + rset.getString(5) + "   " + rset.getString(6));

				ID = rset.getString(1);
				ID1 = rset.getString(2);

			}
			stmt.close();
			conn.close(); // Close
		} catch (Exception e) {
			System.out.println(e);
		}

		setMaximizedBounds(new Rectangle(1, 1, 0, 0));
		setBounds(new Rectangle(2, 0, 0, 0));
		setTitle("Presserei");
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setAlignmentX(300.0f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFied_ArbeitsplanNr = new JTextField();
		textFied_ArbeitsplanNr.setEnabled(false);
		// textFied_ArbeitsplanNr.setText(ID);
		// textFied_ArbeitsplanNr.setText(ID);
		textFied_ArbeitsplanNr.getText();
		textFied_ArbeitsplanNr.setBounds(10, 36, 116, 32);
		contentPane.add(textFied_ArbeitsplanNr);
		textFied_ArbeitsplanNr.setColumns(10);

		JLabel lblNewLabel = new JLabel("ArbeitsplanNr.");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);

		textField_KommmissionNr = new JTextField();
		textField_KommmissionNr.setEnabled(false);
		// textField_KommmissionNr.setText(ID1);
		textField_KommmissionNr.getText();
		textField_KommmissionNr.setColumns(10);
		textField_KommmissionNr.setBounds(172, 36, 116, 32);
		contentPane.add(textField_KommmissionNr);

		JLabel lblKommnr = new JLabel("Komm.-Nr.");
		lblKommnr.setBounds(187, 11, 86, 14);
		contentPane.add(lblKommnr);

		textField_Position = new JTextField();
		textField_Position.setEnabled(false);
		textField_Position.setText("aa");
		textField_Position.setColumns(10);
		textField_Position.setBounds(324, 36, 116, 32);
		contentPane.add(textField_Position);

		textField_Strich = new JTextField();
		textField_Strich.setEnabled(false);
		textField_Strich.setText("aa");
		textField_Strich.setColumns(10);
		textField_Strich.setBounds(477, 36, 116, 32);
		contentPane.add(textField_Strich);

		textField_Kunde = new JTextField();
		textField_Kunde.setEnabled(false);
		textField_Kunde.setText("aa");
		textField_Kunde.setColumns(10);
		textField_Kunde.setBounds(625, 36, 116, 32);
		contentPane.add(textField_Kunde);

		textField_St_ck = new JTextField();
		textField_St_ck.setEnabled(false);
		textField_St_ck.setText("aa");
		textField_St_ck.setColumns(10);
		textField_St_ck.setBounds(783, 36, 116, 32);
		contentPane.add(textField_St_ck);

		lblNewLabel_1 = new JLabel("Kunde");
		lblNewLabel_1.setBounds(665, 11, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblPos = new JLabel("Pos.");
		lblPos.setBounds(360, 11, 46, 14);
		contentPane.add(lblPos);

		lblStr = new JLabel("Str.");
		lblStr.setBounds(519, 11, 46, 14);
		contentPane.add(lblStr);

		lblStck = new JLabel("St\u00FCck");
		lblStck.setBounds(819, 11, 46, 14);
		contentPane.add(lblStck);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 86, 955, 379);
		contentPane.add(panel);
		panel.setLayout(null);

		Pressmasse pm = new Pressmasse();
		pm.setBorder(new TitledBorder(null, "Pressmasse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pm.setBounds(19, 17, 413, 109);
		panel.add(pm);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(529, 88, 116, 32);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(807, 29, 116, 32);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(807, 88, 116, 32);
		panel.add(textField_6);

		JLabel lblNewLabel_3 = new JLabel("Formrand");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(444, 37, 61, 16);
		panel.add(lblNewLabel_3);

		JLabel lblPresshhe = new JLabel("Presshöhe");
		lblPresshhe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPresshhe.setBounds(444, 96, 61, 16);
		panel.add(lblPresshhe);

		JLabel lblStck_1 = new JLabel("Unter/\u00DCber Press");
		lblStck_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStck_1.setBounds(681, 37, 116, 16);
		panel.add(lblStck_1);

		JLabel lblFeuchte = new JLabel("Feuchte");
		lblFeuchte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFeuchte.setBounds(694, 96, 61, 16);
		panel.add(lblFeuchte);

		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		JComboBox comboBox = new JComboBox(petStrings);
		comboBox.setSelectedIndex(4);
		comboBox.setBounds(529, 32, 116, 27);
		panel.add(comboBox);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "gemessene H\u00F6he", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(19, 161, 679, 103);
		panel.add(panel_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setAlignmentY(1.0f);
		textField_3.setAlignmentX(10.0f);
		textField_3.setBounds(19, 34, 116, 32);
		panel_2.add(textField_3);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(147, 34, 116, 32);
		panel_2.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(295, 34, 116, 32);
		panel_2.add(textField_8);

		JLabel lblMp = new JLabel("MP1");
		lblMp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMp.setBounds(55, 17, 61, 16);
		panel_2.add(lblMp);

		JLabel lblMp_1 = new JLabel("MP2");
		lblMp_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMp_1.setBounds(184, 17, 61, 16);
		panel_2.add(lblMp_1);

		JLabel lblMp_2 = new JLabel("MP3");
		lblMp_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMp_2.setBounds(327, 17, 61, 16);
		panel_2.add(lblMp_2);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(421, 34, 116, 32);
		panel_2.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(557, 34, 116, 32);
		panel_2.add(textField_10);

		JLabel lblMp_3 = new JLabel("MP4");
		lblMp_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMp_3.setBounds(458, 17, 61, 16);
		panel_2.add(lblMp_3);

		JLabel lblPressdruck = new JLabel("Pressdruck");
		lblPressdruck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPressdruck.setBounds(571, 17, 82, 16);
		panel_2.add(lblPressdruck);

		JButton btnNewButton = new JButton("Zurück");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Presserei1 pr1 = new Presserei1();
				pr1.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(769, 529, 117, 38);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Speichern");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(769, 590, 117, 38);
		contentPane.add(btnNewButton_1);

		/*
		 * table = new JTable(); table.setBounds(122, 23, 139, 14);
		 * panel_3.add(table);
		 */

		Table t = new Table();
		// t.setBounds(8, 500, 800, 150);
		JScrollPane js = new JScrollPane(t);
		js.setBounds(8, 500, 644, 202);
		js.setVisible(true);
		getContentPane().add(js);

		textField_11 = new JTextField();
		// textField_11.setBounds(863, 489, 134, 28);
		textField_11.setText("793");
		System.out.println("wert von textField_11 ist" + textField_11.getText());
		contentPane.add(textField_11);
		textField_11.setColumns(10);

		// Statement stmt = null;

	}
}