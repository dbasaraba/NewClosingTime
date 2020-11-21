package edu.depaul.se452.group9.ClosingTime.relational;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue
    private String propertyID;

    private String state;
    private String city;
    private String streetAddress;

    public Location(String propertyID, String state, String city,String streetAddress){
        this.propertyID = propertyID;
        this.state = state;
        this.city = city;
        this.streetAddress = streetAddress;
    }

    @Override
    public String toString(){
        return String.format("Location[propertyID='%s', city='%s', state='%s', streetAddress='%s']",
                propertyID,city,state,streetAddress);
    }

    /**
     * @param propertyID the propertyID to set
     */
    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }


    /**
     * @return String return the propertyID
     */
    public String getPropertyID() {
        return propertyID;
    }


    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }


    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    /**
     * @return String return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

}

