package database;

import main.Manager;
import models.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    private Connection connection;
    private String dataBasePath;
    private Manager manager;

    public Database(String dataBasePath, Manager manager) {
        this.manager = manager;
        this.dataBasePath = dataBasePath;
        boolean fileCreated = createFile();

        openConnection();

        if (fileCreated) {
            createNewDatabank();
        }
    }

    private boolean createFile() {
        File f = new File(dataBasePath);
        boolean createdNewDB = false;
        try {
            createdNewDB = f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createdNewDB;
    }

    private void openConnection() {
        connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dataBasePath);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private void createNewDatabank() {
        executeStatement(SQLDefault.CREATE_PERSONEN_TABLE);
        executeStatement(SQLDefault.CREATE_KONTEN_TABLE);
        executeStatement(SQLDefault.CREATE_RECHNUNGEN_TABLE);
        executeStatement(SQLDefault.CREATE_MITGLIEDER_TABLE);
        executeStatement(SQLDefault.CREATE_ORCHESTER_TABLE);
    }

    public boolean executeStatement(String sql) {
        boolean success = true;
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                success = false;
            }
        }
        return success;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                rs = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public void reloadAll(){
        reloadKonten();
        reloadPersonen();
        reloadRechnungen();
        reloadMitglieder();
        reloadOrchester();
    }
    public void reloadPersonen() {
        manager.getController().clearLoadedPersonen();
        ResultSet rs = executeQuery(SQLDefault.GET_PERSONEN);
        try {
            while (rs.next()) {
                int ID = rs.getInt("PERSONID");
                String name = rs.getString("NAME");
                String vorname = rs.getString("VORNAME");
                String strasse = rs.getString("STRASSE");
                int hausnummer = rs.getInt("HAUSNUMMER");
                int plz = rs.getInt("PLZ");
                String ort = rs.getString("ORT");
                Date geburtsdatum = rs.getDate("GEBURTSDATUM");
                String email = rs.getString("EMAIL");
                String email2 = rs.getString("EMAIL2");
                String telefon = rs.getString("TELEFON");
                String handy = rs.getString("HANDY");
                Person person = new Person(ID, name, vorname, strasse,hausnummer, plz, ort, geburtsdatum, email, email2,
                        telefon, handy);
                manager.getController().addPerson(person);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void reloadMitglieder() {
        manager.getController().clearLoadedMitglieder();
        ResultSet rs = executeQuery(SQLDefault.GET_MITGLIEDER);
        try {
            while (rs.next()) {
                int ID = rs.getInt("MITGLIEDID");
                int personid = rs.getInt("PERSONID");
                int kontoid = rs.getInt("KONTOID");
                Date eintritt = rs.getDate("EINTRITT");
                Date austritt = rs.getDate("AUSTRITT");
                int spende = rs.getInt("SPENDE");
                int kosten = rs.getInt("KOSTEN");
                Mitglied mitglied = new Mitglied(ID, personid, kontoid, eintritt, austritt, spende, kosten);
                manager.getController().addMitlgied(mitglied);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void reloadOrchester() {
        manager.getController().clearLoadedOrchesterMitglieder();
        List<Orchester> orchesters = new ArrayList<>();
        ResultSet rs = executeQuery(SQLDefault.GET_ORCHESTER);
        try {
            while (rs.next()) {
                int ID = rs.getInt("ORCHESTERID");
                int personID = rs.getInt("PERSONID");
                int mitgliedID = rs.getInt("MITGLIEDID");
                String instrument = rs.getString("INSTRUMENT");
                String orchestertyp = rs.getString("ORCHESTERTYP");
                int kosten = rs.getInt("KOSTEN");
                Orchester orchester = new Orchester(ID, personID, mitgliedID, instrument, orchestertyp, kosten);
                manager.getController().addOrchester(orchester);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reloadRechnungen() {
        manager.getController().clearLoadedRechnungen();
        ResultSet rs = executeQuery(SQLDefault.GET_RECHNUNGEN);
        try {
            while (rs.next()) {
                int ID = rs.getInt("RECHNUNGID");
                int empfaengerid = rs.getInt("EMPFAENGERID");
                int senderid = rs.getInt("SENDERID");
                String zweck = rs.getString("ZWECK");
                String kategorie = rs.getString("KATEGORIE");
                String bereich = rs.getString("BEREICH");
                int menge = rs.getInt("MENGE");
                Date rechnungsdatum = rs.getDate("RECHNUNGSDATUM");
                Date bezahlt = rs.getDate("BAZAHLT");
                Rechnung rechnung = new Rechnung(ID, empfaengerid, senderid, zweck, kategorie, bereich,
                        menge, rechnungsdatum, bezahlt);
                manager.getController().addRechnung(rechnung);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reloadKonten() {
        manager.getController().clearLoadedKonten();
        ResultSet rs = executeQuery(SQLDefault.GET_KONTEN);
        try {
            while (rs.next()) {
                int ID = rs.getInt("KONTOID");
                int personid = rs.getInt("PERSONID");
                String iban = rs.getString("IBAN");
                String bic = rs.getString("BIC");
                String kreditinstitut = rs.getString("KREDITINSTITUT");
                Date unterschrift = rs.getDate("UNTERSCHRIFT");

                Konto konto = new Konto(ID, personid, iban, bic, kreditinstitut, unterschrift);
                manager.getController().addKonto(konto);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean addPerson(Person person){
        String sqlStatement = SQLDefault.INSERT_PERSON +"'"+
                person.getName() + "', '" + person.getVorname() +"', '"+ person.getStrasse() + "', " + person.getHausnummer() + ", " + person.getPlz()
                + ", '" + person.getOrt() + "', " + getDateFormat(person.getGeburtsdatum()) + ", '"
                + person.getEmail() + "', '" + person.getEmail2() + "', '" + person.getTelefon() + "', '" + person.getHandy()+ "')";
        return executeStatement(sqlStatement);
    }


    public boolean addRechnung(Rechnung r){
        String sqlStatement = SQLDefault.INSERT_RECHNUNG +"'"+
                r.getEmpfaengerID() + "', '" + r.getSenderID() + "', '"+ r.getZweck() + "', '" + r.getKategorie() + "', '"
                + r.getBereich() + "', " + r.getMenge() + ", " + getDateFormat(r.getRechnungsdatum()) + ", " + getDateFormat(r.getBezahlt()) + ");";
        return executeStatement(sqlStatement);
    }

    public boolean addKonto(Konto k){
        String sqlStatement = SQLDefault.INSERT_KONTO + k.getPersonID() + ", '" + k.getIBAN() + "', '" + k.getBIC() + "', '" + k.getKreditinstitut() + "', "
                + getDateFormat(k.getUnterschrift()) + ")";
        return executeStatement(sqlStatement);
    }

    public boolean addOrchester(Orchester o){
        String sqlStatement = SQLDefault.INSERT_ORCHESTER+ o.getPersonID()  + ", " + o.getMitgliedID() + ", '" + o.getInstrument() + "', '" + o.getOrchestertyp() + "', " + o.getKosten()+ ")";
        return executeStatement(sqlStatement);
    }

    public boolean addMitglied(Mitglied m){
        String sqlStatement = SQLDefault.INSERT_MITGLIED  + ", " + m.getPersonID()  + ", " + m.getKontoID()  + ", " + getDateFormat(m.getEintritt())  + ", " + getDateFormat(m.getAustritt())
                + ", " + m.getSpende() + ", " + m.getKosten() + ")";
        return executeStatement(sqlStatement);
    }

    private String getDateFormat(Date date){
        return date == null ? null : String.valueOf(date.getTime());
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
