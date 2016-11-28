import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.Color;

/**
 * 
 */

/**
 * @author yotti
 *
 */
public class Table extends JPanel {
	private BetterJTable table_1;
	

	/**
	 * Create the panel.
	 * @return 
	 */
	public  Table() {
		String sql = "";
		ResultSet rset;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt = conn.createStatement();
			// String sql = "SELECT ENAME,EMPNO FROM emp";
			sql = "SELECT * FROM emp";
			 rset = stmt.executeQuery(sql);

//			while (rset.next()) {
//				System.out.println(rset.getString(1) + "   " + rset.getString(2) + "  " + rset.getString(3) + "   "
//						+ rset.getString(4) + "  " + rset.getString(5) + "   " + rset.getString(6));
//
//				
//
//			}
//			stmt.close();
//			conn.close(); // Close
		

//		String[] columnNames = {"MP1",
//                "MP2",
//                "Sport",
//                "MP3",
//                "Mp4",
//                "Pressdruck"};

		    ResultSetMetaData metaData = rset.getMetaData();

		    // names of columns
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }
//		
//		Object[][] data = {
//			    {rset.getString(1), rset.getString(2),
//			     rset.getString(3), rset.getString(4), rset.getString(5),rset.getString(6)}
//			};
//		
		    
		 // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rset.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rset.getObject(columnIndex));
		        }
		        data.add(vector);
		    }
		
		
		TableModel model = new DefaultTableModel(data, columnNames)
		  {
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		 
		
		 //BetterJTable table = new BetterJTable(model);
		 table_1 = new BetterJTable(model);
		 table_1.setBorder(null);
		 table_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		 table_1.setCellSelectionEnabled(true);
		 table_1.setColumnSelectionAllowed(true);
		JScrollPane js=new JScrollPane(table_1);
		js.setBackground(new Color(0, 0, 153));
		js.setAutoscrolls(true);
		js.setFont(new Font("Arial", js.getFont().getStyle(), js.getFont().getSize() + 1));
		js.setSize(new Dimension(3, 2));
		js.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(js, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(js, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		//return table;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
