package game;

import collections.lists.OrderedLinkedList;
import interfaces.IPlayer;

public class Player implements IPlayer {
    private static int nextId = 0;
    private int id;
    private String name;
    private OrderedLinkedList<Bot> listBots;
    private Location currentLocation;
    private Location flag;
    private int iterationCount; // Iteration count for the player

    public Player(String name) {
        this.id = nextId++;
        this.name = name;
        this.listBots = new OrderedLinkedList<>();
        this.flag = null;
        this.iterationCount = 0;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Location getFlag() {
        return flag;
    }

    public void setFlag(Location flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public void resetIterationCount() {
        iterationCount = 0;
    }

    public void incrementIterationCount() {
        iterationCount++;
    }

    public OrderedLinkedList<Bot> getListBots() {
        return listBots;
    }


    public void setListBots(OrderedLinkedList<Bot> listBots) {
        this.listBots = listBots;
    }
}
