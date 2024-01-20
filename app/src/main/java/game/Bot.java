package game;

import algorithms.Algorithm;
import interfaces.IBot;

public class Bot implements IBot {
    private static int nextId = 0;
    private int id;
    private Location location;
    private Algorithm algorithm;
    private Player owner;

    public Bot(Location location, Algorithm algorithm, Player owner) {
        this.id = nextId++;
        this.location = location;
        this.algorithm = algorithm;
        this.owner = owner;
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

    public Algorithm setAlgorithm(int choice, Map map) {
        switch (choice) {
            case 1:
                return algorithm = new Algorithm.MoveByRandomPath(map);

            case 2:
                return algorithm = new Algorithm.MoveByLongestPath(map);

            case 3:
                return algorithm = new Algorithm.MoveToBlock(map);

            default:
                return algorithm = new Algorithm.MoveByShortestPath(map);
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
