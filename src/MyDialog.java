import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

/**
 * @author yotti
 *
 */
public class MyDialog extends JDialog implements ActionListener {
	private JTextField sourceTextField;
	JTextField t;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdiv, bmul, bsub, badd, bdec, beq, bdel, bclr;
	static double a = 0, b = 0, result = 0;
	static int operator = 0;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MyDialog dialog = new MyDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	Presserei1 father;

	/*public MyDialog(Presserei1 father) {
		this.father = father;
	}*/

	public MyDialog(JTextField tfSource) {
		setModal(true);
		this.sourceTextField = tfSource;

		t = new JTextField();
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bdiv = new JButton("/");
		bmul = new JButton("*");
		bsub = new JButton("-");
		badd = new JButton("+");
		bdec = new JButton(".");
		beq = new JButton("=");
		bdel = new JButton("Delete");
		bclr = new JButton("Clear");

		t.setBounds(30, 40, 280, 30);
		b7.setBounds(40, 100, 50, 40);
		b8.setBounds(110, 100, 50, 40);
		b9.setBounds(180, 100, 50, 40);
		bdiv.setBounds(250, 100, 50, 40);

		b4.setBounds(40, 170, 50, 40);
		b5.setBounds(110, 170, 50, 40);
		b6.setBounds(180, 170, 50, 40);
		bmul.setBounds(250, 170, 50, 40);

		b1.setBounds(40, 240, 50, 40);
		b2.setBounds(110, 240, 50, 40);
		b3.setBounds(180, 240, 50, 40);
		bsub.setBounds(250, 240, 50, 40);

		bdec.setBounds(40, 310, 50, 40);
		b0.setBounds(110, 310, 50, 40);
		beq.setBounds(180, 310, 50, 40);
		badd.setBounds(250, 310, 50, 40);

		bdel.setBounds(60, 380, 100, 40);
		bclr.setBounds(180, 380, 100, 40);

		contentPanel.add(t);
		contentPanel.add(b7);
		contentPanel.add(b8);
		contentPanel.add(b9);
		contentPanel.add(bdiv);
		contentPanel.add(b4);
		contentPanel.add(b5);
		contentPanel.add(b6);
		contentPanel.add(bmul);
		contentPanel.add(b1);
		contentPanel.add(b2);
		contentPanel.add(b3);
		contentPanel.add(bsub);
		contentPanel.add(bdec);
		contentPanel.add(b0);
		contentPanel.add(beq);
		contentPanel.add(badd);
		contentPanel.add(bdel);
		contentPanel.add(bclr);

		// contentPanel.setLayout(null);
		// .setVisible(true);
		// f.setSize(350,500);
		// f.setBounds(500, 300, 350, 500);
//		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		f.setResizable(false);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b0.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		badd.addActionListener(this);
		bdiv.addActionListener(this);
		bmul.addActionListener(this);
		bsub.addActionListener(this);
		bdec.addActionListener(this);
		beq.addActionListener(this);
		bdel.addActionListener(this);
		bclr.addActionListener(this);

		setBounds(500, 300, 350, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						/**
						 * Made changes here
						 */
						if (sourceTextField != null) {
							sourceTextField.setText(t.getText());
							setVisible(false);
						}
						
						
						

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)
			t.setText(t.getText().concat("1"));

		if (e.getSource() == b2)
			t.setText(t.getText().concat("2"));

		if (e.getSource() == b3)
			t.setText(t.getText().concat("3"));

		if (e.getSource() == b4)
			t.setText(t.getText().concat("4"));

		if (e.getSource() == b5)
			t.setText(t.getText().concat("5"));

		if (e.getSource() == b6)
			t.setText(t.getText().concat("6"));

		if (e.getSource() == b7)
			t.setText(t.getText().concat("7"));

		if (e.getSource() == b8)
			t.setText(t.getText().concat("8"));

		if (e.getSource() == b9)
			t.setText(t.getText().concat("9"));

		if (e.getSource() == b0)
			t.setText(t.getText().concat("0"));

		if (e.getSource() == bdec)
			t.setText(t.getText().concat("."));

		if (e.getSource() == badd) {
			a = Double.parseDouble(t.getText());
			operator = 1;
			t.setText("");
		}

		if (e.getSource() == bsub) {
			a = Double.parseDouble(t.getText());
			operator = 2;
			t.setText("");
		}

		if (e.getSource() == bmul) {
			a = Double.parseDouble(t.getText());
			operator = 3;
			t.setText("");
		}

		if (e.getSource() == bdiv) {
			a = Double.parseDouble(t.getText());
			operator = 4;
			t.setText("");
		}

		if (e.getSource() == beq) {
			b = Double.parseDouble(t.getText());

			switch (operator) {
			case 1:
				result = a + b;
				break;

			case 2:
				result = a - b;
				break;

			case 3:
				result = a * b;
				break;

			case 4:
				result = a / b;
				break;

			default:
				result = 0;
			}

			t.setText("" + result);
		}

		if (e.getSource() == bclr)
			t.setText("");

		if (e.getSource() == bdel) {
			String s = t.getText();
			t.setText("");
			for (int i = 0; i < s.length() - 1; i++)
				t.setText(t.getText() + s.charAt(i));
		}
	}
	
	

}