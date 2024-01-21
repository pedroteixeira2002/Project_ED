package algorithms;

import collections.lists.OrderedLinkedList;
import game.*;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

public class BlockPath implements IAlgorithm {
    private NetworkEnhance<Location> graph;
    private OrderedLinkedList<Bot> opponentBots;
    private Location opponentFlag;
    private Location myFlag;
    public BlockPath(Game game) {
        this.graph = game.getMap().getGraphMap();
        this.opponentBots = getOpponent(game).getListBots();
        this.opponentFlag = getOpponent(game).getFlag();
        this.myFlag = getMe(game).getFlag();
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
    public Location move() {
        return null;
    }
    @Override
    public String toString() {
        return "\nThis Algorithm tries to block the closest opponent bot. " +
                "The bot will pursuit the opponent bot the whole game. " +
                "The purpose of this bot is not to achieve the flag.";
    }
}
