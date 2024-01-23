package menu;

import datapersistence.FileIO;
import game.Game;
import game.ListMap;
import game.Map;

import java.io.IOException;

public class Menu {
    public static void MainMenu(Game game, ListMap maps, FileIO export) throws IOException {
        System.out.println(Display.displayMainMenu());
        switch (Tools.GetInt()) {
            case 1:
                GameMenu(game, maps);
                break;
            case 2:
                System.out.println(maps.getAllMaps());
                break;
            case 3:
                Map map = game.getMap().generateMap
                        (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity());
                if (ReadInfo.saveMap() == true)
                    export.exportToJSON(maps);
                break;
        }
    }


    public static void GameMenu(Game game, ListMap maps) throws IOException {
        Display.displayNewGameMenu();
        switch (Tools.GetInt()) {
            case 1:
                (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity()));
                if (ReadInfo.saveMap() == true)
                    FileIO.exportToJSON(maps);
                break;
            case 2:
                System.out.println(io.importMapsFromJson(ReadInfo.getLocationJson()));
                break;
            default:
                System.out.println("Invalid option");
                //import function
            default:
                map = (game.getMap().generateMap
                        (ReadInfo.readQuantityOfLocalizations(), ReadInfo.readIfIsDirectional(), ReadInfo.readEdgeDensity()));
                if (ReadInfo.saveMap() == true)
                    FileIO.importFromJson();
        }

    }
}
