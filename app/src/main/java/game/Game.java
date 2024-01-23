package game;

import java.util.Random;

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

    /**
     * Start a new game, setting the turn to any player and the round to 1
     */
    public Player newGame(){

        verify();
        return null;
    }
    public void verify(){
        // Lógica para configurar os jogadores, bandeiras, etc.
        Random random = new Random();
        // Gera um número aleatório (0 ou 1) para decidir qual jogador começa
        int randomPlayer = random.nextInt(2);

        if (randomPlayer == 0) {
            this.turn = player1;
        } else {
            this.turn = player2;
        }

        this.round = 1; // Inicia na rodada 1
    }

    /**
     * Makes a move, moving the current player's bot to a new location.
     * After the move, updates the turn, round and verify if all bots about player .
     * @param movingbot The bot being moved. (que está sendo movido)
     * @param newLocation New location for the bot
     */
    public void makeMove(Bot movingbot, Location newLocation){
        // Move o bot para a nova localização se o movimento for válido
        movingbot.getAlgorithm().move(this);
        // Verifica se a jogada resultou na vitória
        if (checkVictoryCondition(turn, turn == player1 ? player2 : player1)){ // Verifica se o jogador atual é um dos
            // jogadores e retorna o outro jogador
            System.out.println("Vitória do jogador " + turn.getName());
        } else {
            // Incrementa o contador de iteração do jogador atual
            turn.incrementIterationCount();

            // Verifica se todos os bots do jogador atual foram usados
            if (turn.getIterationCount() >= turn.getListBots().size()) {
                // Reinicia o contador de iteração e passa o turno para o próximo jogador
                turn.resetIterationCount();
                switchTurn();
            } else {
                // Passa o turno para o próximo jogador
                switchTurn();
            }
            // Incrementa o número da rodada
            round++;
        }
    }


    /**
     * This method checks if the victory condition is met
     * @return true if the victory condition is met, false otherwise
     */
    private boolean checkVictoryCondition(Player currentPlayer, Player opponentPlayer) {
        // Itera sobre os bots do jogador adversário
        for (Bot opponentBot : opponentPlayer.getListBots()) {
            // Verifica se a localização do bot adversário é igual à localização da bandeira do jogador atual
            if (opponentBot.getLocation().equals(currentPlayer.getFlag())) {
                System.out.println(opponentPlayer.getName()
                        + "'s bot alcançou a bandeira de " + currentPlayer.getName() + ". "
                        + currentPlayer.getName() + " perdeu!");
                return true; // Condição de vitória atingida
            }
        }

        // Condição de vitória não atingida
        return false;
    }

    /**
     * This method changes the turn to the next player
     */
    private void switchTurn() {
        if (turn == player1) {
            turn = player2;
        } else {
            turn = player1;
        }
    }

    ///////////// Verificar/////////////////////

    /**
     * This method checks if two locations are the same
      * @param location1
     * @param location2
     * @return
     */
    public boolean checkCollision(Location location1, Location location2) {
        return location1.equals(location2);
    }

    /**
     * This method checks if the new location is valid and moves the bot
     * otheriwise
     * @param bot
     * @param newLocation
     */
    public void moveBot(Bot bot, Location newLocation) {
        // Verifica se a nova localização é válida
        if (isValidMove(bot, newLocation)) {
            bot.setLocation(newLocation);
        } else {
            // Lógica para lidar com a tentativa de movimento inválido
            System.out.println("Movimento inválido, escolha uma nova localização.");
        }
    }

    private boolean isValidMove(Bot movingBot, Location newLocation) {
        // Verifica colisão com outros bots
        for (Bot bot : player1.getListBots()) {
            if (checkCollision(newLocation, bot.getLocation()) && !newLocation.equals(bot.getOwner().getFlag())) {
                return false; // Movimento inválido, colisão com outro bot
            }
        }

        for (Bot bot : player2.getListBots()) {
            if (checkCollision(newLocation, bot.getLocation()) && !newLocation.equals(bot.getOwner().getFlag())) {
                return false; // Movimento inválido, colisão com outro bot
            }
        }

        // Adicione qualquer outra lógica necessária para validar o movimento

        return true; // Movimento válido
    }

///////////////////////////////////////////////////////////////
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
