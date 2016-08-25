package observer;

import java.sql.Date;

import model.Player;
import model.Player.PLAYEROLE;
<<<<<<< local
=======
import model.Staff.ROLE;
import model.Staff;
>>>>>>> other

public interface TeamComponentObserver {
<<<<<<< local
=======

	void addPlayer(String name, String surname,PLAYEROLE role, float height, double cf, Date birth);
>>>>>>> other
	
<<<<<<< local
=======
	void addStaff(String name, String surname, ROLE role, double cf,Date birth);
>>>>>>> other
	
<<<<<<< local
	void addComponent(String name, String surname, PLAYEROLE role, float height, String cf, Date birth);

	void deleteComponent(Player p);

	void showComponent(String name, String surname, double height, PLAYEROLE role, String cf, Date birth);
=======
	void removePlayer(Player p);
	
	void removeStaff(Staff s);
>>>>>>> other
}
