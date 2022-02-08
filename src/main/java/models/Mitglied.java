package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mitglied {
    private final int ID;
    private int personID, kontoID;
    private Date eintritt, austritt;
    private int spende, kosten;

    public Mitglied(int ID, int personID, int kontoID, Date eintritt, Date austritt, int spende, int kosten) {
        this.ID = ID;
        this.personID = personID;
        this.kontoID = kontoID;
        this.eintritt = eintritt;
        this.austritt = austritt;
        this.spende = spende;
        this.kosten = kosten;
    }

    @Override
    public String toString() {
        return ID + " - " + personID ;
    }


    public int getSpende() {
        return spende;
    }

    public void setSpende(int spende) {
        this.spende = spende;
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

    public int getKontoID() {
        return kontoID;
    }

    public void setKontoID(int kontoID) {
        this.kontoID = kontoID;
    }

    public Date getEintritt() {
        return eintritt;
    }

    public void setEintritt(Date eintritt) {
        this.eintritt = eintritt;
    }

    public Date getAustritt() {
        return austritt;
    }

    public void setAustritt(Date austritt) {
        this.austritt = austritt;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }
}
