package gui.input;

import gui.SelectButton;
import main.Kategorie;
import main.Manager;
import models.Konto;

import javax.swing.*;
import java.util.Date;

public class InputKonto extends InputPanel {

    private final JTextField iban;
    private final JTextField bic;
    private final JTextField kreditinstitut;
    private final JSpinner unterschrift;
    private final SelectButton personId;

    public InputKonto(Manager manager) {
        super(manager);
        personId = addSelectIDInput(Kategorie.PERSON);
        iban = addTextInput("IBAN");
        bic = addTextInput("BIC");
        kreditinstitut = addTextInput("Kreditinstitut");
        unterschrift = addDateInput("Datum der Unterschrift");
    }

    @Override
    public void saveToDatabase() {
        Konto konto = new Konto(-1, personId.getID(), iban.getText(), bic.getText(), kreditinstitut.getText(), (Date) unterschrift.getValue());
        manager.getDb().addKonto(konto);
    }
}
