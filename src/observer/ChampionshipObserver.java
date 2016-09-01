package observer;

import model.Championship;
import model.Division;
import model.Zone;
import exceptions.ChampionshipAlreadyExistException;

public interface ChampionshipObserver {

    void addChampionship(Division d, Zone zone) throws ChampionshipAlreadyExistException;
    
    void deleteChampionship(Championship championship);
}
