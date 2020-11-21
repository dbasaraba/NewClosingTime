package edu.depaul.se452.group9.ClosingTime.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;


@Data
@Entity
public class VisitRequests {
    @Id
    @GeneratedValue
    private String propertyID;
    private String buyerID;
    private String visitRequests;


    public VisitRequests(String buyerID, String propertyID, String visitRequests){

        this.buyerID = buyerID;
        this.propertyID = propertyID;
        this.visitRequests = visitRequests;
    }

    @Override
    public String toString(){
        return String.format("VisitRequests[buyerID='%s', propertyID='%s', visitRequests='%s']",
                buyerID,propertyID,visitRequests);
    }

    /**
     * @return String return the buyerID
     */
    public String getBuyerID() {
        return buyerID;
    }

    /**
     * @param buyerID the buyerID to set
     */
    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
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
     * @return String return the visitRequests
     */
    public String getVisitRequests() {
        return visitRequests;
    }

    /**
     * @param visitRequests the visitRequests to set
     */
    public void setVisitRequests(String visitRequests) {
        this.visitRequests = visitRequests;
    }

}
