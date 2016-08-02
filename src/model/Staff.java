package model;

public class Staff extends PersonImpl {


    /**
     * 
     */
    private static final long serialVersionUID = 4869245935781128086L;
    private String role;

    public Staff(String name, String surname, String birth, String cf,String role) {
        super(name, surname, birth, cf);
        this.role = role;
    }
    
    public String getRole(){
        return this.role;
    }
}
