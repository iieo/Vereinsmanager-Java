package gui;

import database.DataController;
import database.Database;
import main.Kategorie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame  {
    private Database db;


    private final JButton addBtn, removeBtn, editBtn;
    private final JButton personenCatBtn, mitgliederCatBtn,
            rechnungenCatBtn, kontenCatBtn, orchesterCatBtn;
    private final JList<Object> list;
    private Kategorie anzeige;
    private DataController controller;

    public MainWindow(Database db, DataController controller) {
        this.controller = controller;
        this.db = db;
        this.anzeige = Kategorie.PERSON;

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                db.close();
            }
        });

        /*
         * NORTH
         */

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));

        addBtn = new JButton("Hinzufügen");
        addBtn.addActionListener(e -> new AddWindow(db, this, anzeige));
        northPanel.add(addBtn);

        editBtn = new JButton("Bearbeiten");
        editBtn.addActionListener(e->{});
        northPanel.add(editBtn);

        removeBtn = new JButton("Entfernen");
        removeBtn.addActionListener(e->{});
        northPanel.add(removeBtn);

        this.add(northPanel, BorderLayout.NORTH);


        /*
         * CENTER
         */
        list = new JList<>();
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);


        /*
         * WEST
         */

        JPanel catPanel = new JPanel();
        catPanel.setLayout(new BoxLayout(catPanel, BoxLayout.Y_AXIS));


        personenCatBtn = new JButton("Personen");
        personenCatBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        personenCatBtn.addActionListener(e -> {this.anzeige = Kategorie.PERSON;refresh();});
        catPanel.add(personenCatBtn);

        mitgliederCatBtn = new JButton("Mitglieder");
        mitgliederCatBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        mitgliederCatBtn.addActionListener(e -> {this.anzeige = Kategorie.MITGLIED;refresh();});
        catPanel.add(mitgliederCatBtn);

        rechnungenCatBtn = new JButton("Rechnungen");
        rechnungenCatBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        rechnungenCatBtn.addActionListener(e -> {this.anzeige = Kategorie.RECHNUNG;refresh();});
        catPanel.add(rechnungenCatBtn);

        kontenCatBtn = new JButton("Konten");
        kontenCatBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        kontenCatBtn.addActionListener(e -> {this.anzeige = Kategorie.KONTO;refresh();});
        catPanel.add(kontenCatBtn);

        orchesterCatBtn = new JButton("Orchestermitglieder");
        orchesterCatBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        orchesterCatBtn.addActionListener(e -> {this.anzeige = Kategorie.ORCHESTER;refresh();});
        catPanel.add(orchesterCatBtn);

        this.add(catPanel, BorderLayout.WEST);

        refresh();
        this.setVisible(true);
    }

    public void refresh() {
        String[] data = new String[0];
        switch (anzeige) {
            case KONTO -> {
                db.reloadKonten();
                data = controller.getKonten().stream().map(k -> controller.getPerson(k.getPersonID()) +" - " + k.getIBAN()).toArray(String[]::new);
            }
            case RECHNUNG -> {
                db.reloadRechnungen();
                data = controller.getRechnungen().stream().map(r -> controller.getPerson(r.getSenderID()) +" zahlt " + r.getMenge() + "€ an " + controller.getPerson(r.getEmpfaengerID())).toArray(String[]::new);
            }
            case PERSON -> {
                db.reloadPersonen();
                data = controller.getPersonen().stream().map(p-> p.getName() + " " + p.getVorname() + " - " + p.getEmail() + " - " + p.getGeburtsdatum().toString()).toArray(String[]::new);
            }
            case MITGLIED -> {
                db.reloadMitglieder();
                data = controller.getMitglieder().stream().map(m -> controller.getPerson(m.getPersonID()) + " " + m.getKosten()).toArray(String[]::new);
            }
            case ORCHESTER -> {
                db.reloadOrchester();
                data = controller.getOrchesterMitglieder().stream().map(o -> controller.getPerson(o.getPersonID()) + " " + o.getInstrument()).toArray(String[]::new);
            }
        }

        list.setListData(data);
    }

}
