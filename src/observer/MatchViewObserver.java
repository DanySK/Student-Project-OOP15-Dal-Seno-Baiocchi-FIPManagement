package observer;

import model.Player;

public interface MatchViewObserver {

	public void saveMatch();

    public void increasePoints(Player p, int value);
    
    public void decreasePoints(Player p,int value);
    
    public void increaseOffRebounds(Player p);
    
    public void decreaseOffRebounds(Player p);
    
    public void increaseDefRebounds(Player p);
    
    public void decreaseDefRebounds(Player p);
    
    public void increseAssists(Player p);
    
    public void decreaseAssists(Player p);
    
    public void increaseBlocks(Player p);
    
    public void decreaseBlocks(Player p);
    
    public void incresePersonalFouls(Player p);
    
    public void decreasePeronsalFouls(Player p);
    
    public void increaseLoseBall(Player p);
    
    public void decreaseLoseBall(Player p);
    
    public void increaseSteals(Player p);
    
    public void decreaseSteals(Player p);	
}
