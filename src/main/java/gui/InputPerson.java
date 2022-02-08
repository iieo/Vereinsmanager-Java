package gui;

import database.Database;
import models.Person;

import javax.swing.*;
import java.util.Date;

public class InputPerson extends InputPanel {

    private JTextField name, vorname, strasse, ort, email, email2, telefon, handy;
    private JSpinner geburtsdatum, hausnummer, plz;

    public InputPerson(Database db) {
        super(db);

        name = addTextInput("Name");
        vorname = addTextInput("Vorname");
        strasse = addTextInput("Straße");
        hausnummer = addNumberInput("Hausnummer");
        plz = addNumberInput("Postleitzahl");
        ort = addTextInput("Ort");
        geburtsdatum = addDateInput("Geburtsdatum");
        email = addTextInput("Email");
        email2 = addTextInput("Email 2");
        telefon = addTextInput("Telefon");
        handy = addTextInput("Handy");
    }

    @Override
    public void saveToDatabase() {
        String personName = name.getText();
        String personVorname = vorname.getText();
        if (isValidInput(personName) && isValidInput(personVorname)) {
            Person person = new Person(-1, personName, personVorname, strasse.getText(), (int) hausnummer.getValue(), (int) plz.getValue(), ort.getText(), (Date) geburtsdatum.getValue(), email.getText(), email2.getText(), telefon.getText(), handy.getText());
            db.addPerson(person);
        }
    }
}
