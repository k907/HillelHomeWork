package Lessons_3;

import java.util.Arrays;

/*
В массиве из задания 9. найти наибольший элемент.
 */
public class Task10 {
  public static void main(String[] args) {

    int sizeArray = 10; // размер массива
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

    // найдем наибольший элемент
    int maxElemArray = arrInt[0];

    for (int i = 1; i < sizeArray; i++) {

      if ( arrInt[i] > maxElemArray ) {
        maxElemArray = arrInt[i];
      }

    }

    System.out.println("Наибольший элемент массива: " + maxElemArray);

  }
}
