package controller;

import java.util.Date;

import exceptions.PersonAlreadyAddedException;
import model.IModel;
import model.Model;
import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;
import model.Team;
import observer.TeamComponentObserver;

public class ComponentController implements TeamComponentObserver {

	private Team team;
	private IModel model;

	public ComponentController(Model model, Team team ) {
		this.team = team;
		this.model = model;
	}

    @Override
    public void addPlayer(String name, String surname, PLAYEROLE role, double height, String cf, Date birth) {
		try {
			team.addPlayer(new Player(name, surname, birth, cf, role, height));
			Utils.save(model);
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
        
    }

    @Override
    public void addStaff(String name, String surname, ROLE role, String cf, Date birth) {
    	try {
			team.addStaff(new Staff(name, surname, birth, cf, role));
			Utils.save(model);
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
                
    }

    @Override
    public void removePlayer(Player p) {
		team.removePlayer(p);
		Utils.save(model);
    }

    @Override
    public void removeStaff(Staff s) {
    	team.removeStaff(s);
    	Utils.save(model);
    }
}
