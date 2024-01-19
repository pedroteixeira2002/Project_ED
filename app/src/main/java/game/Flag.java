package game;

import interfaces.IFlag;

public class Flag implements IFlag {
    /** Location of the flag */
    private Location location;
    /** Owner of the flag */
    private  Player owner;

    public Flag(Location location, Player owner) {
        this.location = location;
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
