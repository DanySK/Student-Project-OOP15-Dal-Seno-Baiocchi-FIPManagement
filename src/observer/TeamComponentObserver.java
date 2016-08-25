package observer;


import java.util.Date;

import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;

public interface TeamComponentObserver {

	void removePlayer(Player p);
	void removeStaff(Staff s);
	void addPlayer(String name, String surname, PLAYEROLE role, double height, String cf, Date birth);
	void addStaff(String name, String surname, ROLE role, String cf, Date birth);

}
