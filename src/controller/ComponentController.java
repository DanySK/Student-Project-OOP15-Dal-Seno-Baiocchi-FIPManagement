package controller;

import java.sql.Date;

import exceptions.PersonAlreadyAddedException;
import model.Model;
import model.PersonImpl;
import model.Player;
import model.Player.PLAYEROLE;
import model.Team;
import observer.TeamComponentObserver;
import sun.security.acl.PermissionImpl;

public class ComponentController implements TeamComponentObserver {

	private Team team;

	public ComponentController(Model model, Team team) {
		this.team = team;
	}
	

	@Override
	public void showComponent(String name, String surname, double height, PLAYEROLE role, String cf, Date birth) {
		
	}

	@Override
	public void deleteComponent(Player p) {
		team.removePlayer(p);
	}

	@Override
	public void addComponent(String name, String surname, PLAYEROLE role, float height, String cf, Date birth) {
		try {
			team.addPlayer(new Player(name, surname, birth, cf, role, height));
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
	}

}
