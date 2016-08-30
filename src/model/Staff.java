package model;

import java.util.Date;

public class Staff extends PersonImpl {
    /**
     * 
     */
    private static final long serialVersionUID = 4869245935781128086L;
    private ROLE role;

    public Staff(String name, String surname, Date birth, String cf,ROLE role) {
        super(name, surname, birth, cf);
        this.role = role;
    }
    
    public ROLE getRole(){
        return this.role;
    }
    
    public void setRole(ROLE r){
        this.role = r;
    }
    
    public static enum ROLE{
        HEADCOACH,ASSISTANT_COACH,SCOUT,SPORTS_DIRECTOR,PRESIDENT,VICE_PRESIDENT,DOCTOR,MASSEUR,PHYSIOTERAPIST
    }
}
