package observer;


import java.util.Date;

import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;
/**
 * 
 * class that defines the creation of a team roster and is staff 
 * @author francesco
 *
 */
public interface TeamComponentObserver {

	/**
	 * Adding a player to a team
	 * @param name
	 * @param surname
	 * @param role
	 * @param height
	 * @param cf
	 * @param birth
	 */
	void addPlayer(String name, String surname, PLAYEROLE role, double height, String cf, Date birth);
	
	/**
	 * adding a member of the staff to the team
	 * @param name
	 * @param surname
	 * @param role
	 * @param cf
	 * @param birth
	 */
	void addStaff(String name, String surname, ROLE role, String cf, Date birth);

	/**
	 * Removing a player from the team
	 * @param p
	 */
	void removePlayer(Player p);
	
	/**
	 * Removing a person from the staff of the team
	 * @param s
	 */
	void removeStaff(Staff s);
	

}
