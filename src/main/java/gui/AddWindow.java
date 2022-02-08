package gui;

import database.Database;
import main.Kategorie;

import javax.swing.*;
import java.awt.*;

public class AddWindow extends JFrame {
    private Database db;

    public AddWindow(Database db, MainWindow mainWindow, Kategorie kategorie) {
        this.db = db;

        this.setSize(400, 600);
        this.setLocationRelativeTo(null);

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());

        JLabel titleLbl = new JLabel(kategorie.name() + " erstellen");
        titleLbl.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        body.add(titleLbl, BorderLayout.NORTH);

        InputPanel inputPanel = switch (kategorie){
            case PERSON -> new InputPerson(db);
            case ORCHESTER -> new InputOrchester(db);
            case KONTO -> new InputKonto(db);
            case MITGLIED -> new InputMitglied(db);
            case RECHNUNG -> new InputRechnung(db);
            default -> throw new IllegalStateException("Unexpected value: " + kategorie);
        };
        body.add(inputPanel, BorderLayout.CENTER);

        JPanel footerBar = new JPanel();
        footerBar.setLayout(new BoxLayout(footerBar, BoxLayout.X_AXIS));
        footerBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        body.add(footerBar, BorderLayout.SOUTH);


        JButton closeBtn = new JButton("Close");
        closeBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        closeBtn.addActionListener((e) -> dispose());
        footerBar.add(closeBtn);

        JButton applyBtn = new JButton("Anwenden");
        applyBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        applyBtn.addActionListener((e)-> {inputPanel.saveToDatabase(); mainWindow.refresh();});
        footerBar.add(applyBtn);

        JButton submitBtn = new JButton("Speichern");
        submitBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        submitBtn.addActionListener((e)-> {inputPanel.saveToDatabase(); dispose(); mainWindow.refresh();});
        footerBar.add(submitBtn);


        add(body);
        this.setVisible(true);
    }
}
