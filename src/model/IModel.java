package model;

import exceptions.ChampionshipAlreadyExistException;
import exceptions.TeamAlreadyInThisChampionshipException;
import java.util.List;

public interface IModel {
    
    /**
     * 
     * @param champ: the championship to add
     * @throws ChampionshipAlreadyExistException if there's already that championship
     */
    void addChampionship(Championship champ) throws ChampionshipAlreadyExistException;
    /**
     * 
     * @param champ: the championship to delete
     */
    void deletChampionship(Championship champ);
    /**
     * 
     * @param champ: the reference championship 
     * @param team: the team to add
     * @throws TeamAlreadyInThisChampionshipException if there's already that team for that championship
     */
    void addTeam(Championship champ, Team team) throws TeamAlreadyInThisChampionshipException;
    /**
     * 
     * @param champ: the reference championship
     * @param team: the team to delete
     */
    void removeTeam(Championship champ,Team team);

  
    List<Team> getTeam(Championship champ);
    
    List<Championship> getChampionship(); 
    
}
