package gui;

import gui.input.*;
import main.Colors;
import main.Kategorie;
import main.Manager;

import javax.swing.*;
import java.awt.*;

public class AddWindow extends JFrame {
    private final Manager manager;

    public AddWindow(Manager manager, Kategorie kategorie) {
        this.manager = manager;
        manager.setAddWindow(this);

        this.setSize(400, 600);
        this.setLocationRelativeTo(manager.getMainWindow());

        JPanel body = new JPanel();
        body.setBackground(Colors.DARK_GREEN);
        body.setLayout(new BorderLayout());

        JLabel titleLbl = new JLabel(kategorie.name() + " erstellen");
        titleLbl.setForeground(Colors.WHITE);
        titleLbl.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        body.add(titleLbl, BorderLayout.NORTH);

        InputPanel inputPanel = switch (kategorie) {
            case PERSON -> new InputPerson(manager);
            case ORCHESTER -> new InputOrchester(manager);
            case KONTO -> new InputKonto(manager);
            case MITGLIED -> new InputMitglied(manager);
            case RECHNUNG -> new InputRechnung(manager);
            default -> throw new IllegalStateException("Unexpected value: " + kategorie);
        };
        body.add(inputPanel, BorderLayout.CENTER);

        JPanel footerBar = new JPanel();
        footerBar.setLayout(new BoxLayout(footerBar, BoxLayout.X_AXIS));
        footerBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        body.add(footerBar, BorderLayout.SOUTH);


        JButton closeBtn = new JButton("Close");
        initMenuButton(closeBtn);
        closeBtn.setBackground(Colors.RED);
        closeBtn.addActionListener((e) -> dispose());
        footerBar.add(closeBtn);

        JButton applyBtn = new JButton("Anwenden");
        initMenuButton(applyBtn);
        applyBtn.setBackground(Colors.DARK_GREEN);
        applyBtn.addActionListener((e) -> {
            inputPanel.saveToDatabase();
            manager.getMainWindow().refresh();
        });
        footerBar.add(applyBtn);

        JButton submitBtn = new JButton("Speichern");
        initMenuButton(submitBtn);
        submitBtn.setBackground(Colors.LIGHT_GREEN);
        submitBtn.addActionListener((e) -> {
            inputPanel.saveToDatabase();
            dispose();
            manager.getMainWindow().refresh();
        });
        footerBar.add(submitBtn);


        add(body);
        this.setVisible(true);
    }

    private void initMenuButton(JButton component) {
        component.setBorder(BorderFactory.createLineBorder(Colors.GREEN, 1));
        component.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        component.setPreferredSize(new Dimension(150, 30));
        component.setForeground(Colors.WHITE);
    }
}
