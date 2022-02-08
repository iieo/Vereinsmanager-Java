package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Konto {
    private final int ID;
    private int personID;
    private String IBAN, BIC, kreditinstitut;
    private Date unterschrift;


    public Konto(int ID, int personID, String IBAN, String BIC, String kreditinstitut, Date unterschrift) {
        this.ID = ID;
        this.personID = personID;
        this.IBAN = IBAN;
        this.BIC = BIC;
        this.kreditinstitut = kreditinstitut;
        this.unterschrift = unterschrift;
    }

    public Date getUnterschrift() {
        return unterschrift;
    }

    public void setUnterschrift(Date unterschrift) {
        this.unterschrift = unterschrift;
    }

    public int getID() {
        return ID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getKreditinstitut() {
        return kreditinstitut;
    }

    public void setKreditinstitut(String kreditinstitut) {
        this.kreditinstitut = kreditinstitut;
    }
}
