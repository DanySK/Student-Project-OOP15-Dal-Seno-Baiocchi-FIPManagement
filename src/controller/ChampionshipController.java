package controller;

import exceptions.ChampionshipAlreadyExistException;
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
	public void addChampionship(Division d, Zone zone) throws ChampionshipAlreadyExistException {
	    model.addChampionship(new ChampionshipImpl(d, zone));
	}

	@Override
	public void deleteChampionship(ChampionshipImpl champ) {
		model.deletChampionship(champ);
	}

}
