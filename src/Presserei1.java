import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.Dialog.ModalityType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;

/**
 * 
 */

/**
 * @author yotti
 *
 */
public class Presserei1 extends JFrame {
	
	 private Dialog dialogPanel = new Dialog();
	 private JDialog dialog;
	public  Object object;
	public int tz;

	private JPanel contentPane;
	public String textField1;
	public JTextField textField;
	public static JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

	private static void createAndShowUIE() {
		try {
			Presserei1 frame = new Presserei1();
			//frame.pack();
			//frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUIE();
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public Presserei1(String s) {
		textField = new JTextField();
		this.textField.setText(s);
	}

	public Presserei1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Bitte eingeben", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(6, 6, 1018, 726);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyDialog m=new MyDialog();
				m.setVisible(true);
			}
		});
		textField.setBounds(6, 62, 116, 32);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ArbeitsplanNr");
		lblNewLabel.setBounds(14, 34, 108, 16);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(177, 62, 116, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 object = e.getX();
				 tz=e.getX();
				System.out.println(e.getX());
				System.out.println("a"+tz);
				MyDialog m=new MyDialog();
				m.setVisible(true);
			}
		});
		textField_1.setEditable(false);
		textField_1.setFocusable(false);
		
		
		
		// textField_1=JOptionPane.showInputDialog(null, "message");

		JLabel lblKomm = new JLabel("Komm.-Nr");
		lblKomm.setBounds(196, 34, 76, 16);
		panel.add(lblKomm);

		textField_2 = new JTextField();
		textField_2.setBounds(320, 62, 116, 32);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPos = new JLabel("Pos.");
		lblPos.setBounds(353, 34, 61, 16);
		panel.add(lblPos);

		textField_3 = new JTextField();
		textField_3.setBounds(6, 168, 116, 32);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblStr = new JLabel("Str.");
		lblStr.setBounds(28, 140, 61, 16);
		panel.add(lblStr);

		textField_4 = new JTextField();
		textField_4.setBounds(177, 168, 116, 32);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblKunde = new JLabel("Kunde");
		lblKunde.setBounds(231, 140, 61, 16);
		panel.add(lblKunde);

		textField_5 = new JTextField();
		textField_5.setBounds(331, 168, 116, 32);
		panel.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblStck = new JLabel("Stück");
		lblStck.setBounds(353, 151, 61, 16);
		panel.add(lblStck);

		JButton btnNewButton = new JButton("Weiter");
		btnNewButton.setBounds(613, 113, 117, 38);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// this.setVisible(false);

					Presserei pr = new Presserei();
					pr.setVisible(true);
					setVisible(false);
					pr.textField_KommmissionNr.setText(getKommission().getText());
					pr.textFied_ArbeitsplanNr.setText(getUsername().getText());
					// Presserei pra = new Presserei(getUsername());

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}

	public JTextField getUsername() {
		textField1 = textField.getText();
		System.out.println("wert von testfield1" + textField1);
		return textField;
	}

	 private void openTableAction() {
	      
	      dialogPanel.setVisible(true); // here the modal dialog takes over

	      // this line starts *after* the modal dialog has been disposed
	      // **** here's the key where I get the String from JTextField in the GUI held
	      // by the JDialog and put it into this GUI's JTextField.
	      textField_1.setText(dialogPanel.getFieldText());
	   }
	

	public JTextField getKommission() {
		return textField_1;
	}
	
	

}
