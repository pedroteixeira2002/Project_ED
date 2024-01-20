package game;

public class Game {
    private Map map;
    private Player player1;
    private Player player2;
    private Flag flag1;
    private Flag flag2;
    private Player turn;
    private int round;

    public Game(Map map, Player player1, Player player2, Flag flag1, Flag flag2, Player turn, int round) {
        this.map = map;
        this.player1 = player1;
        this.player2 = player2;
        this.flag1 = flag1;
        this.flag2 = flag2;
        this.turn = turn;
        this.round = round;
    }

    public Game() {

    }
}
