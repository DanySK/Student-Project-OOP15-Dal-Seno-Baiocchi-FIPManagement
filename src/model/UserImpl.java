package model;

public class UserImpl implements User {

    /**
     * 
     */
    private static final long serialVersionUID = -3907254049439158202L;
    private final String userName;
    private String password;
    private final AccessPermission accessPermission;
    
    
    public  UserImpl(String name,String password,AccessPermission access) {
        this.userName = name;
        this.password = password;
        this.accessPermission = access;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public AccessPermission getPermission() {
        return this.accessPermission;
    }

    @Override
    public void changePassword(String oldPsw, String newPsw) {
        if(oldPsw.equals(password)){
            this.password = newPsw;
        } else throw new IllegalArgumentException();
    }

}
