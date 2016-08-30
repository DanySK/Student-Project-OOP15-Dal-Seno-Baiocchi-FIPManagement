package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Player extends PersonImpl{
    
    /**
     * 
     */
    private static final long serialVersionUID = 8648663467990512362L;
    private PLAYEROLE role;
    private double height;
    private List<Statistics> stat;
    
    
    public Player(String name, String surname, Date birth, String cf,PLAYEROLE role,double height) {
        super(name, surname, birth, cf);
        this.role = role;
        this.height = height;
        this.stat = new ArrayList<Statistics>();
    }
    
    public PLAYEROLE getRole(){
        return this.role;
    }
    
    public void setRole(PLAYEROLE r){
        this.role = r;
    }
    public double getHeight(){
        return this.height;
    }
    
    public List<Statistics> getStatistics(){
        return this.stat;
    }
    
    public void addStat(Statistics s){
        this.stat.add(s);
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public static enum PLAYEROLE{
        POINTGUARD,GUARD,SHOOTING_GUARD,POINT_FORWARD,SWINGMAN,SMALLFORWARD,POWERFORWARD,CENTER
    }
}
