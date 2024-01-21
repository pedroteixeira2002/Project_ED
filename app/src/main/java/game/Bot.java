package game;

import algorithms.BlockPath;
import algorithms.RandomPath;
import algorithms.ShortestPath;
import interfaces.IAlgorithm;
import interfaces.IBot;

public class Bot implements IBot {
    private static int nextId = 0;
    private int id;
    private IAlgorithm algorithm;
    private Location location;
    private Player owner;

    public Bot(IAlgorithm algorithm, Game game) {
        this.id = nextId++;
        this.owner = getMe(game);
        this.algorithm = algorithm;
    }

    public Player getOwner() {
        return owner;
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


    public IAlgorithm setAlgorithm(int choice, Game game) {
        switch (choice) {
            case 1:
                return algorithm = new RandomPath(game);
            case 3:
                return algorithm = new BlockPath(game);
            default:
                return algorithm = new ShortestPath(game);

        }
    }

    private Player getMe(Game game) {
        if (game.getRound() % 2 == 0) {
            return game.getPlayer1();
        } else {
            return game.getPlayer2();
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
