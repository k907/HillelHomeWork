package Lessons_3;

/*
Перепишите программы с использованием цикла while.
*/
public class Task3 {
  public static void main(String[] args) {

    // При помощи цикла while вывести на экран нечетные числа от 1 до 99.
    int loopVar = 1;
    while (loopVar <= 99) {

      if ( loopVar % 2 != 0  ) {
        System.out.println(loopVar);
      }

      loopVar++;
    }

    //-----------------------------------------------------//
    // Дано число n при помощи цикла while посчитать факториал n!

    int number = 3; // число факториал которого нужно вычислить
    loopVar = 1;
    int factorial = 1;

    while (loopVar <= number) {

      factorial *= loopVar;
      loopVar++;
    }
    System.out.println("Факториал числа " + number + " = " + factorial);

  }
}
