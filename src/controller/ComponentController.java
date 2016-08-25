package controller;

import java.sql.Date;

<<<<<<< local
import exceptions.PersonAlreadyAddedException;
=======
>>>>>>> other
import model.Model;
import model.PersonImpl;
import model.Player;
import model.Player.PLAYEROLE;
<<<<<<< local
=======
import model.Staff;
import model.Staff.ROLE;
>>>>>>> other
import model.Team;
import observer.TeamComponentObserver;
import sun.security.acl.PermissionImpl;

public class ComponentController implements TeamComponentObserver {

	private Team team;

	public ComponentController(Model model, Team team) {
		this.team = team;
	}

    @Override
    public void addPlayer(String name, String surname, PLAYEROLE role, float height, double cf, Date birth) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addStaff(String name, String surname, ROLE role, double cf, Date birth) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removePlayer(Player p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeStaff(Staff s) {
        // TODO Auto-generated method stub
        
    }
	

<<<<<<< local
	@Override
	public void showComponent(String name, String surname, double height, PLAYEROLE role, String cf, Date birth) {
		
	}

	@Override
	public void deleteComponent(Player p) {
		team.removePlayer(p);
	}

	@Override
	public void addComponent(String name, String surname, PLAYEROLE role, float height, String cf, Date birth) {
		try {
			team.addPlayer(new Player(name, surname, birth, cf, role, height));
		} catch (PersonAlreadyAddedException e) {
			e.printStackTrace();
		}
	}
=======
	
>>>>>>> other

}
