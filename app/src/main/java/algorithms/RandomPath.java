package algorithms;

import collections.lists.OrderedLinkedList;
import game.Flag;
import game.Location;
import game.Map;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

public class RandomPath implements IAlgorithm {
    private NetworkEnhance<Location> graph;
    private OrderedLinkedList<Flag> flags;
    public RandomPath(Map map) {
        this.graph = map.getGraphMap();
        this.flags = map.getFlagLocations();
    }
    @Override
    public Location move(Map map) {
        return null;
    }
}
