package observer;

import model.Division;
import model.Zone;

public interface ChampionshipObserver {

    void addChampionship(Division d, Zone zone);
    
    void deleteChampionship();
}
