package menu;

import java.io.IOException;

public class ReadInfo {
    public static int readQuantityOfLocalizations() throws IOException {
        System.out.println("\nEnter the amount of localizations you want in your map: \t");
        return Tools.GetInt();
    }

    public static boolean readIfIsDirectional() throws IOException {
        System.out.println("\nDo you want the paths to be bidirectional? \t");
        Display.displayIfDirectional();
        switch (Tools.GetInt()) {
            case 1:
                return true;

            default:
                return false;
        }
    }
    public static double readEdgeDensity() throws IOException {
        System.out.println("\nEnter the wished density for your edges: \t");
        return Tools.getReal();
    }


}
