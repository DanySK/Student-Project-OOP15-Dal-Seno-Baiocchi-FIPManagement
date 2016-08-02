package model;

import java.io.Serializable;

public interface Person extends Serializable {
    /**
     * 
     * @return the name
     */
    String getName();
    
    /**
     * 
     * @return the surname
     */
    String getSurname();
    
    /**
     * 
     * @return the birth
     */
    String getBirth();
    
    /**
     * 
     * @return the cf
     */
    String getCF();
}
