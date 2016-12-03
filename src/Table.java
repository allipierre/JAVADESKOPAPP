import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.itextpdf.text.log.SysoLogger;

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
	String username;
	Table_Model data = new Table_Model();
	DefaultTableModel model;
	ResultSet rset;

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public Table(String username) {
		String sql = "";
		String sql1 = "";
		String sql2 = "";
		String sql3 = "", sql4 = "";
		ResultSet rset1, rset2, rset3, rset4;
		this.username = username;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement(), stmt3 = conn.createStatement(), stmt4 = conn.createStatement();
			// String sql = "SELECT ENAME,EMPNO FROM emp";
			sql = "SELECT PRE_ID, SOME_FLAG,PRE_STUECK,PRE_BP,PRE_DP,PRE_BOP,PRE_FORMRAND,PRE_PRESSHOEHE,PRE_FEUCHTE,PRE_MT FROM PRESSEREI_ERFASSUNG where PRE_ARBEITSPLANNUMMER="
					+ username;
			sql1 = "SELECT DEPTNO  FROM emp where EMPNO=" + username;
			sql2 = "SELECT ENAME  FROM emp where EMPNO=" + username;
			sql3 = "SELECT JOB  FROM emp where EMPNO=" + username;
			sql4 = "SELECT MGR  FROM emp where EMPNO=" + username;
			System.out.println("username " + this.username);
			System.out.println("username " + this.username);
			rset = stmt.executeQuery(sql);
			rset1 = stmt1.executeQuery(sql1);
			rset2 = stmt2.executeQuery(sql2);
			rset3 = stmt3.executeQuery(sql3);
			rset4 = stmt4.executeQuery(sql4);
			while (rset1.next()) {

				System.out.println("Komm" + rset1.getString(1));
				data.setkommisionnr(rset1.getString(1));

				System.out.println("hhh" + data.getkommisionnr());
			}
			stmt1.close();

			while (rset2.next()) {

				data.setpositionr(rset2.getString(1));

			}
			stmt2.close();

			while (rset3.next()) {

				data.setstrich(rset3.getString(1));

			}
			stmt3.close();
			while (rset4.next()) {

				data.setkunde(rset4.getString(1));

			}
			stmt4.close();

			// while (rset.next()) {
			// System.out.println(rset.getString(1) + " " + rset.getString(2) +
			// " " + rset.getString(3) + " "
			// + rset.getString(4) + " " + rset.getString(5) + " " +
			// rset.getString(6));
			//
			//
			//
			// }
			// stmt.close();
			// conn.close(); // Close

			// String[] columnNames = {"MP1",
			// "MP2",
			// "Sport",
			// "MP3",
			// "Mp4",
			// "Pressdruck"};

			ResultSetMetaData metaData = rset.getMetaData();

			// names of columns
			Vector<String> columnNames = new Vector<String>();
			int columnCount = metaData.getColumnCount();
			for (int column = 1; column <= columnCount; column++) {
				columnNames.add(metaData.getColumnName(column));
			}
			//
			// Object[][] data = {
			// {rset.getString(1), rset.getString(2),
			// rset.getString(3), rset.getString(4),
			// rset.getString(5),rset.getString(6)}
			// };
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

			model = new DefaultTableModel(data, columnNames) {
				public boolean isCellEditable(int row, int column) {
					if (column == 0) {
						return true;
					} else {
						return false;
					}
				}

				public Class getColumnClass(int c) {
					switch (c) {
					case 0:
						return Boolean.class;
					default:
						return String.class;
					}
				}
			};

			// BetterJTable table = new7BetterJTable(model);
			table_1 = new BetterJTable(model);
			table_1.setSurrendersFocusOnKeystroke(true);
			table_1.setShowVerticalLines(true);
			table_1.setShowHorizontalLines(true);

			table_1.setShowGrid(true);
			model.addRow(new Object[0]);
			model.setValueAt(false, 0, 0);

			JTableHeader th = table_1.getTableHeader();
			th.setPreferredSize(new Dimension(35, 35));
			th.setBackground(Color.BLUE);
			th.setForeground(Color.white);
			th.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			th.setAlignmentX(CENTER_ALIGNMENT);
			th.setAlignmentY(CENTER_ALIGNMENT);
			th.setResizingAllowed(isEnabled());
			th.setReorderingAllowed(isEnabled());
			th.setUpdateTableInRealTime(isEnabled());

			table_1.setOpaque(true);
			setColumnModel(table_1, columnCount);
			table_1.setBorder(null);
			table_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			table_1.setRowHeight(40);
			table_1.setBounds(8, 480, 700, 300);
			table_1.setAutoResizeMode(WIDTH);
			table_1.setAlignmentX(CENTER_ALIGNMENT);
			table_1.setAlignmentY(CENTER_ALIGNMENT);
			table_1.setAutoCreateColumnsFromModel(isEnabled());
			table_1.setAutoResizeMode(HEIGHT);
			table_1.setAutoscrolls(isEnabled());
			table_1.setName("REPORT");
			table_1.setColumnSelectionAllowed(isEnabled());
			// table_1.isCellEditable(1, 1);

			table_1.setCellSelectionEnabled(true);
			table_1.setColumnSelectionAllowed(true);
			JScrollPane js = new JScrollPane(table_1);
			js.setBounds(8, 480, 700, 300);
			setBounds(8, 480, 700, 300);
			js.setBackground(Color.BLUE);
			js.setAutoscrolls(true);
			js.setFont(new Font("Arial", js.getFont().getStyle(), js.getFont().getSize() + 1));
			js.setSize(new Dimension(3, 3));
			js.setVisible(true);
			js.getVerticalScrollBar().setPreferredSize(new Dimension(50, 50));
			js.getHorizontalScrollBar().setPreferredSize(new Dimension(50, 50));
			UIManager.put(js, Color.RED);

			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(js, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
							.addGap(5).addComponent(js, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)));
			setLayout(groupLayout);
			// return table;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Sets the cell renderer for each column in the table
	 * 
	 * @param t
	 *            the table
	 * @param columnCount
	 *            number of columns
	 */
	private void setColumnModel(BetterJTable t, int columnCount) {
		CellRenderer renderer = new CellRenderer();

		for (int i = 0; i < columnCount; i++) {
			t.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}

	public String getKomm() {
		return data.getkommisionnr();
	}

	public String getPosition() {
		return data.getposition();
	}

	public String getStrich() {
		return data.getstrich();
	}

	public String getKunde() {
		return data.getkunde();
	}

	public String getStueck() {
		return data.getstueck();
	}

	public void insertData(String MP1, String MP2, String MP3, String MP4, String Pressdruck, String Formrand,
			String Presshohe, String Feuche, String durch, String stueck, String DP, String BP, String BOP) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");

			String queryInsert = "INSERT INTO PRESSEREI_ERFASSUNG( PRE_ARBEITSPLANNUMMER, PRE_STUECK, PRE_BP, PRE_DP, PRE_BOP, PRE_FORMRAND,PRE_PRESSHOEHE,PRE_FEUCHTE,PRE_MT,PRE_MP1,PRE_MP2,PRE_MP3,PRE_MP4,PRE_PRESSDRUCK)"
					+ "VALUES ('" + username + "','" + stueck + "','" + BP + "','" + DP + "','" + BOP + "','" + Formrand
					+ "','" + Presshohe + "','" + Feuche + "','" + durch + "','" + MP1 + "','" + MP2 + "','" + MP3
					+ "','" + MP4 + "','" + Pressdruck + "')";
			Statement stmi = (Statement) conn.createStatement();
			ResultSet rs;
			stmi.executeUpdate(queryInsert);
		} catch (Exception e) {
			System.out.println(e + "aav");
		}
	}

	public void refreshTable() {
		model.setRowCount(0);

		// query database again and set model to table
		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt = conn.createStatement();
			// String sql = "SELECT ENAME,EMPNO FROM emp";
			sql = "SELECT PRE_ID, SOME_FLAG,PRE_STUECK,PRE_BP,PRE_DP,PRE_BOP,PRE_FORMRAND,PRE_PRESSHOEHE,PRE_FEUCHTE,PRE_MT FROM PRESSEREI_ERFASSUNG where PRE_ARBEITSPLANNUMMER="
					+ username;

			rset = stmt.executeQuery(sql);

			// while (rset.next()) {
			// System.out.println(rset.getString(1) + " " + rset.getString(2)
			// + " " + rset.getString(3) + " "
			// + rset.getString(4) + " " + rset.getString(5) + " " +
			// rset.getString(6));
			//
			//
			//
			// }
			// stmt.close();
			// conn.close(); // Close

			// String[] columnNames = {"MP1",
			// "MP2",
			// "Sport",
			// "MP3",
			// "Mp4",
			// "Pressdruck"};

			ResultSetMetaData metaData = rset.getMetaData();

			// names of columns
			Vector<String> columnNames = new Vector<String>();
			int columnCount = metaData.getColumnCount();
			for (int column = 1; column <= columnCount; column++) {
				columnNames.add(metaData.getColumnName(column));
			}
			//
			// Object[][] data = {
			// {rset.getString(1), rset.getString(2),
			// rset.getString(3), rset.getString(4),
			// rset.getString(5),rset.getString(6)}
			// };
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

			model = new DefaultTableModel(data, columnNames) {
				public boolean isCellEditable(int row, int column) {
					return false;// This causes all cells to be not editable
				}
			};

			table_1.setModel(model);

		} catch (Exception e) {
			System.out.println(e + "aa");
		}

	}
}
