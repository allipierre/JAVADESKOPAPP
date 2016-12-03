
import java.awt.*;
import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The start window. Contains the Application Icon.
 */

public class ProgressFrame  extends JFrame {
	ProgressFrame(){
	Frame window = new Frame();
	
	try {
		add(new JLabel("", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	window.setBounds(500, 150, 300, 200);
	window.setVisible(true);
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	window.setVisible(false);
	window.dispose();
}

}