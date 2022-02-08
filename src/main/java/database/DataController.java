package database;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class DataController {


    private final List<Mitglied> mitglieder = new ArrayList<>();
    private final List<Orchester> orchesterMitglieder = new ArrayList<>();
    private final List<Rechnung> rechnungen = new ArrayList<>();
    private final List<Person> personen = new ArrayList<>();
    private final List<Konto> konten = new ArrayList<>();

    public void addMitlgied(Mitglied m) {
        mitglieder.add(m);
    }

    public void addPerson(Person m) {
        personen.add(m);
    }

    public void addRechnung(Rechnung m) {
        rechnungen.add(m);
    }

    public void addKonto(Konto m) {
        konten.add(m);
    }

    public void addOrchester(Orchester m) {
        orchesterMitglieder.add(m);
    }

    public Mitglied getMitglied(int id) {
        for (Mitglied m : mitglieder) {
            if (m.getID() == id) {
                return m;
            }
        }
        return null;
    }

    public Orchester getOrchesterMitglied(int id) {
        for (Orchester m : orchesterMitglieder) {
            if (m.getID() == id) {
                return m;
            }
        }
        return null;
    }

    public Rechnung getRechnung(int id) {
        for (Rechnung r : rechnungen) {
            if (r.getID() == id) {
                return r;
            }
        }
        return null;
    }

    public Konto getKonto(int id) {
        for (Konto k : konten) {
            if (k.getID() == id) {
                return k;
            }
        }
        return null;
    }

    public Person getPerson(int id) {
        for (Person p : personen) {
            if (p.getID() == id) {
                return p;
            }
        }
        return null;
    }

    public void clearLoadedPersonen() {
        personen.clear();
    }

    public void clearLoadedKonten() {
        konten.clear();
    }

    public void clearLoadedOrchesterMitglieder() {
        orchesterMitglieder.clear();
    }

    public void clearLoadedRechnungen() {
        rechnungen.clear();
    }

    public void clearLoadedMitglieder() {
        mitglieder.clear();
    }

    public List<Mitglied> getMitglieder() {
        return mitglieder;
    }

    public List<Orchester> getOrchesterMitglieder() {
        return orchesterMitglieder;
    }

    public List<Rechnung> getRechnungen() {
        return rechnungen;
    }

    public List<Person> getPersonen() {
        return personen;
    }

    public List<Konto> getKonten() {
        return konten;
    }
}
