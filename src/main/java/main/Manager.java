package main;

import database.DataController;
import database.Database;
import gui.MainWindow;

public class Manager {
    private Database db;

    public Manager(String dbPath) {
        DataController controller = new DataController();
        db = new Database(dbPath, controller);
        new MainWindow(db, controller);
    }


}
