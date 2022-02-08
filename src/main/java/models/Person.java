package models;

import java.util.Date;

public class Person {
    private final int ID;
    private String name, vorname, strasse;
    private int hausnummer, plz;
    private String ort;
    private Date geburtsdatum;
    private String email, email2, telefon, handy;


    public Person(int ID, String name, String vorname, String strasse, int hausnummer, int plz, String ort, Date geburtsdatum, String email, String email2, String telefon, String handy) {
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getHandy() {
        return handy;
    }

    public void setHandy(String handy) {
        this.handy = handy;
    }
}
