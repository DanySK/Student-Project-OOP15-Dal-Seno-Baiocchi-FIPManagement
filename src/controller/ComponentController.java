package controller;

import java.sql.Date;

import model.Model;
import model.PersonImpl;
import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;
import model.Team;
import observer.TeamComponentObserver;
import sun.security.acl.PermissionImpl;

public class ComponentController implements TeamComponentObserver {

	private Team team;
	private Model model;

	public ComponentController(Model model, Team team) {
		this.model = model;
		this.team = team;
	}

    @Override
    public void addPlayer(String name, String surname, PLAYEROLE role, float height, double cf, Date birth) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addStaff(String name, String surname, ROLE role, double cf, Date birth) {
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
	

	

}
