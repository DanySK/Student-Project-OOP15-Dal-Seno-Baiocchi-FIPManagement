package observer;
import model.Team;

public interface TeamObserver {

    void addTeam(String name,String homeColour,String transferColour);
    
    void removeTeam(Team team);
}
