package models;

import java.util.ArrayList;
import java.util.List;

public class Orchester {
    private final int ID;
    private int personID;
    private int mitgliedID;
    private String instrument;
    private String orchestertyp;
    private int kosten;


    public Orchester(int ID, int personID, int mitgliedID, String instrument, String orchestertyp, int kosten) {
        this.ID = ID;
        this.personID = personID;
        this.mitgliedID = mitgliedID;
        this.instrument = instrument;
        this.orchestertyp = orchestertyp;
        this.kosten = kosten;

    }
    @Override
    public String toString() {
        return ID + " - " + personID ;
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

    public int getMitgliedID() {
        return mitgliedID;
    }

    public void setMitgliedID(int mitgliedID) {
        this.mitgliedID = mitgliedID;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getOrchestertyp() {
        return orchestertyp;
    }

    public void setOrchestertyp(String orchestertyp) {
        this.orchestertyp = orchestertyp;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }
}
