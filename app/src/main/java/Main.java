import collections.graphs.Network;
import game.Map;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class Main {
    public static void main(String[] args) {
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

        // Visualize o grafo
        Viewer viewer = graph.display();
         */

        Map gameMap = new Map();

    }
}
