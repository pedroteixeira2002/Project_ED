package algorithms;

import game.Game;
import game.Location;
import interfaces.IAlgorithm;
import structures.NetworkEnhance;

import java.util.Iterator;

public class BlockEnemyShortestPath extends Algorithm implements IAlgorithm {
    public BlockEnemyShortestPath(Game game) {
        super(game);
    }

    @Override
    public Location move(Game game) {
        NetworkEnhance<Location> tempMap = super.getMap();
        Iterator<Location> list = tempMap.iteratorShortestPath
                (super.getOpponentFlag(), super.getMyLocation());

        botInTheWay(tempMap, list);

        double shortestPathWeight = tempMap.shortestPathWeight
                (super.getOpponentFlag(), super.getMyLocation());
        System.out.println("Actual Enemy Shortest Path Weight : " + shortestPathWeight);

        setMyLocation(list.next());

        return getMyLocation();
    }
}
