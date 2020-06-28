package Lessons_3;

import java.util.Scanner;

/*
Необходимо вывести на экран таблицу умножения на Х: (любое число вводимое из консоли)
*/
public class Task7 {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.print("Введите целое чиcло: ");
    int x = in.nextInt();

     System.out.println("Таблица умножения на " + x);
     for (int i = 1; i <= 10; i++) {
      System.out.println( i + " x " + x + " = " + i * x);
     }

    }

}
