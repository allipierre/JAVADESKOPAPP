
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Jasperreport {

	public Jasperreport() {
		JasperPrint jasperPrint = null;
		// Compile jrxml file.
		JasperReport jasperReport = null;
		try {
			jasperReport = JasperCompileManager.compileReport("/Users/yotti/Desktop/test.jrxml");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Make sure the output directory exists.
		File outDir = new File("/Users/yotti/Desktop");
		outDir.mkdirs();

		JFrame frame = new JFrame("jasperReport");
		JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
		jasperViewer.setBounds(100, 100, 800, 800);
//		jasperViewer.add(textField);
		frame.setBounds(100, 100, 450, 632);
		frame.getContentPane().add(new JRViewer(jasperPrint));
		frame.getContentPane().add(new JRViewer(jasperPrint));
		frame.pack();
		jasperViewer.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Export to PDF.
		try {
			JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/yotti/Desktop/test.pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done!");
	}
}
