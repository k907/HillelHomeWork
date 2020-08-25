package Lesson_14;

public class Sorter {

  // сортировка пузырьком
  public static void bubbleSort (Integer[] arrInt ) {

    // в книге опечатка, во внешнем циклке условие ( out > 1 ), должно быть 0 - https://i.imgur.com/7UsK0u8.jpg
    for (int border = arrInt.length - 1; border > 0; border--) {

        for (int currElem = 0; currElem < border; currElem++) {

          if (arrInt[currElem] > arrInt[currElem+1]) {

               int temp = arrInt[currElem];
               arrInt[currElem] = arrInt[currElem+1];
               arrInt[currElem+1] = temp;
          }
        }
    }
  }

  // сортировка методом вставки
  public static void insertSort (Integer[] arrInt )
  {
      int currElem;
      for( int marker=1; marker<arrInt.length; marker++)
      {
        // arrInt[marker] элемент для сравнения
        int temp = arrInt[marker];

        currElem = marker;
        while(currElem>0 && arrInt[currElem-1] >= temp) // перебор всех эл. в отсортированной группе
        {
          arrInt[currElem] = arrInt[currElem-1];
          --currElem;
        }

        arrInt[currElem] = temp; // вставка элем. маркера
      }

  }



}
