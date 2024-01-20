package game;

import collections.lists.OrderedLinkedList;
import interfaces.IPlayer;

public class Player implements IPlayer {
    private static int nextId = 0;
    private int id;
    private String name;
    private OrderedLinkedList<Bot> listBots;
    private Location flag;

    public Player(String name) {
        this.id = nextId++;
        this.name = name;
        this.listBots = new OrderedLinkedList<>();
        this.flag = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OrderedLinkedList<Bot> getListBots() {
        return listBots;
    }

    public Location getFlag() {
        return flag;
    }
}
