package main;

import database.DataController;
import database.Database;
import gui.AddWindow;
import gui.MainWindow;

public class Manager {
    private Database db;
    private DataController controller;
    private MainWindow mainWindow;
    private AddWindow addWindow;

    public Manager(String dbPath) {
        controller = new DataController();
        db = new Database(dbPath, this);
        new MainWindow(this);
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public DataController getController() {
        return controller;
    }

    public void setController(DataController controller) {
        this.controller = controller;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public AddWindow getAddWindow() {
        return addWindow;
    }

    public void setAddWindow(AddWindow addWindow) {
        this.addWindow = addWindow;
    }
}
