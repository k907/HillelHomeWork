package Lesson_15;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        System.out.println("Введите целое число:");
        var scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {

            int number = scanner.nextInt();
            System.out.println("Вы ввели число - " + number);
            Painter.draw(number);

        } else {
            System.out.println("\"" + scanner.nextLine() + "\" не является числом");
        }
    }
}