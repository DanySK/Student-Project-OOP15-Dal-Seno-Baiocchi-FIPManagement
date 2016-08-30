package tableModel;

import java.text.SimpleDateFormat;

import model.MyTableModel;
import model.Player;
import model.Team;

public class MyComponentModel extends MyTableModel{

	private Team team;

	public MyComponentModel(Team team) {
		super(null);
		this.team = team;
		setColumnNames(new String[]{"Name","Surname","Birth","CF","Height","Role"});
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
		        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
			return ft.format(player.getBirth());
		default : 
			return null;
	
		}
	}

}
