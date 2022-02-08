package gui;

import database.Database;
import models.Konto;

import javax.swing.*;
import java.util.Date;

public class InputKonto extends InputPanel{

    private JTextField iban, bic, kreditinstitut;
    private JSpinner personId, unterschrift;


    public InputKonto(Database db) {
        super(db);
        personId = addNumberInput("Person ID");
        iban = addTextInput("IBAN");
        bic = addTextInput("BIC");
        kreditinstitut = addTextInput("Kreditinstitut");
        unterschrift = addDateInput("Datum der Unterschrift");
    }

    @Override
    public void saveToDatabase() {
        Konto konto = new Konto(-1, (int)personId.getValue(), iban.getText(), bic.getText(), kreditinstitut.getText(), (Date) unterschrift.getValue());
        db.addKonto(konto);
    }
}
