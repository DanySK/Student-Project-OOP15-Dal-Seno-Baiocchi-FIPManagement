package tableModel;

import model.Model;
import model.MyTableModel;
import model.Player;
import model.Team;

public class MyComponentModel extends MyTableModel{

	private Team team;

	public MyComponentModel(Team team) {
		super(null);
		this.team = team;
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
			return player.getHeight();
		case 3 : 
			return player.getCF();
		case 4 : 
			return player.getRole();
		case 5 : 
			return player.getBirth();
		default : 
			return null;
	
		}
	}

}
