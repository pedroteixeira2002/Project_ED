package game;

import collections.lists.OrderedLinkedList;
import interfaces.IPlayer;

public class Player implements IPlayer {
    private static int nextId = 0;
    private int id;
    private String name;
    private OrderedLinkedList<Bot> listBots;

    public Player(String name) {
        this.id = nextId++;
        this.name = name;
        this.listBots = new OrderedLinkedList<>();
    }

 }
