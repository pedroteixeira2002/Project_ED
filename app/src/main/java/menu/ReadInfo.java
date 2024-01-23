package menu;

import java.io.IOException;

public class ReadInfo {

    public static int readQuantityOfLocalizations() throws IOException {
        System.out.println("\nEnter the amount of localizations you want in your map: \t");
        return Tools.GetInt();
    }

    public static boolean readIfIsDirectional() throws IOException {
        Display.displayDirectional();
        switch (Tools.GetInt()) {
            case 1, default:
                return true;
            case 2:
                return false;
        }
    }

    public static double readEdgeDensity() throws IOException {
        System.out.println("\nEnter the wished density for your edges: \t");
        return Tools.getDouble();
    }

    public static boolean saveMap() throws IOException {
        Display.displaySaveMapMenu();
        switch (Tools.GetInt()) {
            case 1, default:
                return true;
            case 2:
                return false;
        }
    }


}
