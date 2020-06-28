package Lessons_3;

/*
Дано число n при помощи цикла for посчитать факториал n!
*/
public class Task2 {
  public static void main(String[] args) {
    int number = 10;
    int factorial = 1;

    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }

    System.out.println("Факториал числа " + number + " = " + factorial);
  }
}
