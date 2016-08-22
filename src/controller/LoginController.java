package controller;

import javax.swing.JDialog;
import javax.swing.JFrame;

import observer.LoginObserver;
import sun.security.util.Password;
import view.ChampionshipView;
import view.LoginDialog;
import view.MainView.LoginType;
import view.MatchView;
import view.ObserverInterface;

public class LoginController implements LoginObserver {

    private ObserverInterface<LoginObserver> view;
    private LoginType type;
    private static String ERROR_MESSAGE = "Errore login";
    public LoginController(LoginType type) {
    	this.type = type;
    }
    
    public void setView(ObserverInterface<LoginObserver> lD){
        this.view = lD;
        this.view.attachObserver(this);
    }
    
    @Override
    public boolean doLogin(String user, String pwd) {
        if(type == LoginType.adm){
	    	if(user.equals("adm") && pwd.equals("adm")){
	    		new ChampionshipView().setVisible(true);
	            return true;
	        } else {
	        	
	        	return false;
	        }
    	}else if(type == LoginType.user){
    		if(user.equals("user") && pwd.equals("user")){
	            new MatchView().setVisible(true);;
	            return true;
	        } else {
	        
	        	return false;
	        }
    	}
		return false;
    }
}
