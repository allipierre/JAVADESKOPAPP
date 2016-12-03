import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;

/**
 * 
 */

/**
 * @author yotti
 *
 */
public class setDiscountNames {

	JComboBox list;

	public setDiscountNames(JComboBox list) {

		this.list = list;

		String sql = "";

		ResultSet rset = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			stmt = conn.createStatement();

			sql = "SELECT EMPNO  FROM emp";

			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				this.list.addItem(rset.getString(1));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		} finally {
			try {
				stmt.close();
				rset.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR Close");
			}
		}

	}
}
