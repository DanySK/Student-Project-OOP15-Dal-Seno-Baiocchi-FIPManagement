package model;

import java.util.Date;

public class Player extends PersonImpl {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8648663467990512362L;
    private final PLAYEROLE role;
    private final double height;
    
    
    public Player(String name, String surname, Date birth, String cf,PLAYEROLE role,double height) {
        super(name, surname, birth, cf);
        this.role = role;
        this.height = height;
    }
    
    public PLAYEROLE getRole(){
        return this.role;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    public static enum PLAYEROLE{
        POINTGUARD,GUARD,SHOOTING_GUARD,POINT_FORWARD,SWINGMAN,SMALLFORWARD,POWERFORWARD,CENTER
    }
  
}
