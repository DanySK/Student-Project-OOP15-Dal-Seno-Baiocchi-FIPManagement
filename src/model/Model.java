package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.ChampionshipAlreadyExistException;
import exceptions.CompanyAlreadyExistException;
import exceptions.TeamAlreadyInThisChampionshipException;

public class Model implements IModel {
    
    private Map<ChampionshipImpl, Map<TeamImpl, List<PersonImpl>>> dataMap;
    private Set<CompanyImpl> companySet;
    
    public Model(){
        this.dataMap = new HashMap<ChampionshipImpl, Map<TeamImpl,List<PersonImpl>>>();
        this.companySet = new HashSet<CompanyImpl>();
    }
    
    @Override
    public void addChampionship(ChampionshipImpl champ) throws ChampionshipAlreadyExistException {
        if(!dataMap.containsKey(champ)){
            dataMap.put(champ, new HashMap<TeamImpl, List<PersonImpl>>());
        } else throw new ChampionshipAlreadyExistException();
      

    }

    @Override
    public void deletChampionship(ChampionshipImpl champ) {
        if(dataMap.containsKey(champ)){
            dataMap.remove(champ);
        } else throw new IllegalArgumentException();

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
    
    public Set<ChampionshipImpl> getChampionship(){
    	return dataMap.keySet();
    }

    @Override
    public void addTeam(ChampionshipImpl champ, TeamImpl team) throws TeamAlreadyInThisChampionshipException {
        if(dataMap.containsKey(champ)){
            if(!dataMap.get(champ).containsValue(team)){
                dataMap.get(champ).put(team, new ArrayList<PersonImpl>());
            } else throw new TeamAlreadyInThisChampionshipException();
        }  
    }

    @Override
    public void removeTeam(ChampionshipImpl champ,TeamImpl team) {
        dataMap.get(champ).remove(team); 
    }
    
    
}
