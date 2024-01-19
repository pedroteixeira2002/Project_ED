package game;

import collections.graphs.Network;
import collections.lists.UnorderedLinkedList;


import java.util.Random;

public class Map {
    private Network<Location> graphMap;
    private UnorderedLinkedList<Location> flagLocations;

    public Map() {
        this.graphMap = new Network<>();
        this.flagLocations = new UnorderedLinkedList<>();
    }

    public void generateMap(int numLocations, boolean bidirectional, double edgeDensity) {
        // Clear the map and flag locations
        this.graphMap = new Network<>();
        this.flagLocations = new UnorderedLinkedList<>();

        // Generate the locations in the map
        for (int i = 0; i < numLocations; i++) {
            int x = (int) (Math.random() * 100); // Give random coordinates between 0 and 100
            int y = (int) (Math.random() * 100); // Give random coordinates between 0 and 100
            Location location = new Location(x,y);
            this.graphMap.addVertex(location);
        }

        // Connect locations based on edge density
        int maxEdges = (int) (numLocations * (numLocations - 1) * edgeDensity);
        Random random = new Random();

        for (int i = 0; i < maxEdges; i++) {
            Location from = getRandomLocation();
            Location to = getRandomLocation();

            if (from != null && to != null && !from.equals(to)) {
                double weight = 1 + random.nextInt(15); // Distância aleatória entre 1 e 15 quilômetros

                graphMap.addEdge(from, to, weight);

                if (bidirectional) {
                    // Se bidirecional, adicionar a aresta no sentido inverso
                    graphMap.addEdge(to, from, weight);
                }
            }
        }
    }

    // Method to get a random location in the map
    private Location getRandomLocation() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.graphMap.size());

        //return this.graphMap.getVertex(randomIndex);
        return null;
    }
}
