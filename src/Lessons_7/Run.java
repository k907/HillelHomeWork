package Lessons_7;

import java.util.Arrays;

public class Run {

  public static void main(String[] args) {

    MyColection colection = new MyColection();

      colection.add("0");
      colection.add("1");
      colection.add("2");
      colection.add("3");
      colection.add("4");
      colection.add("5");

     System.out.println(colection.toString());

    // добавим элемент в конец массива
    colection.add("6");
    System.out.println(colection.toString());

    // добавим элемент по индексу
     colection.add(6, "new_val");
     System.out.println(colection.toString());

    // удалим элемент по индексу
     colection.remove (1);
     System.out.println(colection.toString());

    // удалим элемент по значению
    colection.remove ("3");
    System.out.println(colection.toString());

    // Получить элемент по индексу
    System.out.println( "Значение элемента с индексом 0: " + colection.get(0));

  }


}

