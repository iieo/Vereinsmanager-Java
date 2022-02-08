package gui;

import main.Colors;
import main.Kategorie;
import main.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private final JButton addBtn, removeBtn, editBtn;
    private final JButton personenCatBtn, mitgliederCatBtn,
            rechnungenCatBtn, kontenCatBtn, orchesterCatBtn;
    private final JList<Object> list;
    private Kategorie anzeige;
    private Manager manager;

    public MainWindow(Manager manager) {
        this.manager = manager;
        this.anzeige = Kategorie.PERSON;
        manager.setMainWindow(this);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                manager.getDb().close();
            }
        });

        /*
         * NORTH
         */

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Colors.DARK_GREEN);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));

        addBtn = new JButton("Hinzufügen");
        addBtn.setBackground(Colors.LIGHT_GREEN);
        initMenuButton(addBtn);
        addBtn.addActionListener(e -> new AddWindow(manager, anzeige));
        northPanel.add(addBtn);

        editBtn = new JButton("Bearbeiten");
        editBtn.setBackground(Colors.GREEN);
        initMenuButton(editBtn);
        editBtn.addActionListener(e -> {
        });
        northPanel.add(editBtn);

        removeBtn = new JButton("Entfernen");
        removeBtn.setBackground(Colors.RED);
        initMenuButton(removeBtn);
        removeBtn.addActionListener(e -> {
        });
        northPanel.add(removeBtn);

        this.add(northPanel, BorderLayout.NORTH);


        /*
         * CENTER
         */
        list = new JList<>();
        list.setBackground(Colors.BLACK);
        list.setForeground(Colors.WHITE);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBackground(Colors.BLACK);
        scrollPane.setForeground(Colors.WHITE);
        scrollPane.getVerticalScrollBar().setBackground(Colors.GREEN);
        UIManager.put("ScrollBar.highlight", Colors.LIGHT_GREEN);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);


        /*
         * WEST
         */

        JPanel catPanel = new JPanel();
        catPanel.setLayout(new BoxLayout(catPanel, BoxLayout.Y_AXIS));
        catPanel.setBackground(Colors.DARK_GREEN);


        personenCatBtn = new JButton("Personen");
        initKategorieButton(personenCatBtn, Kategorie.PERSON);
        catPanel.add(personenCatBtn);

        mitgliederCatBtn = new JButton("Mitglieder");
        initKategorieButton(mitgliederCatBtn, Kategorie.MITGLIED);
        catPanel.add(mitgliederCatBtn);

        rechnungenCatBtn = new JButton("Rechnungen");
        initKategorieButton(rechnungenCatBtn, Kategorie.RECHNUNG);
        catPanel.add(rechnungenCatBtn);

        kontenCatBtn = new JButton("Konten");
        initKategorieButton(kontenCatBtn, Kategorie.KONTO);
        catPanel.add(kontenCatBtn);

        orchesterCatBtn = new JButton("Orchestermitglieder");
        initKategorieButton(orchesterCatBtn, Kategorie.ORCHESTER);
        catPanel.add(orchesterCatBtn);

        this.add(catPanel, BorderLayout.WEST);

        refresh();
        this.setVisible(true);
    }

    private void initMenuButton(JButton component) {
        component.setBorder(BorderFactory.createLineBorder(Colors.GREEN, 1));
        component.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        component.setPreferredSize(new Dimension(150, 30));
        component.setForeground(Colors.WHITE);
    }

    private void initKategorieButton(JButton component, Kategorie clickedKategorie) {
        component.setBackground(Colors.DARK_GREEN);
        component.setForeground(Colors.WHITE);
        component.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        component.setPreferredSize(new Dimension(150, 30));
        component.addActionListener(e -> {
            this.anzeige = clickedKategorie;
            refresh();
        });
        component.setBorder(BorderFactory.createLineBorder(Colors.GREEN, 1));
    }

    public void refresh() {
        String[] data = new String[0];
        switch (anzeige) {
            case KONTO -> {
                manager.getDb().reloadKonten();
                data = manager.getController().getKonten().stream().map(k -> manager.getController().getPerson(k.getPersonID()) + " - " + k.getIBAN()).toArray(String[]::new);
            }
            case RECHNUNG -> {
                manager.getDb().reloadRechnungen();
                data = manager.getController().getRechnungen().stream().map(r -> manager.getController().getPerson(r.getSenderID()) + " zahlt " + r.getMenge() + "€ an " + manager.getController().getPerson(r.getEmpfaengerID())).toArray(String[]::new);
            }
            case PERSON -> {
                manager.getDb().reloadPersonen();
                data = manager.getController().getPersonen().stream().map(p -> p.getName() + " " + p.getVorname() + " - " + p.getEmail() + " - " + p.getGeburtsdatum().toString()).toArray(String[]::new);
            }
            case MITGLIED -> {
                manager.getDb().reloadMitglieder();
                data = manager.getController().getMitglieder().stream().map(m -> manager.getController().getPerson(m.getPersonID()) + " " + m.getKosten()).toArray(String[]::new);
            }
            case ORCHESTER -> {
                manager.getDb().reloadOrchester();
                data = manager.getController().getOrchesterMitglieder().stream().map(o -> manager.getController().getPerson(o.getPersonID()) + " " + o.getInstrument()).toArray(String[]::new);
            }
        }

        list.setListData(data);
    }

}
