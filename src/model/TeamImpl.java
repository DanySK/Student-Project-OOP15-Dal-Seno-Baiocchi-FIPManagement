package model;

import java.util.List;

public class TeamImpl implements Team {

    /**
     * 
     */
    private static final long serialVersionUID = 7069756260826891180L;
    private final String name;
    private final String transferColour;
    private final String homeColour;
    private List<Player> playerList;
    private List<Coach> coachList;
    private List<Staff> staffList;
    private List<Manager> managerList;
    
    public TeamImpl(String name, String transferColour,String homeColour){
        this.name = name;
        this.transferColour = transferColour;
        this.homeColour = homeColour;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTransferJerseyColour() {
        return this.transferColour;
    }

    @Override
    public String getHomeJerseyColour() {
        return this.homeColour;
    }
    
    @Override
    public void addCoach(Coach coach){
        if(!coachList.contains(coach.getCF())){
            coachList.add(coach);
        } else throw new IllegalArgumentException();
    }

    @Override
    public void deleteCoach(Coach coach) {
        if(coachList.contains(coach.getCF())){
            playerList.remove(coach);
        } else throw new IllegalArgumentException(); 
    }

    @Override
    public List<Coach> getCoaches() {
        return coachList;
    }
    
    @Override
    public void addPlayer(Player player) {
        if(!playerList.contains(player.getCF())){
            playerList.add(player);
        } else throw new IllegalArgumentException();
    }

    @Override
    public void deletePlayer(Player player) {
        if(playerList.contains(player.getCF())){
            playerList.remove(player);
        } else throw new IllegalArgumentException();
    }

    @Override
    public List<Player> getTeamPlayers() {
            return playerList;
    }

    @Override
    public void addStaff(Staff staff) {
        if(!staffList.contains(staff.getCF())){
            staffList.add(staff);
        } else throw new IllegalArgumentException();
    }

    @Override
    public void deleteStaff(Staff staff) {
        if(staffList.contains(staff.getCF())){
            staffList.remove(staff);
        } else throw new IllegalArgumentException();
    }

    @Override
    public List<Staff> getStaffs() {
        return staffList;
    }

    @Override
    public void addManager(Manager manager) {
        if(!managerList.contains(manager.getCF())){
            managerList.add(manager);
        } else throw new IllegalArgumentException();
    }

    @Override
    public void deleteManager(Manager manager) {
        if(managerList.contains(manager.getCF())){
            managerList.remove(manager);
        } else throw new IllegalArgumentException(); 
    }

    @Override
    public List<Manager> getManagers() {
        return managerList;
    }

}
