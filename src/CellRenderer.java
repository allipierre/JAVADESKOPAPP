import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;

/**
 * Cell renderer is responsible for styling the cells of the table
 */
public class CellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
    	Component res = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // if its an even row then a light gray background is set
        // else a white
        // this will cause the alternating rows
    	
    	TableColumn column1 = null;
    	for (int i = 0; i < 5; i++) {
    		column1 = table.getColumnModel().getColumn(i);
    	    if (i == 2) {
    	    	column1.setPreferredWidth(100); //third column is bigger
    	    } else {
    	    	column1.setPreferredWidth(50);
    	    }
    	}
    	
    	
    	
        if (row%2==0) {
            res.setBackground(Color.red);
            res.setForeground(Color.blue);
            //table.setBackground(bg);;
            
        } else {
            res.setBackground(Color.blue);
            res.setForeground(Color.red);
            //table.setBackground(Color.blue);
            
        }
        return res;
    }
    
}
