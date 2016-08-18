package model;

import exceptions.ChampionshipAlreadyExistException;
import exceptions.CompanyAlreadyExistException;

public interface IModel {
    
    
    void addChampionship(ChampionshipImpl champ) throws ChampionshipAlreadyExistException;
    
    void deletChampionship(ChampionshipImpl champ);
    
    void addCompany(CompanyImpl company) throws CompanyAlreadyExistException;
    
    void deleteCompany(CompanyImpl company);

  
}
