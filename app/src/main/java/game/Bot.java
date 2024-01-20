package game;

import interfaces.IBot;

public class Bot implements IBot {
    private static int nextId = 0;
    private int id;
    private Location location;
    private Algorithms algorithms;

    public Bot(Location location, Algorithms algorithms) {
        this.id = nextId++;
        this.location = location;
        this.algorithms = algorithms;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Algorithms getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(Algorithms algorithms) {
        this.algorithms = algorithms;
    }

    @Override
    public String toString() {
        return "\nBot:" +
                "\nID: " + id +
                "\nStart Location: " + location +
                "\nAlgorithms this bot uses: " + algorithms.toString();
    }
}
