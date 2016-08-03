package model;

import java.io.Serializable;
import java.util.List;

public interface Team extends Serializable{

    /**
     * 
     * @return the Team's name
     */
    public String getName();
    
    /**
     * 
     * @return the transfer jersey's colour
     */
    public String getTransferJerseyColour();
    
    /**
     * 
     * @return the home jersey's colour
     */
    public String getHomeJerseyColour();
    
    /**
     * Allows to add a player
     * @param player: the player to add
     */
    void addPlayer(Player player);
    
    /**
     * Allows to delete a player
     * @param player: to delete
     */
    void deletePlayer(Player player);
    
    /**
     * 
     * @return the list of all players
     */
    List<Player> getTeamPlayers();
    
    /**
     * Allows to add a coach
     * @param coach: the coach to add
     */
    void addCoach(Coach coach);
    
    /**
     * Allows to delete a coach
     * @param coach: the coach to delete
     */
    void deleteCoach(Coach coach);
    
    /**
     * 
     * @return the list of all coaches
     */
    List<Coach> getCoaches();
    
    /**
     * Allows to add staff member to the team
     * @param staff: the member of the staff to add
     */
    void addStaff(Staff staff);
    
    /**
     * Allows to remove staff member
     * @param staff: the member of the staff to remove
     */
    void deleteStaff(Staff staff);
    
    /**
     * 
     * @return the list of all the staff member
     */
    List<Staff> getStaffs();
    
    /**
     * Allows to add a manager
     * @param manager:the manager to add
     */
    void addManager(Manager manager);
    
    /**
     * Allows to remove a manager
     * @param manager:the manager to remove
     */
    void deleteManager(Manager manager);
    
    /**
     * 
     * @return the list of all the managers
     */
    List<Manager> getManagers();
    
}
