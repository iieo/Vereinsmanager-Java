package models;

import java.util.Date;

public class Rechnung extends Model {
    private final int empfaengerID, senderID;
    private final String zweck, kategorie, bereich;
    private final int menge;
    private final Date rechnungsdatum;
    private final Date bezahlt;


    public Rechnung(int ID, int empfaengerID, int senderID, String zweck, String kategorie, String bereich, int menge, Date rechnungsdatum, Date bezahlt) {
        super(ID);
        this.empfaengerID = empfaengerID;
        this.senderID = senderID;
        this.zweck = zweck;
        this.kategorie = kategorie;
        this.bereich = bereich;
        this.menge = menge;
        this.rechnungsdatum = rechnungsdatum;
        this.bezahlt = bezahlt;

    }


    @Override
    public String toString() {
        return menge + " an " + empfaengerID;
    }

    public int getEmpfaengerID() {
        return empfaengerID;
    }


    public int getSenderID() {
        return senderID;
    }


    public String getZweck() {
        return zweck;
    }


    public String getKategorie() {
        return kategorie;
    }


    public String getBereich() {
        return bereich;
    }


    public int getMenge() {
        return menge;
    }

    public Date getRechnungsdatum() {
        return rechnungsdatum;
    }

    public Date getBezahlt() {
        return bezahlt;
    }

}