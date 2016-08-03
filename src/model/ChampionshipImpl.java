package model;

import java.util.List;

public class ChampionshipImpl implements Championship {

    /**
     * 
     */
    private static final long serialVersionUID = -2985081041574393034L;
    private final Division division;
    private final Zone zone;
    private List<TeamImpl> teamList;

    public ChampionshipImpl(Division division,Zone zone) {
        this.division = division;
        this.zone = zone;
    }
    @Override
    public Division getDivision() {
        return this.division;
    }
    @Override
    public Zone getZone() {
        return this.zone;
    }
  
    @Override
    public void addTeam(TeamImpl team) {
        if(!teamList.contains(team)){
            teamList.add(team);
        } else throw new IllegalArgumentException(); //Team's already insert into that champhionship

    }
    @Override
    public void deleteTeam(TeamImpl team) {
        if(teamList.contains(team)){
            teamList.remove(team);
        } else throw new IllegalArgumentException();
        
    }

}
