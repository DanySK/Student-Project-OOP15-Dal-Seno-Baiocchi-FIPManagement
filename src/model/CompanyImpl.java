package model;

import java.util.List;

public class CompanyImpl implements Company {

    /**
     * 
     */
    private static final long serialVersionUID = 6225643899682723273L;
    private final String name;
    private final String VAT;
    private List<TeamImpl> teamList;
    
    public CompanyImpl(String name,String vat){
       this.name = name;
       this.VAT = vat;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getVATNumber() {
        return this.VAT;
    }

    @Override
    public void addTeam(TeamImpl team) {
        if(!teamList.contains(team.getName())){
            teamList.add(team);
        } else throw new IllegalArgumentException();
    }

    @Override
    public void deleteTeam(TeamImpl team) {
        if(teamList.contains(team)){
            teamList.remove(team);
        } else throw new IllegalArgumentException();
        
    }

    @Override
    public List<TeamImpl> getAllTeam() {
        return teamList;
    }

}
