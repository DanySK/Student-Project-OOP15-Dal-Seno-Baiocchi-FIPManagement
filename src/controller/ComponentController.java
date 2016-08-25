package controller;

import model.Model;
import model.PersonImpl;
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
	public void showComponent(String name, String surname, float height, String role, double cf) {

		
	}

	@Override
	public void deleteComponent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponent(String name, String surname, String role, float height, double cf) {
		//model.addComponent(champ, team, person));
	}

}
