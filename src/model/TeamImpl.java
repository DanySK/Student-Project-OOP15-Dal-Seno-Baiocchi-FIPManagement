package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.PersonAlreadyAddedException;
/**
 * Model a team
 * @author lucadalseno
 *
 */
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
    
    public TeamImpl(String name, String transferColour,String homeColour, String company, String vat){
        this.name = name;
        this.transferColour = transferColour;
        this.homeColour = homeColour;
        this.company = company;
        this.vatNumber = vat;
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
    public void addPlayer(Player p) throws PersonAlreadyAddedException {
    	if(!players.contains(p)){
    		players.add(p);
    	} else {
    		throw new PersonAlreadyAddedException();
    	}
    }

    @Override
    public void addStaff(Staff s) throws PersonAlreadyAddedException {
    	if(!staff.contains(s)){
    		staff.add(s);
    	} else {
    		throw new PersonAlreadyAddedException();
    	}
    }

    @Override
    public void removePlayer(Player p) {
        players.remove(p);
    }

    @Override
    public void removeStaff(Staff s) {
        staff.remove(s);
    }

    @Override
    public List<Player> getPlayers() {
    	List<Player> order = new ArrayList<Player>(players);
    	order.sort((a,b)->{
    		return  a.toString().compareTo(b.toString());   
    	});
        return order;
    }

    @Override
    public List<Staff> getStaff() {
        return new ArrayList<Staff>(staff);
    }
    
    public String toString(){
    	return this.name;
    }
}