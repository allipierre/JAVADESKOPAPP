import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class DateShowAPI {

	public JLabel getLabel() {
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		JLabel l = new JLabel(date);
		return l;
	}
}