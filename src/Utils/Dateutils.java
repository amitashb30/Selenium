package Utils;

import java.util.Date;

public class Dateutils
{
    public static String timestamp(){

        Date date = new Date();
        return date.toString().replaceAll(":","_").replaceAll(" ","_");
    }
}
