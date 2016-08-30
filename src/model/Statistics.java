package model;

import java.security.InvalidParameterException;

import exceptions.InvalidStatistic;

public class Statistics {

    
    public int points;
    public int offRebounds;
    public int defRebounds;
    public int assists;
    public int blocks;
    public int personalFouls;
    public int loseBall;
    public int steals;
    
    public Statistics(){
        this.points = 0;
        this.offRebounds = 0;
        this.defRebounds = 0;
        this.assists = 0;
        this.blocks = 0;
        this.personalFouls = 0;
        this.loseBall = 0;
        this.steals = 0;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public int getOffRebounds(){
        return this.offRebounds;
    }
    
    public int getDefRebounds(){
        return this.defRebounds;
    }
    
    public int getAssists(){
        return this.assists;
    }
    
    public int getBlocks(){
        return this.blocks;
    }
    
    public int getPersonalFouls(){
        return this.personalFouls;
    }
    
    public int getLoseBalls(){
        return this.loseBall;
    }
    
    public int getSteals(){
        return this.steals;
    }
    
    public void increasePoints(int value){
        this.points += value;
    }
    
    public void decreasePoints(int value){
       if(this.points < value){
           throw new InvalidParameterException();
       }
        this.points -= value;
    }
    
    public void increaseOffRebounds(){
        this.offRebounds++;
    }
    
    public void decreaseOffRebounds(){
        if(this.offRebounds == 0){
            throw new InvalidStatistic();
        }
        this.offRebounds--;
    }
    
    public void increaseDefRebounds(){
        this.defRebounds++;
    }
    
    public void decreaseDefRebounds(){
        if(this.defRebounds == 0){
            throw new InvalidStatistic();
        }
        this.defRebounds--;
    }
    
    public void increseAssists(){
        this.assists++;
    }
    
    public void decreaseAssists(){
        if(this.assists == 0){
            throw new InvalidStatistic();
        }
        this.assists--;
    }
    
    public void increaseBlocks(){
        this.blocks++;
    }
    
    public void decreaseBlocks(){
        if(this.blocks == 0){
            throw new InvalidStatistic();
        }
        this.blocks--;
    }
    
    public void incresePersonalFouls(){
        this.personalFouls++;
    }
    
    public void decreasePeronsalFouls(){
        if(this.personalFouls == 0){
            throw new InvalidStatistic();
        }
        this.personalFouls--;
    }
    
    public void increaseLoseBall(){
        this.loseBall++;
    }
    
    public void decreaseLoseBall(){
        if(this.loseBall == 0){
            throw new InvalidStatistic();
        }
        this.loseBall--;
    }
    
    public void increaseSteals(){
        this.steals++;
    }
    
    public void decreaseSteals(){
        if(this.steals == 0){
            throw new InvalidStatistic();
        }
        this.steals--;
    }
}
