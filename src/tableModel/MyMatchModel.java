package tableModel;

import java.text.SimpleDateFormat;

import model.IModel;
import model.MyTableModel;
import model.Player;
import model.Team;
import tableModel.MyComponentModel.CompononentType;

public class MyMatchModel extends MyTableModel{

	private Team team;

	public MyMatchModel(IModel model, Team team) {
		super(model);
		setColumnNames(new String[]{"Name","Surname","P","OffR","DefR","Ass","Blo","Faul","BL","Ste"});
	}

	@Override
	public int getRowCount() {
		return team.getPlayers().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			Player player = team.getPlayers().get(rowIndex);
			switch (columnIndex) {
			case 0:
				return	player.getName();
			case 1 : 
				return player.getSurname();
			case 2 : 
				return player.getStatistics();
			case 3 : 
				return player.getStatistics();
			case 4 : 
				return player.getStatistics();
			case 5 : 
				return player.getStatistics();
			case 6 : 
				return player.getStatistics();
			case 7 :
				return player.getStatistics();
			case 8 :
				return player.getStatistics();
			case 9 : 
				return player.getStatistics();
			default : 
				return null;

		}
	}
}
