package controller;

import java.util.Date;

import exceptions.PersonAlreadyAddedException;
import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;
import model.Team;
import observer.TeamComponentObserver;

public class ComponentController implements TeamComponentObserver {

	private Team team;

	public ComponentController(Team team) {
		this.team = team;
	}

    @Override
    public void addPlayer(String name, String surname, PLAYEROLE role, double height, String cf, Date birth) {
		try {
			team.addPlayer(new Player(name, surname, birth, cf, role, height));
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
        
    }

    @Override
    public void addStaff(String name, String surname, ROLE role, String cf, Date birth) {
    	try {
			team.addStaff(new Staff(name, surname, birth, cf, role));
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
                
    }

    @Override
    public void removePlayer(Player p) {
		team.removePlayer(p);   
    }

    @Override
    public void removeStaff(Staff s) {
    	team.removeStaff(s);
    }
}
