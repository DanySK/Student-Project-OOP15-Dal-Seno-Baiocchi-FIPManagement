package model;

import java.io.Serializable;

public interface Team extends Serializable{
    /**
     * 
     * @return the Team's name
     */
    public String getName();
    /**
     * 
     * @return the transfer jersey's colour
     */
    public String getTransferJerseyColour();
    /**
     * 
     * @return the home jersey's colour
     */
    public String getHomeJerseyColour();
}
