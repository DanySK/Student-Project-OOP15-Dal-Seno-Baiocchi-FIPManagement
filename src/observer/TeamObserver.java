package observer;
import model.Team;

/**
 * defines the way to add or remove a team from a championship
 * @author francesco
 *
 */

public interface TeamObserver {
	/**
	 * adding a team to a championship 
	 * @param name
	 * @param homeColour
	 * @param transferColour
	 * @param company
	 * @param vat
	 */
    void addTeam(String name,String homeColour,String transferColour, String company, String vat);
    /**
     * removing a team from a championship
     * @param team
     */
    void removeTeam(Team team);
}
