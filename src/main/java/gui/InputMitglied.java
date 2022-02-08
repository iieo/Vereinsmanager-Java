package gui;

import database.Database;
import models.Mitglied;

import javax.swing.*;
import java.util.Date;

public class InputMitglied extends InputPanel {

    private JSpinner personId, kontoId, eintrittsdatum, austrittsdatum, spende, kosten;


    public InputMitglied(Database db) {
        super(db);

        personId = addNumberInput("Person ID");
        kontoId = addNumberInput("Konto ID");
        eintrittsdatum = addDateInput("Eintrittsdaum");
        austrittsdatum = addDateInput("Austrittsdaum");
        spende = addNumberInput("Spende");
        kosten = addNumberInput("Kosten");
    }

    @Override
    public void saveToDatabase() {
        Mitglied mitglied = new Mitglied(-1, (int) personId.getValue(), (int) kontoId.getValue(), (Date) eintrittsdatum.getValue(), (Date) austrittsdatum.getValue(), (int) spende.getValue(), (int) kosten.getValue());
        db.addMitglied(mitglied);
    }
}
