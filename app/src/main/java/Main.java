import datapersistence.FileIO;
import game.ListMap;
import game.Map;
import menu.Menu;
import menu.ReadInfo;
import menu.Tools;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ListMap listMap = new ListMap();

        Map gameMap1 = new Map();
        listMap.addMap(gameMap1);
        Map gameMap2 = new Map();
        listMap.addMap(gameMap2);
        Map gameMap3 = new Map();
        listMap.addMap(gameMap3);
        Map gameMap4 = new Map();
        listMap.addMap(gameMap4);
        Map gameMap5 = new Map();
        listMap.addMap(gameMap5);

        gameMap1.generateMap(1, true, 0.5);
        gameMap2.generateMap(15, true, 0.7);
        gameMap3.generateMap(10, false, 0.9);
        gameMap4.generateMap(5, false, 0.9);
        gameMap5.generateMap(5, false, 0.9);

        Map gameMap6 = new Map();
        gameMap6.generateMap(3, false, 0.7);
        listMap.addMap(gameMap6);

        FileIO.exportToJSON(listMap);
        listMap = FileIO.importFromJson();

        for (Map map : listMap.getAllMaps()) {
            System.out.println(map);
        }

        //fileIO.importMapsFromJson("src\\main\\java\\database\\maps.json");


        /*
        Network<String> graph = new Network<String>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 3);
        graph.addEdge("C", "D", 4);

        System.out.println(graph);
 */
        /*
        // Defina a propriedade do sistema para o pacote de UI adequado
        System.setProperty("org.graphstream.ui", "javafx");

        // Crie um grafo simples
        Graph graph = new SingleGraph("MeuGrafo");

        // Adicione alguns nós e arestas
        graph.addNode("A").setAttribute("ui.label", "A");
        graph.addNode("B").setAttribute("ui.label", "B");
        graph.addNode("C").setAttribute("ui.label", "C");
        graph.addNode("D").setAttribute("ui.label", "D");
        graph.addNode("E").setAttribute("ui.label", "E");
        graph.addNode("F").setAttribute("ui.label", "F");
        graph.addEdge("AB", "A", "B").setAttribute("ui.label", "AB");
        graph.addEdge("BC", "B", "C").setAttribute("ui.label", "BC");
        graph.addEdge("CA", "C", "A").setAttribute("ui.label", "CA");
        graph.addEdge("CD", "C", "D").setAttribute("ui.label", "CD");
        graph.addEdge("DE", "D", "E").setAttribute("ui.label", "DE");
        graph.addEdge("EF", "E", "F").setAttribute("ui.label", "EF");
        graph.addEdge("FA", "F", "A").setAttribute("ui.label", "FA");
         */
    }
}