package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamImpl implements Team {
    /**
     * 
     */
    private static final long serialVersionUID = 7069756260826891180L;
    private final String name;
    private final String transferColour;
    private final String homeColour;
    private  String company;
    private  String vatNumber;
    private Set<Player> players;
    private Set<Staff> staff;
    
    public TeamImpl(String name, String transferColour,String homeColour){
        this.name = name;
        this.transferColour = transferColour;
        this.homeColour = homeColour;
       // this.company = company;
       // this.vatNumber = vatNumber;
        players = new HashSet<Player>();
        staff = new HashSet<Staff>();
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
    public String getCompany() {
        return this.company;
    }

    @Override
    public String getVatNumber() {
        return this.vatNumber;
    }

    @Override
    public void addPlayer(Player p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addStaff(Staff s) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removePlayer(Player p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeStaff(Staff s) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<Player>(players);
    }

    @Override
    public List<Staff> getStaff() {
        return new ArrayList<Staff>(staff);
    }
}
