package observer;

import java.sql.Date;

import model.Player;
import model.Player.PLAYEROLE;
import model.Staff.ROLE;
import model.Staff;

public interface TeamComponentObserver {

	void addPlayer(String name, String surname,PLAYEROLE role, float height, double cf, Date birth);
	
	void addStaff(String name, String surname, ROLE role, double cf,Date birth);
	
	void removePlayer(Player p);
	
	void removeStaff(Staff s);
}
