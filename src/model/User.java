package model;

import java.io.Serializable;

public interface User extends Serializable{

    /**
     * 
     * @return the username
     */
    String getUsername();
    
    /**
     * 
     * @return the password
     */
    String getPassword();
    
    /**
     * 
     * @return the permission the user has (ADMIN,USER)
     */
    AccessPermission getPermission();
    
    /**
     * Allows a user to change account password
     * @param oldPsw the password to change
     * @param newPsw the new password
     */
    void changePassword(String oldPsw, String newPsw);
}
