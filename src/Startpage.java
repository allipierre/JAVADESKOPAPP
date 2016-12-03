import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.log.SysoLogger;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

/**
 * 
 */

/**
 * @author yotti
 *
 */
public class Startpage extends JFrame {
	private JPanel contentPane;
	private JButton btnNewButton_3;
	private JButton btnNewButton_2;

	JFrame frmAngebotsportal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startpage window = new Startpage();
					// window.frmAngebotsportal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Startpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		frmAngebotsportal = new JFrame();
		frmAngebotsportal.setTitle("Angebotsportal");
		frmAngebotsportal.setBackground(Color.WHITE);
		frmAngebotsportal.setBounds(100, 100, 1024, 786);
		frmAngebotsportal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Angeboterstellung");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		btnNewButton_1.setOpaque(true);

		// btnNewButton_1.setBackground(new Color(51, 193, 255));
		// btnNewButton_1.setForeground(Color.white);
		// btnNewButton_1.setOpaque(true);
		// btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setBackground(new Color(93, 181, 121));
				btnNewButton_1.setForeground(Color.white);
				btnNewButton_2.setBackground(null);
				btnNewButton_3.setBackground(null);
				btnNewButton_2.setForeground(Color.black);
				btnNewButton_3.setForeground(Color.black);

			}
		});

		btnNewButton_3 = new JButton("Angebotsübersicht");
		btnNewButton_3.setFocusPainted(false);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setBackground(new Color(93, 181, 121));
				btnNewButton_3.setForeground(Color.white);
				btnNewButton_1.setBackground(null);
				btnNewButton_2.setBackground(null);
				btnNewButton_1.setForeground(Color.black);
				btnNewButton_2.setForeground(Color.black);
			}
		});

		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		btnNewButton_3.setOpaque(true);
		// btnNewButton_3.setBackground(new Color(51, 193, 255));
		// btnNewButton_3.setForeground(Color.white);
		// btnNewButton_3.setOpaque(true);
		// btnNewButton_3.setBorderPainted(false);

		btnNewButton_2 = new JButton("Einstellung");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setBackground(new Color(93, 181, 121));
				btnNewButton_2.setForeground(Color.white);
				btnNewButton_1.setBackground(null);
				btnNewButton_3.setBackground(null);
				btnNewButton_1.setForeground(Color.black);
				btnNewButton_3.setForeground(Color.black);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		btnNewButton_2.setOpaque(true);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		btnNewButton.setOpaque(true);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		btnNewButton_4.setOpaque(true);

		JPanel panel = new JPanel();
		
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		if (btnNewButton_1.getBackground().equals(new Color(238, 238, 238))) {
			System.out.println(btnNewButton_1.getBackground());
		}

		JButton btnNewButton_5 = new JButton("Weiter");
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_1.getBackground().equals(new Color(93, 181, 121))) {
					Presserei1 p = new Presserei1();
					p.setVisible(true);
					frmAngebotsportal.setVisible(false);
				} else {
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response = JOptionPane.showConfirmDialog(null, "Sie müssen eine Wahl treffen!", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				}

			}
		});
		
		
		
		btnNewButton_5.setBounds(109, 95, 199, 56);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(109, 216, 199, 56);
		panel.add(btnNewButton_6);

		DateShowAPI d = new DateShowAPI();
		JLabel DateTime = d.getLabel();
		
		DateTime.setBounds(37, 349, 187, 16);
		panel.add(DateTime);
		frmAngebotsportal.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		frmAngebotsportal.getContentPane().add(btnNewButton_1);
		frmAngebotsportal.getContentPane().add(btnNewButton_3);
		frmAngebotsportal.getContentPane().add(btnNewButton_2);
		frmAngebotsportal.getContentPane().add(btnNewButton);
		frmAngebotsportal.getContentPane().add(btnNewButton_4);
		frmAngebotsportal.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, java.awt.BorderLayout.SOUTH);
		panel_1.setBounds(6, 313, 500, 63);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBackground(Color.red);
		panel_1.setSize(500,70);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
	}
}
