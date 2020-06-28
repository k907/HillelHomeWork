package Lessons_3;

import java.util.Arrays;

/*
Поменять наибольший и наименьший элементы массива местами.
Пример: дан массив {4, -5, 0, 6, 8}. После замены будет выглядеть {4, 8, 0, 6, -5}.
 */
public class Task11 {
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


    int maxElemArray = arrInt[0];
    int indMax = 0;

    int minElemArray = arrInt[0];
    int indMin = 0;

    for (int i = 1; i < sizeArray; i++) {

      if ( arrInt[i] > maxElemArray ) {
        maxElemArray = arrInt[i];
        indMax = i;
      }


      if ( arrInt[i] < minElemArray ) {
        minElemArray = arrInt[i];
        indMin = i;
      }

    } // end for

    System.out.println("Индекс наибольшего элемент массива:  " + indMax + " | значение: " + maxElemArray);
    System.out.println("Индекс наименьшего элемент массива:  " + indMin + " | значение: " + minElemArray);


    // поменяем местами наименьший и наибольший элементы массива
    arrInt[indMin] = maxElemArray;
    arrInt[indMax] = minElemArray;

    System.out.println("Элементы массива после изменения значений: " + Arrays.toString(arrInt));

  }
}
