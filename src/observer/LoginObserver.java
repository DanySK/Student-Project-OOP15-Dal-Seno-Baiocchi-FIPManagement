package observer;

import sun.security.util.Password;

public interface LoginObserver{
    
    /**
     * check if the login is correct
     */
    boolean doLogin(String user, String pwd);
    
    
    
}
