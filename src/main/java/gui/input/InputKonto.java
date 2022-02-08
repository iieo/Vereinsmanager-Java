package gui.input;

import gui.SelectButton;
import main.Kategorie;
import main.Manager;
import models.Konto;

import javax.swing.*;
import java.util.Date;

public class InputKonto extends InputPanel{

    private JTextField iban, bic, kreditinstitut;
    private JSpinner unterschrift;
    private SelectButton personId;

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
