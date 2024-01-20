package algorithms;

import collections.graphs.Network;
import game.Bot;
import game.Location;
import game.Map;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Random;

public class RandomPath implements IAlgorithm {

    private Map map;
    public RandomPath(Map map) {
        this.map = map;
    }

    public void move(Bot bot, Map map) {
        /*
        // Implementação do movimento aleatório
        Random random = new Random();
        Location currentLocation = bot.getLocation();

        // Obtém os vizinhos da localização atual do bot
        var neighbors = map.getGraphMap().getNeighbors(currentLocation);

        if (!neighbors.isEmpty()) {
            // Escolhe aleatoriamente um vizinho para se mover
            Location randomNeighbor = neighbors.remove(random.nextInt(neighbors.size()));
            bot.setLocation(randomNeighbor);
        }
        */
    }


    @Override
    public Location move(Map map) {
        return null;
    }
}
