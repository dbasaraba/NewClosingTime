package edu.depaul.se452.group9.ClosingTime.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account  {
    @Id
    @GeneratedValue
    private String accountID;
    private String accountInformation;

    public Account(String accountID, String accountInformation){

        this.accountID = accountID;
        this.accountInformation = accountInformation;
    }

    @Override
    public String toString(){
        return String.format("Account[accountID='%s', accountInformation='%s']",
                accountID,accountInformation);
    }

    /**
     * @return String return the accountID
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    /**
     * @return String return the accountInformation
     */
    public String getAccountInformation() {
        return accountInformation;
    }

    /**
     * @param accountInformation the accountInformation to set
     */
    public void setAccountInformation(String accountInformation) {
        this.accountInformation = accountInformation;
    }

}

