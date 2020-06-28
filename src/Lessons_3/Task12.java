package Lessons_3;

import java.util.Arrays;

/*
Найти среднее арифметическое всех элементов массива.
 */
public class Task12 {
  public static void main(String[] args) {

    int sizeArray = 5; // размер массива
    int[] arrInt = new int[sizeArray];

    if ( arrInt.length == 0 ) {
      System.out.println("Массив должен содержать минимум один элемент");
      System.exit(0);
    }

    // сгенерировать массив размерностью sizeArray
    for (int i = 0; i < sizeArray; i++) {
      arrInt[i] = (int) (Math.random() * 10);
    }
    System.out.println("Элементы массива: " + Arrays.toString(arrInt));

    // Найти среднее арифметическое всех элементов массива.
    int sum = 0;

    for (int i = 0; i < sizeArray; i++) {
      sum += arrInt[i];
    }

    System.out.println("Cреднее арифметическое элементов массива: " + (sum / arrInt.length));
    }
}
