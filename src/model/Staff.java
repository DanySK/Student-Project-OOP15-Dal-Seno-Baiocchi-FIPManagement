package model;

public class Staff extends PersonImpl {
    /**
     * 
     */
    private static final long serialVersionUID = 4869245935781128086L;
    private ROLE role;

    public Staff(String name, String surname, String birth, String cf,ROLE role) {
        super(name, surname, birth, cf);
        this.role = role;
    }
    
    public ROLE getRole(){
        return this.role;
    }
    
    public static enum ROLE{
        HEADCOACH,ASSISTANT_COACH,SCOUT,SPORTS_DIRECTOR,PRESIDENT,VICE_PRESIDENT,DOCTOR,MASSEUR,PHYSIOTERAPIST
    }
}
