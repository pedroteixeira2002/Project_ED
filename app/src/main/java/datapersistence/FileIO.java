package datapersistence;

import game.ListMap;
import game.Location;
import game.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import scala.util.parsing.json.JSON;
import structures.NetworkEnhance;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class FileIO {
    private static final String directory = "app\\src\\main\\java\\database\\maps.json";

    public FileIO() {

    }

    /**
     * Export the map list to a json file
     */
    public void exportGraphToJSON(ListMap maps) {
        try (FileWriter writer = new FileWriter(directory,true)) {
            JSONArray mapsArray = new JSONArray();

            for (Map map : maps.getAllMaps()) {
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("Map ID:", map.getId());
                jsonMap.put("Vertex Values", map.getGraphMap().getVertices());
                //jsonMap.put("Graph Map", map.getGraphMap().toString()); // Assuming toString() provides the necessary details
                //jsonMap.put("Adjacency Matrix", map.getAdjacencyMatrix());
                //jsonMap.put("Vertex Values", map.getGraphMap().);
                //jsonMap.put("Weights of Edges", map.getGraphMap());
                mapsArray.add(jsonMap);
            }

            // Write the JSON array to the file
            writer.write(mapsArray.toJSONString());
            System.out.println("Exportação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar o grafo para JSON: " + e.getMessage());
        }
    }

    public void exportGraphToJSON2(Map map) {
        try (FileWriter writer = new FileWriter(directory, true)) {

            JSONObject jsonMap = new JSONObject();
            jsonMap.put("Map ID", map.getId());
            jsonMap.put("Graph Map", map.getGraphMap().toString()); // Assuming toString() provides the necessary details

            // Write a new line before appending the new JSON object
            writer.write(System.lineSeparator());

            // Append the new JSON object to the existing file
            JSONValue.writeJSONString(jsonMap, writer);

            System.out.println("Exportação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar o grafo para JSON: " + e.getMessage());
        }
    }



    /**
     * Import the list of maps from a json file
     */
    public ListMap importMapsFromJson(String directory) {
        ListMap maps = new ListMap();
        try (FileReader reader = new FileReader(directory)) {
            JSONArray mapsArray = (JSONArray) JSONValue.parse(reader);

            for (Object mapObject : mapsArray) {
                JSONObject mapJson = (JSONObject) mapObject;
                Map map = parseMap(mapJson);
                maps.addMap(map);
            }

            System.out.println("Importação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao importar a lista de mapas da base de dados: " + e.getMessage());
        }

        return maps;
    }


    /**
     * Parse a JSONObject into a Map object
     *
     * @param mapJson The JSONObject representing a map
     * @return Map object
     */
    private Map parseMap(JSONObject mapJson) {
        Map map = new Map();

        // Set map id
        long mapId = (Long) mapJson.get("id");
        map.setId((int) mapId);

        // Get locations array
        JSONArray locationsArray = (JSONArray) mapJson.get("locations");

        // Add locations to the map
        for (Object locationObject : locationsArray) {
            JSONObject locationJson = (JSONObject) locationObject;
            Location location = parseLocation(locationJson);
            map.getGraphMap().addVertex(location);
        }

        // Get edges array
        JSONArray edgesArray = (JSONArray) mapJson.get("edges");

        // Add edges to the map
        for (Object edgeObject : edgesArray) {
            JSONObject edgeJson = (JSONObject) edgeObject;
            Location from = parseLocation((JSONObject) edgeJson.get("from"));
            Location to = parseLocation((JSONObject) edgeJson.get("to"));
            double weight = (Double) edgeJson.get("weight");

            map.getGraphMap().addEdge(from, to, weight);
        }

        return map;
    }

    /**
     * Parse a JSONObject into a Location object
     *
     * @param locationJson The JSONObject representing a location
     * @return Location object
     */
    private Location parseLocation(JSONObject locationJson) {
        int x = ((Long) locationJson.get("x")).intValue();
        int y = ((Long) locationJson.get("y")).intValue();
        return new Location(x, y);
    }
}
