package menu;

import datapersistence.FileIO;
import game.Game;
import game.ListMap;
import game.Map;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private int getOption() {
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        return option;
    }

    public void MainMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            int option = getOption();
            ListMap maps = new ListMap();
            System.out.println(Display.displayMainMenu());
            switch (option) {
                case 1:
                    GameMenu(maps);
                    break;
                case 2:
                    Map map = new Map();
                    map.generateMap
                            (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity());
                    maps.addMap(map);
                    if (ReadInfo.saveMap())
                        FileIO.exportToJSON(maps);
                    break;
                case 0:
                    isRunning = false;
            }
        }
    }


    public void GameMenu(ListMap maps) {
        Game game = new Game();
        Display.displayNewGameMenu();
        boolean isRunning = true;
        while (isRunning) {
            int option = getOption();
            switch (option) {
                case 1:
                    int localizations = ReadInfo.readQuantityOfLocalizations();
                    boolean directional = ReadInfo.readIfIsDirectional();
                    double density = 0;
                    try {
                        density = ReadInfo.readEdgeDensity();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    game.getMap().generateMap
                            (localizations, directional, density);
                    if (ReadInfo.saveMap() == true)
                        FileIO.exportToJSON(maps);
                    break;
                case 2:
                    maps = FileIO.importFromJson();
                    System.out.println(maps.getAllMaps());
                case 0:
                    isRunning = false;
                default:
                    try {
                        game.getMap().generateMap
                                (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (ReadInfo.saveMap() == true)
                        FileIO.importFromJson();
                    break;

            }

        }
    }
}
