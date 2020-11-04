import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;

public class AlterColor_JTable extends JTable {
	public AlterColor_JTable(String[][] data, String[] header) {
		super(data, header);
	}
	public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
		Component comp = super.prepareRenderer(renderer, row, col);
		if (row%2 == 0) {
			comp.setBackground(Color.LIGHT_GRAY);
		}
		else {
			comp.setBackground(Color.WHITE);
		}
		return comp;
	}
}
