package game;

import collections.lists.OrderedLinkedList;
import interfaces.IPlayer;

public class Player implements IPlayer {
    private static int nextId = 0;
    private int id;
    private String name;
    private OrderedLinkedList<Bot> bots;

    public Player(String name) {
        this.id = nextId++;
        this.name = name;
        this.bots = new OrderedLinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderedLinkedList<Bot> getBots() {
        return bots;
    }
}
