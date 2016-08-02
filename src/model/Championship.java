package model;

import java.io.Serializable;

public interface Championship extends Serializable {

    /**
     * 
     * @return the division of the Championship
     */
    Division getDivision();
    
    Zone getZone();
    
    void addTeam(TeamImpl team);
}
