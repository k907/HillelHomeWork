package Lesson_14;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;


public class Run {

  public static void main(String[] args) {

    // создать массив
    Integer sizeArray = 10;
    Integer[] arrInt = new Integer[sizeArray];
      for (int i = 0; i < sizeArray; i++) {
        arrInt[i] = (int) (Math.random() * 100);
      }

      // сортировка
      System.out.println("Исходный массив: " + Arrays.asList(arrInt));
      //Sorter.bubbleSort(arrInt);

<<<<<<< HEAD
      Sorter.insertSort(arrInt); // существенно быстрее чем bubbleSort
=======
      Sorter.insertSort(arrInt); // существенно быстрее bubbleSort
>>>>>>> 913a012... Home work 25/08/2020 lesson 14
      System.out.println(" Отсорт. массив: " + Arrays.asList(arrInt));
      System.out.println("--------------------------------------\n\n");

      // поиск
      int randIndex = (int) (Math.random() * arrInt.length-1);
      //randIndex = 0;
      System.out.println("Найдем индекс элемента: " + arrInt[randIndex]);

      System.out.println("Результат: " + Finder.binarySearch(arrInt, arrInt[randIndex]) + " [binarySearch]");
      System.out.println("Результат: " + Finder.interSearch(arrInt, arrInt[randIndex]) + " [interSearch]");
<<<<<<< HEAD


=======
>>>>>>> 913a012... Home work 25/08/2020 lesson 14
    }

}
