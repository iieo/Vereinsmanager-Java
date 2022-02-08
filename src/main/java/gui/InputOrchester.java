package gui;

import database.Database;
import models.Orchester;

import javax.swing.*;

public class InputOrchester extends InputPanel{

    private JTextField instrument, orchestertyp;
    private JSpinner personID, mitgliedID, kosten;


    public InputOrchester(Database db) {
        super(db);

        personID = addNumberInput("Person ID");
        mitgliedID = addNumberInput("Mitglied ID");
        instrument = addTextInput("Instrument");
        orchestertyp = addTextInput("Orchestertyp");
        kosten = addNumberInput("Kosten");
    }

    @Override
    public void saveToDatabase() {
        Orchester orchester = new Orchester(-1, (int)personID.getValue(), (int)mitgliedID.getValue(), instrument.getText(), orchestertyp.getText(), (int)kosten.getValue());
        db.addOrchester(orchester);
    }
}
