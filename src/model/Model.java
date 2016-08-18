package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import exceptions.ChampionshipAlreadyExistException;
import exceptions.CompanyAlreadyExistException;

public class Model implements IModel {

    private Set<ChampionshipImpl> champSet;
    private Set<CompanyImpl> companySet;
    
    public Model(){
        this.champSet = new HashSet<ChampionshipImpl>();
        this.companySet = new HashSet<CompanyImpl>();
    }
    
    @Override
    public void addChampionship(ChampionshipImpl champ) throws ChampionshipAlreadyExistException {
        Iterator<ChampionshipImpl> it = this.champSet.iterator();
        ChampionshipImpl currentChamp;
        while (it.hasNext()) {
            currentChamp = it.next();
          if(currentChamp.getDivision().equals(champ.getDivision())){
            throw new ChampionshipAlreadyExistException();
          }
        }
        this.champSet.add(champ);

    }

    @Override
    public void deletChampionship(ChampionshipImpl champ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addCompany(CompanyImpl company) throws CompanyAlreadyExistException {
        Iterator<CompanyImpl> it = this.companySet.iterator();
        CompanyImpl currentCompany;
        while (it.hasNext()) {
            currentCompany  = it.next();
            if(currentCompany.getName().equals(company.getName())){
                throw new CompanyAlreadyExistException();
            }
        }
        this.companySet.add(company);
    }

    @Override
    public void deleteCompany(CompanyImpl company) {
        // TODO Auto-generated method stub

    }
}
