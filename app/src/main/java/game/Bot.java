package game;

import algorithms.Algorithm;
import interfaces.IBot;

public class Bot implements IBot {
    private static int nextId = 0;
    private int id;
    private Location location;
    private Algorithm algorithm;

    public Bot(Location location, Algorithm algorithm) {
        this.id = nextId++;
        this.location = location;
        this.algorithm = algorithm;
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

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public Algorithm setAlgorithm(int choice) {
        switch (choice) {
            case 1:
                return algorithm = new Algorithm.MoveByRandomPath();

            case 2:
                return algorithm = new Algorithm.MoveByLongestPath();

            case 3:
                return algorithm = new Algorithm.MoveToBlock();

            default:
                return algorithm = new Algorithm.MoveByShortestPath();
        }
    }

    @Override
    public String toString() {
        return "\nBot:" +
                "\nID: " + id +
                "\nStart Location: " + location +
                "\nAlgorithms this bot uses: " + algorithm.toString();
    }
}
