package controller;

import model.IModel;
import view.LoginDialog;
import view.LoginDialogInterface;
import view.MainView;
import view.LoginDialog.LoginObserver;

public class LoginController implements LoginObserver {

    
    private LoginDialogInterface view;
    
    
    
    public LoginController() {
    }
    
    public void setView(LoginDialogInterface v){
        this.view = v;
        this.view.attachObserver(this);
    }
    @Override
    public void doLogin(String user, String pwd) {
        if(user.equals("adm") && pwd.equals("adm")){
            System.out.println("LOGIN EFFETTUATO");
        } else {
            System.out.println("ERRORE");
        }
    }

}
