package controller;

import model.Championship;
import model.Model;
import model.Team;
import model.TeamImpl;
import observer.TeamObserver;
import view.ObserverInterface;
import exceptions.TeamAlreadyInThisChampionshipException;

public class TeamController implements TeamObserver {

	
	
	private ObserverInterface<TeamObserver> view;
	private Model model;
	private Championship champ;

	public TeamController(final Model model, Championship champ) {
		this.model = model;
		this.champ = champ;
	}
	
    public void setView(ObserverInterface<TeamObserver> lD){
        this.view = lD;
        this.view.attachObserver(this);
    }
	
	@Override
	public void addTeam(String name, String homeColour, String transferColour) {
		try {
			model.addTeam(champ, new TeamImpl(name, transferColour, homeColour));
		} catch (TeamAlreadyInThisChampionshipException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeTeam(Team team) {
		model.removeTeam(champ, team);
	}

}
