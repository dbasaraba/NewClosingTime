package edu.depaul.se452.group9.ClosingTime.relational;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Favourite {
    @Id
    @GeneratedValue
    private String propertyID;
    private String favourite;

    public Favourite(String propertyID, String favourite) {

        this.propertyID = propertyID;
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return String.format("Favourite[propertyID='%s', favourite='%s']",
                propertyID, favourite);
    }

    /**
     * @return String return the propertyID
     */
    public String getPropertyID() {
        return propertyID;
    }

    /**
     * @param propertyID the propertyID to set
     */
    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }


    /**
     * @return String return the favourite
     */
    public String getFavourite() {
        return favourite;
    }

    /**
     * @param favourite the favourite to set
     */
    public void setFavourite(String favourite) {
        this.favourite= favourite;
    }

}

