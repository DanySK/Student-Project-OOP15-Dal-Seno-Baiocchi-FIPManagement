package controller;

import javax.swing.JTable;

import model.IModel;
import model.Player;
import model.StatisticModel;
import observer.MatchViewObserver;

public class MatchViewController implements MatchViewObserver {

	private StatisticModel stat;
	private IModel model;

	public MatchViewController(IModel model, StatisticModel stat) {
		this.model = model;
		this.stat = stat;
		
	}
	
	@Override
	public void saveMatch(JTable homeTable, JTable guestTable,String homeName,String guestName) {
	   /* XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet();
	    
	    TreeMap<String, Object[]> data = new TreeMap<>();
	    data.put("0", new String[]{ homeTable.getColumnName(0), homeTable.getColumnName(1),homeTable.getColumnName(2),
	            homeTable.getColumnName(3),homeTable.getColumnName(4),homeTable.getColumnName(5),
	            homeTable.getColumnName(6),homeTable.getColumnName(7),homeTable.getColumnName(8)});
	    for(int i= 0; i <= (homeTable.getRowCount()-1); i++){
	        for(int j = 0; j <= (homeTable.getColumnCount()-1); j++){
	            int row = homeTable.getRowCount();
	            String name = homeTable.getValueAt(i, j).toString();
	            data.put(""+i, new String[]{homeTable.getValueAt(i, j).toString()});
	        }
	    }
	    /* Lui mi cicla le celle al contrario però vede solo le ultime due
	     * La parte sopra dovrebbe andare tutta bene, è qui che sbagliamo qualcosa
	     */
	   /* Set<String> id = data.keySet();
	    XSSFRow row;
	    int rowID = 0;
	    for(String key: id){
	        row = sheet.createRow(rowID++);
	        
	        int cellID = 0;
	        Object[] values = data.get(key);
	        for(Object o: values){
	            XSSFCell cell = row.createCell(cellID++);
	            cell.setCellValue(o.toString());
	        }
	    }
	    try{
	        FileOutputStream fs = new FileOutputStream(new File(System.getProperty("user.home")+System.getProperty("file.separator")+"view"+homeName+guestName+".xlsx"));
	        workbook.write(fs);
	        fs.close();
	    } catch (IOException ex){
	        
	    }*/
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
