package Lessons_3;

/*
Перепишите программы с использованием цикла do - while.
*/
public class Task4 {
  public static void main(String[] args) {

    // При помощи цикла do - while вывести на экран нечетные числа от 1 до 99.
    int loopVar = 1;
    do {

      if ( loopVar % 2 != 0  ) {
        System.out.println(loopVar);
      }

    loopVar++;
    } while (loopVar <= 99);


    //-----------------------------------------------------//
    // Дано число n при помощи цикла do - while посчитать факториал n!

    int number = 3; // число факториал которого нужно вычислить
    loopVar = 1;
    int factorial = 1;

    do {

      factorial *= loopVar;
      loopVar++;

    } while (loopVar <= number);

    System.out.println("Факториал числа " + number + " = " + factorial);
  }
}
