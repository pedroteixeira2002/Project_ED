package game;

import interfaces.IMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import structures.NetworkEnhance;

import java.util.Random;

public class Map implements IMap, Comparable<Map> {
    private static int nextId = 1;
    private int id;
    private NetworkEnhance<Location> graphMap;

    public Map() {
        this.id = nextId++;
        this.graphMap = new NetworkEnhance<>();
    }


    public NetworkEnhance<Location> getGraphMap() {
        return graphMap;
    }

    /**
     * Get the map
     * @param numLocations
     * @param bidirectional
     * @param edgeDensity
     */
    public Map generateMap(int numLocations, boolean bidirectional, double edgeDensity) {
        // Clear the map and flag locations
        this.graphMap = new NetworkEnhance<>();

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


        while (!graphMap.isConnected()) {
            Location from = getRandomLocation();
            Location to = getRandomLocation();

            if (from != null && to != null && !from.equals(to) && !graphMap.containsEdge(from, to)) {
                double weight = 1 + random.nextInt(15); // Distância aleatória entre 1 e 15 quilômetros (peso da aresta)

                graphMap.addEdge(from, to, weight);

                if (bidirectional) {
                    // If bidirectional, add the edge in the opposite direction
                    graphMap.addEdge(to, from, weight);
                }
            }
        }

        // Verifica se o grafo se tornou conexo após o loop
        if (graphMap.isConnected()) {
            System.out.println("O grafo é conexo!");
        } else {
            System.out.println("O grafo não é conexo!");
        }

        /*
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
        */

        // Atualize esta linha para armazenar o ID do mapa
        System.out.println("Mapa gerado com ID: " + this.id);


        // Return the generated map
        return this;
    }


    /**
     * Get the map id
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        String str = "\nMap Id: " + this.id + ":\n";
        str += this.graphMap.toString() + "\n";

        /*
        str += "Locais:\n";
        for (int i = 0; i < this.graphMap.size(); i++) {
            str += "\t" + this.graphMap.getVertex(i) + "\n";
        }
        */
        return str;
    }

    @Override
    public int compareTo(Map o) {
        return this.id - o.id;
    }

}
