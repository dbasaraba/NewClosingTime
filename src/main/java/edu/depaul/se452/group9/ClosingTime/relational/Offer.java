package edu.depaul.se452.group9.ClosingTime.relational;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Offer {
    @Id
    @GeneratedValue
    private String buyerID;
    private String sellerID;
    private String offerAmmount;
    private String offerID;

    public Offer(String buyerID, String sellerID, String offerAmmount, String offerID){

        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.offerAmmount = offerAmmount;
        this.offerID = offerID;
    }

    @Override
    public String toString(){
        return String.format("Offer[buyerID='%s', sellerID='%s', OfferAmmount='%s', offerID ='%s']",
                buyerID,sellerID,offerAmmount, offerID);
    }


    /**
     * @return String return the offerID
     */
    public String getOfferID() {
        return offerID;
    }
    /**
     * @return String return the buyerID
     */
    public String getBuyerID() {
        return buyerID;
    }
    /**
     * @return String return the sellerID
     */
    public String getSellerID() {
        return sellerID;
    }
    /**
     * @return String return the offerAmmount
     */
    public String getofferAmmount() { return offerAmmount; }

    /**
     * @param offerID the offerID to set
     */
    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    /**
     * @param buyerID the buyerID to set
     */
    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    /**
     * @param sellerID the sellerID to set
     */
    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * @param offerAmmount the messageBody to set
     */
    public void setOfferAmmount(String offerAmmount) { this.offerAmmount = offerAmmount; }

}
