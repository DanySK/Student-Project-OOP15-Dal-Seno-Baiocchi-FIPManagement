package model;

import java.io.Serializable;
import java.util.Date;

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
    Date getBirth();
    
    /**
     * 
     * @return the cf
     */
    String getCF();
    
    void setName(String name);
    
    void setSurname(String surname);
    
    void setBirth(Date birth);
    
    void setCF(String cf);
}
