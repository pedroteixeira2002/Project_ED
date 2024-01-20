package algorithms;

import collections.lists.OrderedLinkedList;
import game.Flag;
import game.Location;
import game.Map;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

public class Algorithm implements IAlgorithm {
    protected NetworkEnhance<Location> graph;
    protected OrderedLinkedList<Flag> flags;

    public Algorithm(Map map) {
        this.graph = map.getGraphMap();
        this.flags = map.getFlagLocations();
    }

    public void move() {
        System.out.println("move");
    }

    public static class MoveByShortestPath extends Algorithm {

        public MoveByShortestPath(Map map) {
            super(map);
        }
        public void move(Map map) {
            int shortestPathLength = this.graph.shortestPathLength
                    (this.flags.head.getElement().getLocation(), this.flags.tail.getElement().getLocation());

            this.graph.iteratorShortestPath
                    (this.flags.head.getElement().getLocation(), this.flags.tail.getElement().getLocation());


        }

        @Override
        public String toString() {
            return "This Algorithm uses the shortest path to the flag. The bot will use the shortest path to the flag and move there.";
        }
    }

    public static class MoveByRandomPath extends Algorithm {
        public MoveByRandomPath(Map map) {
            super(map);
        }

        public void move() {
            System.out.println("moveByRandomPath");
        }

        @Override
        public String toString() {
            return "This Algorithm uses uses a random path. The bot will wander around the map.";
        }
    }

    public static class MoveByLongestPath extends Algorithm {
        public MoveByLongestPath(Map map) {
            super(map);
        }

        public void move() {
            System.out.println("MoveByLongestPath");
        }

        @Override
        public String toString() {
            return "This Algorithm uses the longest path to the flag. The bot will use the longest path to the flag and move there.";
        }
    }

    public static class MoveToBlock extends Algorithm {
        public MoveToBlock(Map map) {
            super(map);
        }

        public void move() {
            System.out.println("moveToBlock");
        }

        @Override
        public String toString() {
            return "This Algorithm will search for a strategic block. The bot will move to a vertex that will block the enemy from reaching the flag.";
        }
    }
}