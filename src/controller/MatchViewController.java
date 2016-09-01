package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JTable;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.IModel;
import model.Player;
import model.StatisticModel;
import observer.MatchViewObserver;

public class MatchViewController implements MatchViewObserver {

    private StatisticModel stat;
    private IModel model;
    private List<String> valueable;
    private Set<String> id;
    private XSSFCell cell;
    private XSSFWorkbook workbook;

	public MatchViewController(IModel model, StatisticModel stat) {
		this.model = model;
		this.stat = stat;
		
	}
	
	@Override
	public void saveMatch(JTable homeTable, JTable guestTable,String homeName,String guestName) {
	    workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet();
	    
	    TreeMap<String, List<String>> data = new TreeMap<>();
	    ArrayList<String> header = new ArrayList<>();
	    for(int k = 0; k <= (homeTable.getColumnCount()-1);k++){
	        header.add(homeTable.getColumnName(k));
	    }
	    data.put("0",header );

            ArrayList<String> values = new ArrayList<>();
	    for(int i= 0; i <= (homeTable.getRowCount()-1); i++){
	        int conta = 1;
	        for(int j = 0; j <= (homeTable.getColumnCount()-1); j++){
	            values.add(homeTable.getValueAt(i, j).toString());
	                data.put(""+conta,values);
	        }
	        conta++;
	    }
	    id = data.keySet();
	    XSSFRow row;
	    int rowID = 0;
	    for(String key: id){
	        row = sheet.createRow(rowID++);
	        int cellID = 0;
	        valueable = data.get(key);
	        for(String o: valueable){
	            cell = row.createCell(cellID++);
	            cell.setCellValue(o.toString());
	        }
	    }
	    try{
	        FileOutputStream fs = new FileOutputStream(new File(System.getProperty("user.home")+System.getProperty("file.separator")+"view"+homeName+guestName+".xlsx"));
	        workbook.write(fs);
	        fs.close();
	    } catch (IOException ex){
	        
	    }
		Utils.save(model);
	}

	@Override
	public void increasePoints(Player p, int value) {
		stat.getStatistic(p).increasePoints(value);
	}

	@Override
	public void decreasePoints(Player p, int value) {
		stat.getStatistic(p).decreasePoints(value);
	}

	@Override
	public void increaseOffRebounds(Player p) {
		stat.getStatistic(p).increaseOffRebounds();
	}

	@Override
	public void decreaseOffRebounds(Player p) {
		stat.getStatistic(p).decreaseOffRebounds();
	}

	@Override
	public void increaseDefRebounds(Player p) {
		stat.getStatistic(p).increaseDefRebounds();
	}

	@Override
	public void decreaseDefRebounds(Player p) {
		stat.getStatistic(p).decreaseDefRebounds();
	}

	@Override
	public void increseAssists(Player p) {
		stat.getStatistic(p).increseAssists();
	}

	@Override
	public void decreaseAssists(Player p) {
		stat.getStatistic(p).decreaseAssists();
	}

	@Override
	public void increaseBlocks(Player p) {
		stat.getStatistic(p).increaseBlocks();
	}

	@Override
	public void decreaseBlocks(Player p) {
		stat.getStatistic(p).decreaseBlocks();
	}

	@Override
	public void incresePersonalFouls(Player p) {
		stat.getStatistic(p).incresePersonalFouls();
	}

	@Override
	public void decreasePeronsalFouls(Player p) {
		stat.getStatistic(p).decreasePeronsalFouls();
	}

	@Override
	public void increaseTurnovers(Player p) {
		stat.getStatistic(p).increaseTurnovers();
	}

	@Override
	public void decreaseTurnovers(Player p) {
		stat.getStatistic(p).decreaseTurnovers();
	}

	@Override
	public void increaseSteals(Player p) {
		stat.getStatistic(p).increaseSteals();
	}

	@Override
	public void decreaseSteals(Player p) {
		stat.getStatistic(p).decreaseSteals();		
	}

}
