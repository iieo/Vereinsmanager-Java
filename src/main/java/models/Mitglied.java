package models;

import java.util.Date;

public class Mitglied extends Model {
    private final int personID, kontoID;
    private final Date eintritt, austritt;
    private final int spende, kosten;

    public Mitglied(int ID, int personID, int kontoID, Date eintritt, Date austritt, int spende, int kosten) {
        super(ID);
        this.personID = personID;
        this.kontoID = kontoID;
        this.eintritt = eintritt;
        this.austritt = austritt;
        this.spende = spende;
        this.kosten = kosten;
    }

    @Override
    public String toString() {
        return ID + " - " + personID;
    }


    public int getSpende() {
        return spende;
    }


    public int getPersonID() {
        return personID;
    }


    public int getKontoID() {
        return kontoID;
    }


    public Date getEintritt() {
        return eintritt;
    }


    public Date getAustritt() {
        return austritt;
    }

    public int getKosten() {
        return kosten;
    }

}
