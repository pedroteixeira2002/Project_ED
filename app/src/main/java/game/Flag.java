package game;

import interfaces.IFlag;

public class Flag implements IFlag {
    /** Location of the flag */
    private Location location;
    /** Owner of the flag */
    private  Player onwer;

    public Flag(Location location, Player onwer) {
        this.location = location;
        this.onwer = onwer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player getOnwer() {
        return onwer;
    }

    public void setOnwer(Player onwer) {
        this.onwer = onwer;
    }
}
