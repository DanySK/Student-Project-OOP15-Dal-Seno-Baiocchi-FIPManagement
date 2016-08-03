package model;

import java.io.Serializable;
import java.util.List;

public interface Company extends Serializable{

    /**
     * 
     * @return company's name
     */
    String getName();
    
    /**
     * 
     * @return company's VAT
     */
    String getVATNumber();
    
    /**
     * Allows to add a team
     * @param team
     */
    void addTeam(TeamImpl team);
    
    /**
     * Allows to remove a team
     * @param team
     */
    void deleteTeam(TeamImpl team);
    
    /**
     * 
     * @return the list of all team
     */
    List<TeamImpl> getAllTeam();
}
