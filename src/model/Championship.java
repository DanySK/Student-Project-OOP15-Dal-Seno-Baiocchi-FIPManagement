package model;

import java.io.Serializable;

public interface Championship extends Serializable {

    /**
     * 
     * @return the division of the Championship
     */
    Division getDivision();
    
    /**
     * 
     * @return the zone of a Championship
     */
    Zone getZone();
    
    /**
     * Allows to add a team to a certain Championship
     * @param team the team to add
     * @param champ: the championship division
     */
    void addTeam(TeamImpl team);
    
    /**
     * Allows to delete a team from a certain championship
     * @param team the team to remove
     * @param champ: the champhionship division
     */
    void deleteTeam(TeamImpl team);
}
