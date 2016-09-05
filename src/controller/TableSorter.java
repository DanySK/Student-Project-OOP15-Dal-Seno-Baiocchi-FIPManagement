package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableSorter {

	public static void setSorter(JTable table){
    	TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
    	table.setRowSorter(sorter);
    	List<RowSorter.SortKey> sortKeys = new ArrayList<>();
    	 
    	int columnIndexToSort = 0;
    	sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
    	 
    	sorter.setSortKeys(sortKeys);
    	sorter.sort();
	}
	
}
