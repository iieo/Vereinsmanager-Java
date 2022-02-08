package models;

import java.util.ArrayList;
import java.util.List;

public class Orchester extends Model{
    private final int personID;
    private final int mitgliedID;
    private final String instrument;
    private final String orchestertyp;
    private final int kosten;


    public Orchester(int ID, int personID, int mitgliedID, String instrument, String orchestertyp, int kosten) {
        super(ID);
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

    public int getPersonID() {
        return personID;
    }


    public int getMitgliedID() {
        return mitgliedID;
    }


    public String getInstrument() {
        return instrument;
    }


    public String getOrchestertyp() {
        return orchestertyp;
    }


    public int getKosten() {
        return kosten;
    }

}
