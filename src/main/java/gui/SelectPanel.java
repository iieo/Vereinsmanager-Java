package gui;

import main.Colors;
import main.Manager;
import models.Model;

import javax.swing.*;
import java.awt.*;

public class SelectPanel extends JFrame {
    public SelectPanel(SelectButton selectButton, Model[] data, Manager manager) {
        JList<Model> listComp = new JList<>();
        listComp.setListData(data);

        this.setSize(400, 600);
        this.setLocationRelativeTo(manager.getAddWindow());

        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(listComp);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        listComp.setBackground(Colors.BLACK);
        listComp.setForeground(Colors.WHITE);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(Colors.DARK_GREEN);
        submitBtn.setForeground(Colors.WHITE);
        submitBtn.addActionListener(e -> {
            selectButton.setID(listComp.getSelectedValue().getID(), listComp.getSelectedValue().toString());
            dispose();
        });
        add(submitBtn, BorderLayout.SOUTH);


        setVisible(true);
    }

}
