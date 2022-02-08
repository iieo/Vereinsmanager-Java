package models;

public abstract class Model {
    protected final int ID;

    public Model(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

}
