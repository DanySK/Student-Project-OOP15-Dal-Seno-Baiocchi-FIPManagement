package model;

import exceptions.ChampionshipAlreadyExistException;
import exceptions.CompanyAlreadyExistException;
import exceptions.PersonAlreadyAddedException;
import exceptions.TeamAlreadyInThisChampionshipException;

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
     * @param company
     * @throws CompanyAlreadyExistException
     */
    void addCompany(CompanyImpl company) throws CompanyAlreadyExistException;
    /**
     * 
     * @param company
     */
    void deleteCompany(CompanyImpl company);
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
    /**
     * 
     * @param champ: the reference championship
     * @param team: the reference team
     * @param person: the person to add
     * @throws PersonAlreadyAddedException if there's already that person for that team
     */
    void addComponent(Championship champ,Team team,Person person) throws PersonAlreadyAddedException;
    /**
     * 
     * @param champ: the reference championship
     * @param team: the reference team
     * @param person: the person to delete 
     */
    void removeComponent(Championship champ,Team team,Person person);
  
}
