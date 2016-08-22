package observer;

public interface LoginObserver{
    
    /**
     * check if the login is correct
     */
    void doLogin(String user,String pwd);
    
}
