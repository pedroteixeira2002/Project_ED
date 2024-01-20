package game;

import collections.lists.OrderedLinkedList;
import interfaces.IMap;
import structures.NetworkEnhance;


import java.util.Random;

public class Map implements IMap {
    private NetworkEnhance<Location> graphMap;
    private OrderedLinkedList<Location> flagLocations;

    public Map() {
        this.graphMap = new NetworkEnhance<>();
        this.flagLocations = new OrderedLinkedList<>();
    }

    /**
     * Get the map
     * @param numLocations
     * @param bidirectional
     * @param edgeDensity
     */
    public void generateMap(int numLocations, boolean bidirectional, double edgeDensity) {
        // Clear the map and flag locations
        this.graphMap = new NetworkEnhance<>();
        this.flagLocations = new OrderedLinkedList<>();


        // Check if edgeDensity is in the correct range
        if (edgeDensity < 0.01 || edgeDensity > 1.00) {
            throw new IllegalArgumentException("A densidade de arestas deve estar no intervalo de 0.01 a 1.00");
        }


        // Generate the locations(vertices) in the map
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
                double weight = 1 + random.nextInt(15); // Distância aleatória entre 1 e 15 quilômetros (peso da aresta)

                graphMap.addEdge(from, to, weight);

                if (bidirectional) {  // SAME AS: if (bidirectional == true)
                    // If bidirectional, add the edge in the opposite direction
                    graphMap.addEdge(to, from, weight);
                }
            }
        }
    }

    /**
     * Get a random location in the map
     * @return a random location in the map
     */
    private Location getRandomLocation() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.graphMap.size());

        return this.graphMap.getVertex(randomIndex);

    }
}
