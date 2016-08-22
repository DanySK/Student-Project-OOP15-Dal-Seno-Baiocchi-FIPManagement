package controller;

import model.Championship;
import model.ChampionshipImpl;
import model.Division;
import model.Model;
import model.TeamImpl;
import model.Zone;
import observer.ChampionshipObserver;

public class ChampionshipController implements ChampionshipObserver {
	
	private Model model;

	public ChampionshipController(final Model model) {
		this.model = model;
	}

	@Override
	public void addChampionship(Division d, Zone zone) {
		model.getChampionship().add(new ChampionshipImpl(d, zone));
	}

	@Override
	public void deleteChampionship() {
		
	}

}
