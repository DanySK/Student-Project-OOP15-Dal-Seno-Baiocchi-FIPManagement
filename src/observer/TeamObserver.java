package observer;

import model.CompanyImpl;

public interface TeamObserver {

    void addTeam(String name,String homeColour,String transferColour,CompanyImpl company);
    
    void removeTeam();
}
