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

    void addTeam(TeamImpl team);

    void deleteTeam(TeamImpl team);
    
}
