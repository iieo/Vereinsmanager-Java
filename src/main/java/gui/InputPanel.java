package gui;

import database.Database;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public abstract class InputPanel extends JScrollPane {

    protected JPanel body;
    protected Database db;
    public InputPanel(Database db){
        super();
        this.db = db;
        body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(body);
    }

    protected JTextField addTextInput(String text){
        body.add(new JLabel(text));
        JTextField component = new JTextField();
        body.add(component);
        return component;
    }

    protected JSpinner addNumberInput(String text){
        body.add(new JLabel(text));
        JSpinner component = new JSpinner(new SpinnerNumberModel());
        body.add(component);
        return component;
    }
    protected JSpinner addDateInput(String text){
        body.add(new JLabel(text));
        JSpinner component = new JSpinner(new SpinnerDateModel());
        body.add(component);
        return component;
    }

    public abstract void saveToDatabase();

    private int getNumber(JSpinner spinner) {
        String text = (String) spinner.getValue();
        if (!isValidInput(text)) {
            return -1;
        }
        return Integer.parseInt(Objects.requireNonNull(text).trim());
    }

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
