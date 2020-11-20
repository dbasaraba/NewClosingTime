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
public class ListingPrice {

    @Id
    @GeneratedValue
    private String sellerID;
    private String propertyID;
    private String priceID;

    public ListingPrice(String sellerID, String propertyID, String priceID) {
        this.priceID = priceID;
        this.propertyID = propertyID;
        this.sellerID = sellerID;
    }

    @Override
    public String toString() {
        return String.format("ListingPrice[sellerID='%s', propertyID='%s', priceID='%s']",
                sellerID, propertyID, priceID);
    }

    /**
     * @return String return the offerID
     */
    public String getsellerID() {
        return sellerID;
    }

    /**
     * @param sellerID the sellerID to set
     */
    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * @return String return the propertyID
     */
    public String getPropertyIDID() {
        return propertyID;
    }

    /**
     * @param propertyID the propertyID to set
     */
    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }


    /**
     * @return String return the priceID
     */
    public String getPriceID() {
        return priceID;
    }

    /**
     * @param priceID the priceID to set
     */
    public void setPriceID(String priceID) {
        this.priceID= priceID;
    }





}


