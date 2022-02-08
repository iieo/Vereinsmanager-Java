package gui;

import javax.swing.*;

public class SelectButton extends JButton {
    private int ID;

    public SelectButton(String text){
        super(text);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID, String value) {
        setText("Selected: " + value + " # " + ID);
        this.ID = ID;
    }
}
