package observer;
import model.Team;

public interface TeamObserver {

    void addTeam(String name,String homeColour,String transferColour, String company, String vat);
    
    void removeTeam(Team team);
}
