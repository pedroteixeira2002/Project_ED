package algorithms;

public abstract class Algorithm {
    public static class MoveByShortestPath extends Algorithm {

        public void move() {
            System.out.println("MoveByShortestPath");
        }

        @Override
        public String toString() {
            return "This Algorithm uses the shortest path to the flag. The bot will use the shortest path to the flag and move there.";
        }
    }

    public static class MoveByRandomPath extends Algorithm {
        public void move() {
            System.out.println("moveByRandomPath");
        }

        @Override
        public String toString() {
            return "This Algorithm uses uses a random path. The bot will wander around the map.";
        }
    }

    public static class MoveByLongestPath extends Algorithm {
        public void move() {
            System.out.println("MoveByLongestPath");
        }

        @Override
        public String toString() {
            return "This Algorithm uses the longest path to the flag. The bot will use the longest path to the flag and move there.";
        }
    }

    public static class MoveToBlock extends Algorithm {
        public void move() {
            System.out.println("moveToBlock");
        }

        @Override
        public String toString() {
            return "This Algorithm will search for a strategic block. The bot will move to a vertex that will block the enemy from reaching the flag.";
        }
    }
}