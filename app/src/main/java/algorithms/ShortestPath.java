package algorithms;

import collections.lists.OrderedLinkedList;
import game.Flag;
import game.Location;
import game.Map;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Iterator;

public class ShortestPath implements IAlgorithm {
    private NetworkEnhance<Location> graph;
    private OrderedLinkedList<Flag> flags;

    public ShortestPath(Map map) {
        this.graph = map.getGraphMap();
        this.flags = map.getFlagLocations();
    }

    @Override
    public Location move(Map map) {

        double shortestPathWeight = this.graph.shortestPathWeight
                (this.flags.head.getElement().getLocation(), this.flags.tail.getElement().getLocation());

        Iterator<Location> list = this.graph.iteratorShortestPath
                (this.flags.head.getElement().getLocation(), this.flags.tail.getElement().getLocation());
        System.out.println("Actual Shortest Path Weight: " + shortestPathWeight);
        return list.next();
    }

    @Override
    public String toString() {
        return "This Algorithm uses the shortest path to the flag. The bot will use the shortest path to the flag and move there.";
    }
}
