package game;

import menu.ReadInfo;
import menu.Tools;
import structures.NetworkEnhance;

import java.io.IOException;
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
    public Player newGame(NetworkEnhance<Location> map) throws IOException {

        System.out.println("Insira o nome do jogador 1");
        this.player1.setName(Tools.GetString());

        System.out.println("Insira o nome do jogador 2");
        this.player2.setName(Tools.GetString());

        System.out.println(map.getVertices());

        System.out.println("Insira a localização da sua bandeira: jogador 1");
        Location l1 = new Location(ReadInfo.readCoordinate(), ReadInfo.readCoordinate());

        System.out.println("Insira a localização da sua bandeira: jogador 2");
        Location l2 = new Location(ReadInfo.readCoordinate(), ReadInfo.readCoordinate());

        this.player1.setFlag(l1);
        this.player2.setFlag(l2);

        System.out.println("Player 1 - Adicione bots à lista");
        int ans;
        do {
            Bot bot1 = null;
            Bot bot2 = null;

            bot1.setAlgorithm(this);
            player1.getListBots().add(bot1);

            bot2.setAlgorithm(this);
            player2.getListBots().add(bot2);
            System.out.println("Desejam adicionar outro bot?");
            ans = Tools.readInt();
        } while (ans == 1 );

        do{
            makeMove( );

        }while(player1.getCurrentLocation().equals(flag2) || player2.getCurrentLocation().equals(flag1));

        checkVictoryCondition(player1, player2);

        return null;
    }

    public void verify() {
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
     *
     * @param movingbot   The bot being moved. (que está sendo movido)
     */
    public void makeMove(Bot movingbot) {
        // Move o bot para a nova localização se o movimento for válido
            this.player1.setCurrentLocation(movingbot.getAlgorithm().move(this));
        // Verifica se a jogada resultou na vitória
        if (checkVictoryCondition(turn, turn == player1 ? player2 : player1)) { // Verifica se o jogador atual é um dos
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
     *
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
     *
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
     *
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
