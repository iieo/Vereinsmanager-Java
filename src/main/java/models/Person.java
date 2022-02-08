package models;

import java.util.Date;

public class Person extends Model {
    private final String name, vorname, strasse;
    private final int hausnummer, plz;
    private final String ort;
    private final Date geburtsdatum;
    private final String email, email2, telefon, handy;


    public Person(int ID, String name, String vorname, String strasse, int hausnummer, int plz, String ort, Date geburtsdatum, String email, String email2, String telefon, String handy) {
        super(ID);
        this.name = name;
        this.vorname = vorname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
        this.email2 = email2;
        this.telefon = telefon;
        this.handy = handy;
    }

    @Override
    public String toString() {
        return name + " " + vorname;
    }

    public String getName() {
        return name;
    }


    public String getVorname() {
        return vorname;
    }


    public String getStrasse() {
        return strasse;
    }


    public int getHausnummer() {
        return hausnummer;
    }


    public int getPlz() {
        return plz;
    }


    public String getOrt() {
        return ort;
    }


    public Date getGeburtsdatum() {
        return geburtsdatum;
    }


    public String getEmail() {
        return email;
    }


    public String getEmail2() {
        return email2;
    }

    public String getTelefon() {
        return telefon;
    }


    public String getHandy() {
        return handy;
    }

}
