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
import exceptions.PersonAlreadyAddedException;
import exceptions.TeamAlreadyInThisChampionshipException;

public class Model implements IModel {
    
    private Map<Championship, Map<Team, List<Person>>> dataMap;
    private Set<CompanyImpl> companySet;
    
    public Model(){
        this.dataMap = new HashMap<Championship, Map<Team,List<Person>>>();
        this.companySet = new HashSet<CompanyImpl>();
    }
    
    @Override
    public void addChampionship(Championship champ) throws ChampionshipAlreadyExistException {
        if(!dataMap.containsKey(champ)){
            dataMap.put(champ, new HashMap<Team, List<Person>>());
        } else throw new ChampionshipAlreadyExistException();
      

    }

    @Override
    public void deletChampionship(Championship champ) {
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
    
    public Set<Championship> getChampionship(){
    	return dataMap.keySet();
    }

    @Override
    public void addTeam(Championship champ, Team team) throws TeamAlreadyInThisChampionshipException {
        if(dataMap.containsKey(champ)){
            if(!dataMap.get(champ).containsValue(team)){
                dataMap.get(champ).put(team, new ArrayList<Person>());
            } else throw new TeamAlreadyInThisChampionshipException();
        }  
    }
    
    public Set<Team> getTeam(Championship champ){
    	return dataMap.get(champ).keySet(); 
    }

    @Override
    public void removeTeam(Championship champ,Team team) {
        dataMap.get(champ).remove(team); 
    }



    @Override
    public void addComponent(Championship champ,Team team,Person person) throws PersonAlreadyAddedException {
        if(!dataMap.get(champ).get(team).contains(person.getCF())){
            dataMap.get(champ).get(team).add(person);
        } else throw new PersonAlreadyAddedException();
        
    }

    @Override
    public void removeComponent(Championship champ, Team team, Person person) {
        dataMap.get(champ).get(team).remove(person);
        
    }
    
    
    
    
}
