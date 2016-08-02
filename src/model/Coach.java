package model;

public class Coach extends PersonImpl {

    /**
     * 
     */
    private static final long serialVersionUID = 6916238256459324334L;
    private String role;

    public Coach(String name, String surname, String birth, String cf,String role) {
        super(name, surname, birth, cf);
        this.role = role;
       }

       public String getRole(){
           return this.role;
       }
}
