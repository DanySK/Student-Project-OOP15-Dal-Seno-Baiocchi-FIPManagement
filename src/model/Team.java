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
     * 
     * @return the company name
     */
    public String getCompany();
    /**
     * 
     * @return vat number of the compnay
     */
    public String getVatNumber();
    
    public void addPlayer(Player p);
    
    public void addStaff(Staff s);
    
    public void removePlayer(Player p);
    
    public void removeStaff(Staff s);
        
    List<Player> getPlayers();
    
    List<Staff> getStaff();
       
    
}
