package model;

import java.util.List;

public class TeamImpl implements Team {

    /**
     * 
     */
    private static final long serialVersionUID = 7069756260826891180L;
    private final String name;
    private final String transferColour;
    private final String homeColour;
    private List<Player> playerList;
    
    public TeamImpl(String name, String transferColour,String homeColour){
        this.name = name;
        this.transferColour = transferColour;
        this.homeColour = homeColour;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTransferJerseyColour() {
        return this.transferColour;
    }

    @Override
    public String getHomeJerseyColour() {
        return this.homeColour;
    }

    @Override
    public void addPlayer(Player player) {
        if(!playerList.contains(player.getCF())){
            playerList.add(player);
        } else throw new IllegalArgumentException();
        
    }

    @Override
    public List<Player> getTeamPlayer() {
            return playerList;
    }

    @Override
    public void deletePlayer(Player player) {
        if(playerList.contains(player.getCF())){
            playerList.remove(player);
        } else throw new IllegalArgumentException();
        
    }

   

}
