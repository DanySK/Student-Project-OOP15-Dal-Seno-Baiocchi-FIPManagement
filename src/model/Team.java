package model;

import java.io.Serializable;
import java.util.List;

public interface Team extends Serializable{

    public String getName();
    
    public String getTransferJerseyColour();
    
    public String getHomeJerseyColour();
    
    void addPlayer(Player player);
    
    List<Player> getTeamPlayer();
    
    void deletePlayer(Player player);
    
}
