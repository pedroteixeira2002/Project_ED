package game;

import algorithms.BlockPath;
import algorithms.LongestPath;
import algorithms.RandomPath;
import algorithms.ShortestPath;
import interfaces.IAlgorithm;
import interfaces.IBot;

public class Bot implements IBot {
    private static int nextId = 0;
    private int id;
    private Flag flag;
    private Location location;
    private IAlgorithm algorithm;
    private Player owner;

    public Bot(IAlgorithm algorithm, Flag flag) {
        this.id = nextId++;
        this.location = flag.getLocation();
        this.algorithm = algorithm;
        this.owner = flag.getOwner();
        this.flag = flag;
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
                return algorithm = new LongestPath(map);
            case 3:
                return algorithm = new BlockPath(map);
            default:
                return algorithm = new ShortestPath(map);

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
