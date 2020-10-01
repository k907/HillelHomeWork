package Lesson_15;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Painter {

    // символ для отрисовки цифр
    private static String symbol = "@";

    // задержка отрисовки в милесекундах
    private static int renderingDelay = 200;

    // разделитель цифр, для вывода в одну строку
    private static String separatorNumbers = "  ";

    // схемы для отображения цифр
    private static  String[][] arrDigitPatterns =  {
            {"*$$$$*","$$**$$","$$**$$","$$**$$","*$$$$*"},
            {"**$$**","*$$$**","$*$$**","**$$**","$$$$$$"},
            {"*$$$$*","$$**$$","***$$*","**$$**","$$$$$$"},
            {"*$$$$*","$$**$$","***$$*","$$**$$","*$$$$*"},
            {"$$**$$","$$**$$","$$$$$$","****$$","****$$"},
            {"$$$$$$","$$****","$$$$$*","****$$","$$$$$*"},
            {"*$$$$$","$$****","$$$$$*","$$**$$","*$$$$*"},
            {"$$$$$$","***$$*","**$$**","*$$***","$$****"},
            {"*$$$$*","$$**$$","*$$$$*","$$**$$","*$$$$*"},
            {"*$$$$$","$$**$$","*$$$$$","****$$","*$$$$*"}};

    //----------------------------------------
    // нарисовать число
    public static void draw ( int number )  {

        var scan = new Scanner(String.valueOf(number));
        scan.useDelimiter("");

        var listLine = new ArrayList<String>();

        while ( scan.hasNext() ) {
            String[] currPatternDigit = arrDigitPatterns[scan.nextInt()];
            for (int i = 0; i < 5; i++) {

                if ( i >= listLine.size() ) {
                    listLine.add(i,  separatorNumbers + currPatternDigit[i]);
                } else {
                    listLine.set(i,  listLine.get(i) + separatorNumbers + currPatternDigit[i]);
                }
            }
        }

        drawDigits(listLine);
    }

    //----------------------------------------
    // нарисовать цифры построчно
    private static void drawDigits( ArrayList listLine )  {

        for (int i = 0; i < listLine.size(); i++) {

            String currLine = (String) listLine.get(i);
            currLine = currLine.replace("*"," ");
            currLine = currLine.replace("$",symbol);
            System.out.println(currLine);

            // пауза для плавной отрисовки
            sleep(renderingDelay);
        }
    }
    //----------------------------------------
    private static void sleep (int time) {

        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch ( InterruptedException ex ) {
            System.out.println(ex.getMessage());
        }
    }
    //----------------------------------------

}