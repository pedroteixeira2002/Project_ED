package algorithms;

import game.Game;
import game.Location;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Iterator;

public class ShortestPath extends Algorithm implements IAlgorithm {

    public ShortestPath(Game game) {
        super(game);
    }

    @Override
    public Location move(Game game) {
        NetworkEnhance<Location> tempMap = super.getMap();
        Iterator<Location> list = tempMap.iteratorShortestPath
                (super.getMyLocation(), super.getOpponentFlag());

        botInTheWay(tempMap, list);

        double shortestPathWeight = tempMap.shortestPathWeight
                (super.getMyLocation(), super.getOpponentFlag());
        System.out.println("Actual Shortest Path Weight: " + shortestPathWeight);

        setMyLocation(list.next());

        return getMyLocation();
    }

    @Override
    public String toString() {
        return "This Algorithm uses the shortest path to the flag. " +
                "The bot will use the shortest path to the flag and move there.";
    }
}
