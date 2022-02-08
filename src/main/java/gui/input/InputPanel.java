package gui.input;

import database.DataController;
import gui.SelectButton;
import gui.SelectPanel;
import main.Colors;
import main.Kategorie;
import main.Manager;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public abstract class InputPanel extends JScrollPane {

    protected JPanel body;
    protected Manager manager;

    public InputPanel(Manager manager) {
        super();
        this.manager = manager;
        getVerticalScrollBar().setUnitIncrement(20);
        body = new JPanel();
        body.setBackground(Colors.BLACK);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(body);
    }

    protected JTextField addTextInput(String text) {
        body.add(createTitleText(text));
        JTextField component = new JTextField();
        initComponent(component);
        body.add(component);
        return component;
    }

    private void initComponent(Component component) {
        component.setBackground(Colors.GREEN);
        component.setForeground(Colors.WHITE);
        component.setMinimumSize(new Dimension(10, 25));
        component.setPreferredSize(new Dimension(300, 25));
        component.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        if (component instanceof JSpinner spinner) {
            spinner.getEditor().getComponent(0).setBackground(Colors.GREEN);
            spinner.getEditor().getComponent(0).setForeground(Colors.WHITE);
        }
    }

    protected JSpinner addNumberInput(String text) {
        body.add(createTitleText(text));
        JSpinner component = new JSpinner(new SpinnerNumberModel());
        initComponent(component);
        body.add(component);
        return component;
    }

    private JLabel createTitleText(String text) {
        JLabel title = new JLabel(text);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        title.setForeground(Colors.WHITE);
        return title;
    }

    protected JSpinner addDateInput(String text) {
        body.add(createTitleText(text));
        JSpinner component = new JSpinner(new SpinnerDateModel());
        initComponent(component);
        body.add(component);
        return component;
    }

    protected SelectButton addSelectIDInput(Kategorie kategorie) {
        DataController controller = manager.getController();
        Model[] list = switch (kategorie) {
            case PERSON -> controller.getPersonen().toArray(new Person[0]);
            case KONTO -> controller.getKonten().toArray(new Konto[0]);
            case MITGLIED -> controller.getMitglieder().toArray(new Mitglied[0]);
            case RECHNUNG -> controller.getRechnungen().toArray(new Rechnung[0]);
            case ORCHESTER -> controller.getOrchesterMitglieder().toArray(new Orchester[0]);
        };
        SelectButton component = new SelectButton(kategorie.name() + " ID");
        component.setBackground(Colors.GREEN);
        component.setForeground(Colors.WHITE);
        component.addActionListener((e) -> new SelectPanel(component, list, manager));
        body.add(component);
        return component;
    }

    public abstract void saveToDatabase();


    protected Date getDate(JTextField txtField) {
        String text = txtField.getText();
        if (!isValidInput(text)) {
            return null;
        }
        Integer[] dateInfos = Arrays.stream(Objects.requireNonNull(text).split("\\.")).map(Integer::parseInt).toList().toArray(new Integer[0]);
        return new Date(dateInfos[0], dateInfos[1], dateInfos[2]);
    }

    protected boolean isValidInput(String text) {
        return text != null && text.trim().length() > 0 && !text.isBlank();
    }


}
