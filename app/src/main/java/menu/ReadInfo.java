package menu;

import java.io.IOException;

public class ReadInfo {

    public static int readQuantityOfLocalizations() {
        System.out.println("\nEnter the amount of localizations you want in your map:");
        return Tools.readInt();
    }

    public static boolean readIfIsDirectional() {
        Display.displayDirectional();
        switch (Tools.readInt()) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return true;
        }
    }

    public static double readEdgeDensity() throws IOException {
        System.out.println("\nEnter the wished density for your edges(0.1 to 1):");
        return Tools.getDouble();
    }

    public static boolean saveMap() {
        Display.displaySaveMapMenu();
        switch (Tools.readInt()) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return true;

        }
    }

    public static int readCoordinate(){
        System.out.println("Insira a coordenada");
        return Tools.readInt();
    }

}
