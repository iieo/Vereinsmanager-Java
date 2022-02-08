package database;

public class SQLDefault {

    public static String CREATE_PERSONEN_TABLE = "CREATE TABLE personen\n" +
            "(PERSONID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "NAME TINYTEXT NOT NULL,\n" +
            "VORNAME TINYTEXT NOT NULL,\n" +
            "STRASSE TINYTEXT,\n" +
            "HAUSNUMMER TINYINT,\n" +
            "PLZ SMALLINT,\n" +
            "ORT TINYTEXT,\n" +
            "GEBURTSDATUM DATE,\n" +
            "EMAIL TINYTEXT,\n" +
            "EMAIL2 TINYTEXT,\n" +
            "TELEFON TINYTEXT,\n" +
            "HANDY TINYTEXT)";
    public static String CREATE_MITGLIEDER_TABLE = "CREATE TABLE mitglieder\n" +
            "(MITGLIEDID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "PERSONID INTEGER,\n" +
            "KONTOID INTEGER,\n" +
            "EINTRITT DATE,\n" +
            "AUSTRITT DATE,\n" +
            "SPENDE TINYINT,\n" +
            "KOSTEN TINYINT)";
    public static String CREATE_ORCHESTER_TABLE = "CREATE TABLE orchester\n" +
            "(ORCHESTERID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "PERSONID INTEGER,\n" +
            "MITGLIEDID INTEGER,\n" +
            "INSTRUMENT TINYTEXT,\n" +
            "ORCHESTERTYP TINYTEXT,\n" +
            "KOSTEN TINYINT)";
    public static String CREATE_KONTEN_TABLE = "CREATE TABLE konten\n" +
            "(KONTOID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "PERSONID INTEGER,\n" +
            "IBAN TINYTEXT,\n" +
            "BIC TINYTEXT,\n" +
            "KREDITINSTITUT TINYTEXT," +
            "UNTERSCHRIFT DATE)";
    public static String CREATE_RECHNUNGEN_TABLE = "CREATE TABLE rechnungen\n" +
            "(RECHNUNGID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "EMPFAENGERID INTEGER,\n" +
            "SENDERID INTEGER,\n" +
            "ZWECK TEXT,\n" +
            "KATEGORIE TINYTEXT,\n" +
            "BEREICH TINYTEXT,\n" +
            "MENGE INTEGER,\n" +
            "RECHNUNGSDATUM DATE,\n" +
            "BEZAHLT DATE)";

    public static String GET_MITGLIEDER = "SELECT * FROM mitglieder";
    public static String GET_KONTEN = "SELECT * FROM konten";
    public static String GET_RECHNUNGEN = "SELECT * FROM rechnungen";
    public static String GET_PERSONEN = "SELECT * FROM personen";
    public static String GET_ORCHESTER = "SELECT * FROM orchester";
    public static String INSERT_PERSON = "INSERT INTO personen (NAME, VORNAME, STRASSE, HAUSNUMMER, PLZ, ORT, GEBURTSDATUM, EMAIL, EMAIL2," +
            "TELEFON, HANDY) VALUES (";
    public static String INSERT_KONTO = "INSERT INTO konten (PERSONID, IBAN, BIC, KREDITINSTITUT, UNTERSCHRIFT) VALUES (";
    public static String INSERT_RECHNUNG = "INSERT INTO rechnungen (EMPFAENGERID, SENDERID, ZWECK, KATEGORIE, BEREICH, MENGE, RECHNUNGSDATUM, BEZAHLT) VALUES (";
    public static String INSERT_MITGLIED = "INSERT INTO mitglieder (PERSONID, KONTOID, EINTRITT, AUSTRITT, SPENDE, KOSTEN) VALUES (";
    public static String INSERT_ORCHESTER = "INSERT INTO orchester (PERSONID, MITGLIEDID, INSTRUMENT, ORCHESTERTYP, KOSTEN) VALUES (";
}
