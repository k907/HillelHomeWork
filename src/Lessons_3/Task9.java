package Lessons_3;

import java.util.Arrays;

/*
Дан массив размерности N, найти наименьший элемент массива и вывести на консоль
(если наименьших элементов несколько — вывести их все).
 */
public class Task9 {
  public static void main(String[] args) {

    int sizeArray = 20; // размер массива
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

    // найдем минимальные значения массива
    int minElemArray = arrInt[0];
    String listIndexArray = "0";

    for (int i = 1; i < sizeArray; i++) {

       if ( arrInt[i] < minElemArray ) {
         minElemArray = arrInt[i];
         listIndexArray = "" + i;
       } else if ( arrInt[i] == minElemArray ) {
         listIndexArray += ", " + i;
       }
    }

    System.out.println("Минимальные значения массива");
    for (String i : listIndexArray.split(", ")) {
      System.out.println("Индекс массива: " + i + " значение: " + arrInt[new Integer(i)] );
    }

  }
}
