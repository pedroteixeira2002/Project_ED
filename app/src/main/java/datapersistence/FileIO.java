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
     * Export the map to a json file
     *
     */
    public void exportGraphToJSON(ListMap maps) {
        try (FileWriter writer = new FileWriter(directory)) {
            JSONArray mapsArray = new JSONArray();

            for (Map map : maps.getAllMaps()) {
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("Map ID", map.getId());
                jsonMap.put("Graph Map", map.getGraphMap().toString()); // Assuming toString() provides the necessary details
                mapsArray.add(jsonMap);
            }

            JSONValue.writeJSONString(maps, writer);
            System.out.println("Exportação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar o grafo para JSON: " + e.getMessage());
        }
    }


    /**
     * Import the map from a json file by map id
     * @param mapId ID of the map to import
     * @param maps ListMap to add the imported map
     */
    /*
    public void importMapFromJson(int mapId, ListMap maps) {
        try (FileReader reader = new FileReader(directory)) {
            JSONArray mapsArray = (JSONArray) JSONValue.parse(reader);

            for (Object map : mapsArray) {
                JSONObject jsonMap = (JSONObject) map;
                long jsonMapId = (long) jsonMap.get("Map ID");

                if (jsonMapId == mapId) {
                    Map parsedMap = Map.parseGraphFromJSON((JSONArray) jsonMap.get("Graph Map"));
                    maps.addMap(parsedMap);
                    System.out.println("Mapa com o ID " + mapId + " importado com sucesso.");
                    return;
                }
            }

            System.out.println("Mapa com o ID " + mapId + " não encontrado no arquivo JSON.");
        } catch (IOException e) {
            System.err.println("Erro ao importar o grafo da base de dados: " + e.getMessage());
        }
     */
}
