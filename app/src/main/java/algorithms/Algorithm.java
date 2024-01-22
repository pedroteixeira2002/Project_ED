package algorithms;

import collections.lists.OrderedLinkedList;
import game.Bot;
import game.Game;
import game.Location;
import game.Player;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Iterator;

public abstract class Algorithm implements IAlgorithm {
    private NetworkEnhance<Location> map;
    private OrderedLinkedList<Bot> bots;
    private Location opponentFlag;
    private Location myLocation;
    private Game game;

    public Algorithm(Game game) {
        this.map = game.getMap().getGraphMap();
        this.opponentFlag = getOpponent(game).getFlag();
        this.myLocation = getMe(game).getFlag();
        for (Bot bot : getMe(game).getListBots()) {
            this.bots.add(bot);
        }
        this.game = game;
    }

    public NetworkEnhance<Location> getMap() {
        return map;
    }

    public void setMap(NetworkEnhance<Location> map) {
        this.map = map;
    }

    public OrderedLinkedList<Bot> getBots() {
        return bots;
    }

    public void setBots(OrderedLinkedList<Bot> bots) {
        this.bots = bots;
    }

    public Location getOpponentFlag() {
        return opponentFlag;
    }

    public void setOpponentFlag(Location opponentFlag) {
        this.opponentFlag = opponentFlag;
    }

    public Location getMyLocation() {
        return myLocation;
    }

    public void setMyLocation(Location myLocation) {
        this.myLocation = myLocation;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    Player getOpponent(Game game) {
        if (game.getRound() % 2 == 0)
            return game.getPlayer2();
        else return game.getPlayer1();
    }

    Player getMe(Game game) {
        if (game.getRound() % 2 == 0) {
            return game.getPlayer1();
        } else {
            return game.getPlayer2();
        }
    }

    void botInTheWay(NetworkEnhance<Location> map, Iterator<Location> list) {
        for (Bot bot : bots) {
            if (bot.getLocation().equals(list.next())) {
                System.out.println("Bot in the way");
                map.removeVertex(bot.getLocation());
                move(game);
            }
        }
    }
}
