package gui.input;

import main.Manager;
import models.Orchester;

import javax.swing.*;

public class InputOrchester extends InputPanel{

    private JTextField instrument, orchestertyp;
    private JSpinner personID, mitgliedID, kosten;


    public InputOrchester(Manager manager) {
        super(manager);

        personID = addNumberInput("Person ID");
        mitgliedID = addNumberInput("Mitglied ID");
        instrument = addTextInput("Instrument");
        orchestertyp = addTextInput("Orchestertyp");
        kosten = addNumberInput("Kosten");
    }

    @Override
    public void saveToDatabase() {
        Orchester orchester = new Orchester(-1, (int)personID.getValue(), (int)mitgliedID.getValue(), instrument.getText(), orchestertyp.getText(), (int)kosten.getValue());
        manager.getDb().addOrchester(orchester);
    }
}
