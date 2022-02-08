package gui.input;

import main.Manager;
import models.Rechnung;

import javax.swing.*;
import java.util.Date;

public class InputRechnung extends InputPanel {

    private final JTextField zweck;
    private final JTextField kategorie;
    private final JTextField bereich;
    private final JSpinner senderId;
    private final JSpinner empfaengerId;
    private final JSpinner menge;
    private final JSpinner rechnungsdatum;
    private final JSpinner bezahlDatum;


    public InputRechnung(Manager manager) {
        super(manager);

        empfaengerId = addNumberInput("Empfänger ID");
        senderId = addNumberInput("Sender ID");
        zweck = addTextInput("Zweck");
        kategorie = addTextInput("Kategorie");
        bereich = addTextInput("Bereich");
        menge = addNumberInput("Menge");
        rechnungsdatum = addDateInput("Rechnungsdatum");
        bezahlDatum = addDateInput("Bezahldatum");

    }

    @Override
    public void saveToDatabase() {
        Rechnung rechnung = new Rechnung(-1, (int) empfaengerId.getValue(), (int) senderId.getValue(), zweck.getText(), kategorie.getText(), bereich.getText(), (int) menge.getValue(), (Date) rechnungsdatum.getValue(), (Date) bezahlDatum.getValue());
        manager.getDb().addRechnung(rechnung);
    }

}
