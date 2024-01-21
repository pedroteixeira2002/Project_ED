package algorithms;

import collections.lists.OrderedLinkedList;
import game.*;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Random;

public class RandomPath implements IAlgorithm {
    private NetworkEnhance<Location> graph;
    private OrderedLinkedList<Bot> opponentBots;
    private Location opponentFlag;
    private Location myFlag;

    public RandomPath(Game game) {
        this.graph = game.getMap().getGraphMap();
        this.opponentBots = getOpponent(game).getListBots();
        this.opponentFlag = getOpponent(game).getFlag();
        this.myFlag = getMe(game).getFlag();
    }
/*
    public void move(Bot bot, Map map) {

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
    }
*/

    private Player getOpponent(Game game) {
        if (game.getRound() % 2 == 0)
            return game.getPlayer2();
        else return game.getPlayer1();
    }

    private Player getMe(Game game) {
        if (game.getRound() % 2 == 0) {
            return game.getPlayer1();
        } else {
            return game.getPlayer2();
        }
    }
    @Override
    public Location move() {
        return null;
    }
}
