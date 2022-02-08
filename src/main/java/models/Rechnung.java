package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rechnung {
    private final int ID;
    private int empfaengerID, senderID;
    private String zweck, kategorie, bereich;
    private int menge;
    private Date rechnungsdatum;
    private Date bezahlt;


    public Rechnung(int ID, int empfaengerID, int senderID, String zweck, String kategorie, String bereich, int menge, Date rechnungsdatum, Date bezahlt) {
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public int getEmpfaengerID() {
        return empfaengerID;
    }

    public void setEmpfaengerID(int empfaengerID) {
        this.empfaengerID = empfaengerID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getZweck() {
        return zweck;
    }

    public void setZweck(String zweck) {
        this.zweck = zweck;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getBereich() {
        return bereich;
    }

    public void setBereich(String bereich) {
        this.bereich = bereich;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Date getRechnungsdatum() {
        return rechnungsdatum;
    }

    public void setRechnungsdatum(Date rechnungsdatum) {
        this.rechnungsdatum = rechnungsdatum;
    }

    public Date getBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(Date bezahlt) {
        this.bezahlt = bezahlt;
    }
}