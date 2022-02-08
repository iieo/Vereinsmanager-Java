package gui.input;

import main.Manager;
import models.Person;

import javax.swing.*;
import java.util.Date;

public class InputPerson extends InputPanel {

    private final JTextField name;
    private final JTextField vorname;
    private final JTextField strasse;
    private final JTextField ort;
    private final JTextField email;
    private final JTextField email2;
    private final JTextField telefon;
    private final JTextField handy;
    private final JSpinner geburtsdatum;
    private final JSpinner hausnummer;
    private final JSpinner plz;

    public InputPerson(Manager manager) {
        super(manager);

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
            manager.getDb().addPerson(person);
        }
    }
}
