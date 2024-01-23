package menu;

import datapersistence.FileIO;
import game.Game;
import game.ListMap;

import java.io.IOException;

public class Menu {
    public static void MainMenu(Game game, ListMap maps, FileIO export) throws IOException {
        System.out.println(Display.displayMainMenu());
        switch (Tools.GetInt()) {
            case 1:
                GameMenu(game, maps, export);
                break;
            case 2:
                System.out.println(maps.getAllMaps());
                break;
            case 3:
                System.out.println(game.getMap().generateMap
                        (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity()));
                if (ReadInfo.saveMap() == true)
                    export.exportGraphToJSON(maps);
                break;
        }
    }


    public static void GameMenu(Game game, ListMap maps, FileIO io) throws IOException {
        Display.displayNewGameMenu();
        switch (Tools.GetInt()) {
            case 1:
                System.out.println(game.getMap().generateMap
                        (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity()));
                if (ReadInfo.saveMap() == true)
                    io.exportGraphToJSON(maps);
                break;
            case 2:
                String s = ReadInfo.getLocationJson();
                System.out.println(io.importMapsFromJson(s));
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }
}
