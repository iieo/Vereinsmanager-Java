package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Konto  extends Model{
    private final int personID;
    private final String IBAN, BIC, kreditinstitut;
    private final Date unterschrift;


    public Konto(int ID, int personID, String IBAN, String BIC, String kreditinstitut, Date unterschrift) {
        super(ID);
        this.personID = personID;
        this.IBAN = IBAN;
        this.BIC = BIC;
        this.kreditinstitut = kreditinstitut;
        this.unterschrift = unterschrift;
    }

    public Date getUnterschrift() {
        return unterschrift;
    }



    public int getPersonID() {
        return personID;
    }


    public String getIBAN() {
        return IBAN;
    }


    public String getBIC() {
        return BIC;
    }


    public String getKreditinstitut() {
        return kreditinstitut;
    }

}
