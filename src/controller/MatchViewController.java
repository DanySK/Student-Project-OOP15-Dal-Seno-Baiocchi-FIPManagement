package controller;

import model.IModel;
import model.Player;
import model.StatisticModel;
import model.Statistics;
import observer.MatchViewObserver;

public class MatchViewController implements MatchViewObserver {

	private StatisticModel stat;
	private IModel model;

	public MatchViewController(IModel model, StatisticModel stat) {
		this.model = model;
		this.stat = stat;
		
	}
	
	@Override
	public void saveMatch() {
		Utils.save(model);
	}

	@Override
	public void increasePoints(Player p, int value) {
		stat.getStatistic(p).increasePoints(value);
	}

	@Override
	public void decreasePoints(Player p, int value) {
		stat.getStatistic(p).decreasePoints(value);
	}

	@Override
	public void increaseOffRebounds(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseOffRebounds(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseDefRebounds(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseDefRebounds(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increseAssists(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseAssists(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseBlocks(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseBlocks(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incresePersonalFouls(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreasePeronsalFouls(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseLoseBall(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseLoseBall(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseSteals(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseSteals(Player p) {
		// TODO Auto-generated method stub
		
	}

}
