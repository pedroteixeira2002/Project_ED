package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class   Tools  {
    public static  String GetString() throws IOException {

        BufferedReader stringIn = new BufferedReader(new
                InputStreamReader(System.in));

        return  stringIn.readLine();

    }
    public  static  int  GetInt( ) throws IOException {

        String aux = GetString();

        return Integer.parseInt(aux);

    }
    public  static  long GetLong( ) throws IOException {

        String aux = GetString();

        return Long.parseLong(aux);

    }
    public  static char  GetChar( ) throws IOException {

        String  aux = GetString();

        return aux.charAt(0);

    }
    public static double getDouble() throws IOException {
        String aux = GetString();
        return Double.parseDouble(aux);
    }

}