package game;

import algorithms.RandomPath;
import interfaces.IAlgorithm;
import interfaces.IBot;

public class Bot implements IBot {
    private static int nextId = 0;
    private int id;
    private Location location;
    private IAlgorithm algorithm;
    private Player owner;

    public Bot(Location location, IAlgorithm algorithm, Player owner) {
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

    public IAlgorithm getAlgorithm() {
        return algorithm;
    }

    public IAlgorithm setAlgorithm(int choice, Map map) {
        switch (choice) {
            case 1:
                return algorithm = new RandomPath(map);

            case 2:
                //return algorithm = new Algorithm.MoveByLongestPath(map);

            case 3:
                //return algorithm = new Algorithm.MoveToBlock(map);

            default:
                //return algorithm = new Algorithm.MoveByShortestPath(map);
                return null;
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
