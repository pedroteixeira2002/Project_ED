package menu;

import java.io.IOException;

public class Menu {

    public static void MainMenu() throws IOException {
        System.out.println(Display.displayMainMenu());
        switch(Tools.GetInt()){
            case 1:
                System.out.println(Display.displayNewGameMenu());

            case 2:
                System.out.println(Display.displayNewGameMenu());

                //case3:
                //System.out.println(display.displayNewMap);



        }


    }

}
