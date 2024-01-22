package algorithms;

import game.Game;
import game.Location;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

public class LongestPath extends Algorithm implements IAlgorithm {
    public LongestPath(Game game) {
        super(game);
    }
    @Override
    public Location move(Game game) {
        NetworkEnhance<Location> tempMap = super.getMap();
    }
    private Location findLongestPath(Game game, NetworkEnhance<Location> map) {
        double longestPath = 0;
        if (map.shortestPathWeight(super.getMyLocation(), getOpponent(game).getFlag()) >= longestPath)
            longestPath = map.shortestPathWeight
                    (super.getMyLocation(), getOpponent(game).getFlag());
        System.out.println("Actual Shortest Path Weight: " + longestPath);

    }


}
