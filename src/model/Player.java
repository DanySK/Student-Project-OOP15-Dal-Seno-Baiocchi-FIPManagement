package model;

public class Player extends PersonImpl {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8648663467990512362L;
    private final String role;
    private final int height;
    
    
    public Player(String name, String surname, String birth, String cf,String role,int height) {
        super(name, surname, birth, cf);
        this.role = role;
        this.height = height;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public int getHeight(){
        return this.height;
    }
  
}
