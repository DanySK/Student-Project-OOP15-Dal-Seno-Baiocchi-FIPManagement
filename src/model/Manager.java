package model;

public class Manager extends PersonImpl {

    /**
     * 
     */
    private static final long serialVersionUID = 6700902789826811231L;
    private String role;


    public Manager(String name, String surname, String birth, String cf,String role){
        super(name, surname, birth, cf);
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
