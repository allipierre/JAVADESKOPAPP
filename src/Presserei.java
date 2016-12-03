/**
 * @author yotti
 */

/**
 * @author yotti
 *
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.*;

public class Presserei extends JFrame {
	private double str;
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
	public static String username;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presserei frame = new Presserei(new Presserei1Data(), username);
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
	public Presserei(Presserei1Data data, String username) throws SQLException {
		Table table = new Table(username);
		this.username = username;
		String sql = "";
		String ID = "", ID1 = "";
		// Presserei1 qt = new Presserei1();
		textField_11 = new JTextField();
		// textField_11.setText(qt.textField.getText());
		// String d = textField_11.getText();
		// System.out.println("dd" + d);
		// try {
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		// Connection conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12",
		// "atlantic","Abc#123");
		// Statement stmt = conn.createStatement();
		// // String sql = "SELECT ENAME,EMPNO FROM emp";
		// sql = "SELECT * FROM emp where empno=793";
		// ResultSet rset = stmt.executeQuery(sql);
		//
		// while (rset.next()) {
		// System.out.println(rset.getString(1) + " " + rset.getString(2) + " "
		// + rset.getString(3) + " "
		// + rset.getString(4) + " " + rset.getString(5) + " " +
		// rset.getString(6));
		//
		// ID = rset.getString(1);
		// ID1 = rset.getString(2);
		//
		// }
		// stmt.close();
		// conn.close(); // Close
		// } catch (Exception e) {
		// System.out.println(e);
		// }

		// setMaximizedBounds(new Rectangle(1, 1, 0, 0));
		setBounds(new Rectangle(2, 0, 0, 0));
		setTitle("Presserei");
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setAlignmentX(300.0f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFied_ArbeitsplanNr = new JTextField();
		textFied_ArbeitsplanNr.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textFied_ArbeitsplanNr.setEditable(false);

		textFied_ArbeitsplanNr.setText(doubleToString(data.getArbeitSplanNr()));
		textFied_ArbeitsplanNr.setBounds(10, 36, 116, 32);
		contentPane.add(textFied_ArbeitsplanNr);
		textFied_ArbeitsplanNr.setColumns(10);

		JLabel lblNewLabel = new JLabel("ArbeitsplanNr.");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);

		textField_KommmissionNr = new JTextField();
		textField_KommmissionNr.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textField_KommmissionNr.setEditable(false);
		// textField_KommmissionNr.setText(ID1);

		textField_KommmissionNr.setText(table.getKomm());
		textField_KommmissionNr.getText();
		textField_KommmissionNr.setColumns(10);
		textField_KommmissionNr.setBounds(172, 36, 116, 32);
		contentPane.add(textField_KommmissionNr);

		JLabel lblKommnr = new JLabel("Komm.-Nr.");
		lblKommnr.setBounds(187, 11, 86, 14);
		contentPane.add(lblKommnr);

		textField_Position = new JTextField();
		textField_Position.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textField_Position.setEditable(false);

		textField_Position.setText(table.getPosition());
		textField_Position.setColumns(10);
		textField_Position.setBounds(324, 36, 116, 32);
		contentPane.add(textField_Position);

		textField_Strich = new JTextField();
		textField_Strich.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_Strich.setEditable(false);
		textField_Strich.setText(table.getStrich());
		textField_Strich.setColumns(10);
		textField_Strich.setBounds(477, 36, 116, 32);
		contentPane.add(textField_Strich);

		textField_Kunde = new JTextField();
		textField_Kunde.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textField_Kunde.setEditable(false);
		textField_Kunde.setText(table.getKunde());
		textField_Kunde.setColumns(10);
		textField_Kunde.setBounds(625, 36, 116, 32);
		contentPane.add(textField_Kunde);

		textField_St_ck = new JTextField();
		textField_St_ck.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textField_St_ck.setText(table.getStueck());
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
		panel.setBounds(10, 86, 955, 310);
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
		btnNewButton.setBounds(799, 418, 146, 59);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Speichern");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String value = comboBox.getSelectedItem().toString();
				table.insertData(textField_3.getText(), textField_7.getText(), textField_8.getText(),
						textField_9.getText(), textField_10.getText(), value, textField_4.getText(),
						textField_6.getText(), textField_5.getText(), textField_St_ck.getText(), pm.getDP1(),
						pm.getBP1(), pm.getBOP1());
				table.refreshTable();
			}
		});
		// btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(799, 490, 146, 59);
		contentPane.add(btnNewButton_1);

		table.setBounds(8, 400, 700, 300);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(8, 400, 700, 300);
		js.setVisible(true);
		js.getVerticalScrollBar().setVisible(false);
		UIManager.put("js.width", new Integer(50));
		js.setPreferredSize(new Dimension(400, 400));
		getContentPane().add(js);
		textField_11 = new JTextField();
		// textField_11.setBounds(863, 489, 134, 28);
		textField_11.setText("710");
		System.out.println("wert von textField_11 ist" + textField_11.getText());
		contentPane.add(textField_11);
		textField_11.setColumns(10);

		btnNewButton_2 = new JButton("drücken");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Jasperreport j = new Jasperreport();
//				SwingEmailSender s = new SwingEmailSender();
//				s.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(799, 566, 146, 55);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Send Email");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingEmailSender s = new SwingEmailSender();
			s.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(799, 639, 146, 49);
		contentPane.add(btnNewButton_3);

		// Statement stmt = null;

	}

	private String doubleToString(double val) {
		return Double.toString(val);
	}

	private double getValue(JTextField textField) {

		return Double.valueOf(textField.getText());
	}

	public double gettextFied_ArbeitsplanNr() {
		return str;
	}

	public void settextFied_ArbeitsplanNr(double str) {
		this.str = str;
	}

}