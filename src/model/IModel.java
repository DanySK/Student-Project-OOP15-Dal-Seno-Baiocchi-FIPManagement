package model;

import exceptions.ChampionshipAlreadyExistException;
import exceptions.CompanyAlreadyExistException;
import exceptions.TeamAlreadyInThisChampionshipException;

public interface IModel {
    
    
    void addChampionship(ChampionshipImpl champ) throws ChampionshipAlreadyExistException;
    
    void deletChampionship(ChampionshipImpl champ);
    
    void addCompany(CompanyImpl company) throws CompanyAlreadyExistException;
    
    void deleteCompany(CompanyImpl company);
    
    void addTeam(ChampionshipImpl champ, TeamImpl team) throws TeamAlreadyInThisChampionshipException;
    
    void removeTeam(ChampionshipImpl champ,TeamImpl team);
  
}
