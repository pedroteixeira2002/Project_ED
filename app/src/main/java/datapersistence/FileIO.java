package datapersistence;

import game.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import structures.NetworkEnhance;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class FileIO {
    private static final String directory = "app/maps/maps.json";

    public FileIO() {

    }

    /**
     * Export the map to a json file
     * @param graph
     */
    public void exportGraphToJSON(NetworkEnhance<Location> graph) {
        try (FileWriter writer = new FileWriter(directory)) {
            JSONObject jsonGraph = new JSONObject();

            // Export vertices
            JSONArray vertices = new JSONArray();
            Iterator<Location> vertexIterator = graph.iteratorDFS(graph.getVertex(0));
            while (vertexIterator.hasNext()) {
                Location current = vertexIterator.next();
                JSONObject vertex = new JSONObject();
                vertex.put("posX", current.getPosX());
                vertex.put("posY", current.getPosY());
                vertices.add(vertex);
            }
            jsonGraph.put("vertices", vertices);

            /*
            // Export edges
            JSONArray edges = new JSONArray();
            vertexIterator = graph.iteratorDFS(graph.getVertex(0));
            while (vertexIterator.hasNext()) {
                Location current = vertexIterator.next();
                Iterator<Location> neighborIterator = Arrays.stream(graph.getNeighbors(current)).iterator();
                while (neighborIterator.hasNext()) {
                    Location neighbor = neighborIterator.next();
                    JSONObject edge = new JSONObject();
                    edge.put("source", current.getId());
                    edge.put("target", neighbor.getId());
                    edges.add(edge);
                }
            }

            jsonGraph.put("edges", edges);
            */
            JSONValue.writeJSONString(jsonGraph, writer);
            System.out.println("Exportação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar o grafo para JSON: " + e.getMessage());
        }
    }


    public void importMapFromJson(int mapId) {
        return;
    }
}
