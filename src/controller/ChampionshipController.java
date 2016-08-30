package controller;

import exceptions.ChampionshipAlreadyExistException;
import model.Championship;
import model.ChampionshipImpl;
import model.Division;
import model.IModel;
import model.Model;
import model.TeamImpl;
import model.Zone;
import observer.ChampionshipObserver;

public class ChampionshipController implements ChampionshipObserver {
	
	private IModel model;

	public ChampionshipController(final IModel model) {
		this.model = model;
	}

	@Override
	public void addChampionship(Division d, Zone zone) throws ChampionshipAlreadyExistException {
	    model.addChampionship(new ChampionshipImpl(d, zone));
	    Utils.save(model);
	}

	@Override
	public void deleteChampionship(Championship champ) {
		model.deletChampionship(champ);
		Utils.save(model);
	}

}
