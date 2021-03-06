package gui.input;

import main.Manager;
import models.Mitglied;

import javax.swing.*;
import java.util.Date;

public class InputMitglied extends InputPanel {

    private final JSpinner personId;
    private final JSpinner kontoId;
    private final JSpinner eintrittsdatum;
    private final JSpinner austrittsdatum;
    private final JSpinner spende;
    private final JSpinner kosten;


    public InputMitglied(Manager manager) {
        super(manager);

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
        manager.getDb().addMitglied(mitglied);
    }
}
