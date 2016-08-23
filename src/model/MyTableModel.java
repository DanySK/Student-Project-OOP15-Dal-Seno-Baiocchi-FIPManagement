package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel {
	
	
	private Model model;
	private String[] columnNames = new String[]{"Championship", "Zone"};
	public int parametro;
	
	public MyTableModel(Model model) {
	    this.model = model;
        }



    @Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return model.getChampionship().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Championship ch = (Championship) model.getChampionship().toArray()[rowIndex];
		if(columnIndex == 0){
			return ch.getDivision().toString();	
		}else{
			return ch.getZone().toString();
		}
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	

}
