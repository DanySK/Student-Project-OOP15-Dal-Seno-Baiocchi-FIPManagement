package observer;

import java.sql.Date;

import model.Player;
import model.Player.PLAYEROLE;

public interface TeamComponentObserver {
	
	
	void addComponent(String name, String surname, PLAYEROLE role, float height, String cf, Date birth);

	void deleteComponent(Player p);

	void showComponent(String name, String surname, double height, PLAYEROLE role, String cf, Date birth);
}
