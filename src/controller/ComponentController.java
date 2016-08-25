package controller;

import java.sql.Date;

import exceptions.PersonAlreadyAddedException;
import model.Model;
import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;
import model.Team;
import observer.TeamComponentObserver;

public class ComponentController implements TeamComponentObserver {

	private Team team;

	public ComponentController(Model model, Team team) {
		this.team = team;
	}

    @Override
    public void addPlayer(String name, String surname, PLAYEROLE role, float height, String cf, Date birth) {
		try {
			team.addPlayer(new Player(name, surname, birth, cf, role, height));
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
        
    }

    @Override
    public void addStaff(String name, String surname, ROLE role, double cf, Date birth) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removePlayer(Player p) {
		team.removePlayer(p);
        
    }

    @Override
    public void removeStaff(Staff s) {
        // TODO Auto-generated method stub
        
    }
	

}
