package edu.depaul.se452.group9.ClosingTime.relational;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Property {
    @Id
    @GeneratedValue
    private String sellerID;

    private String state;
    private String city;
    private String streetAddress;

    public Property(String state, String city,String streetAddress){
        this.state=state;
        this.city=city;
        this.streetAddress=streetAddress;
    }

    @Override
    public String toString(){
        return String.format("Property[sellerID='%s', city='%s', state='%s', streetAddress='%s']",
                sellerID,city,state,streetAddress);
    }

    /**
     * @param sellerID the sellerID to set
     */
    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }


    /**
     * @return int return the sellerID
     */
    public String getSellerID() {
        return sellerID;
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
