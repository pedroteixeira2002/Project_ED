package game;

import org.checkerframework.common.reflection.qual.NewInstance;

public class Game {
    private Map map;
    private Player player1;
    private Player player2;
    private Location flag1;
    private Location flag2;
    private Player turn;
    private int round;
    public Game(Map map) {
        this.map = map;
        this.player1 = null;
        this.player2 = null;
        this.flag1 = player1.getFlag();
        this.flag2 = player2.getFlag();
        this.turn = player1;
        this.round = 0;
    }
    public Game() {
        this.map = null;
        this.player1 = null;
        this.player2 = null;
        this.flag1 = player1.getFlag();
        this.flag2 = player2.getFlag();
        this.turn = player1;
        this.round = 0;
    }
    public void newGame(){

    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Location getFlag1() {
        return flag1;
    }

    public void setFlag1(Location flag1) {
        this.flag1 = flag1;
    }

    public Location getFlag2() {
        return flag2;
    }

    public void setFlag2(Location flag2) {
        this.flag2 = flag2;
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
