package algorithms;

import collections.lists.OrderedLinkedList;
import game.Bot;
import game.Game;
import game.Location;
import game.Player;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Iterator;

public class ShortestPath implements IAlgorithm {
    private NetworkEnhance<Location> map;
    private OrderedLinkedList<Bot> opponentBots;
    private Location opponentFlag;
    private Location myLocation;

    public ShortestPath(Game game) {
        this.map = game.getMap().getGraphMap();
        this.opponentBots = getOpponent(game).getListBots();
        this.opponentFlag = getOpponent(game).getFlag();
        this.myLocation = getMe(game).getFlag();
    }

    @Override
    public Location move(Game game) {
        NetworkEnhance<Location> tempMap = this.map;

        Iterator<Location> list = tempMap.iteratorShortestPath
                (myLocation, opponentFlag);

        for (Bot opponentBot : this.opponentBots) {
            if (opponentBot.getLocation().equals(list.next())) {
                System.out.println("Bot in the way");
                tempMap.removeVertex(opponentBot.getLocation());
                move(game);

            }
        }

        double shortestPathWeight = tempMap.shortestPathWeight
                (myLocation, opponentFlag);
        System.out.println("Actual Shortest Path Weight: " + shortestPathWeight);


        myLocation = list.next();

        return list.next();
    }
    private Location getMyLocation(Game game) {
        for (Bot bot : getMe(game).getListBots()) {
            if (bot.getAlgorithm() instanceof ShortestPath) {
                return this.myLocation = bot.getLocation();
            }
        }
        return null;
    }

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
    public String toString() {
        return "This Algorithm uses the shortest path to the flag. The bot will use the shortest path to the flag and move there.";
    }
}
