package Lesson_14;

import java.util.Optional;

public class Finder {

  // Александр, уместно ли здесь в качестве возвращаемого значения использовать Option?
  // Бинарный поиск
  public static int binarySearch (Integer[] arrInt, int searchElem ) {


    if ( !isSorted(arrInt) ) { return -1; }

    int leftBound = 0;
    int rightBound = arrInt.length-1;

    while(true)
    {
      int middle = (leftBound + rightBound ) / 2;

      if(arrInt[middle] == searchElem) {
        return middle; // Элемент найден
      }
      else if(leftBound > rightBound) {
        return -1; // Элемент не найден
      }
      else // новые границы
      {
        if(arrInt[middle] < searchElem)
          leftBound = middle + 1; // искомый элемент предположительно слева
        else
          rightBound = middle - 1; //  искомый элемент предположительно справа
      }
    }
  }

  // Интерполяционный поиск
  public static int interSearch (Integer[] arrInt, int searchElem ) {

    if ( !isSorted(arrInt) ) { return -1; }

    int leftBound = 0;
    int rightBound = arrInt.length - 1;

    while (arrInt[leftBound] < searchElem && arrInt[rightBound] > searchElem) {

        //  деление на 0
        if (arrInt[rightBound] == arrInt[leftBound]) {
          break;
        }

        int middle = leftBound + ((searchElem - arrInt[leftBound]) * (rightBound - leftBound)) / (arrInt[rightBound] - arrInt[leftBound]);

        // новые границы
        if (arrInt[middle] < searchElem) {
          leftBound = middle + 1;
        } else if (arrInt[middle] > searchElem) {
          rightBound = middle - 1;
        } else {
          return middle;
        }

    } // end while

    if (arrInt[leftBound] == searchElem) {
      return leftBound;
    } else if (arrInt[rightBound] == searchElem) {
      return rightBound;
    }

    return -1; // элемент не найден
  }

   private static boolean isSorted (Integer[] arrInt) {

      if ( arrInt == null ) return false;

      if ( arrInt.length < 2 ) return true;

      if ( arrInt[0] > arrInt[arrInt.length-1] ) {
         return false;
      }

      return true;
   }

}
