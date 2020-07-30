package Leson_10;

import java.util.ArrayList;
import java.util.List;

public class Run {

  public static void main(String[] args) {

    // удаление дубликатов
    // List<String> arrList = new ArrayList();
    /*
    arrList.add("1");
    arrList.add("2");
    arrList.add("3");
    arrList.add("1");
    arrList.add("3");
    arrList.add("4");

    System.out.println(arrList.toString());

    Unique.removeDuplicates(arrList);
    System.out.println(arrList.toString());
    */

    // квадратное уравнение
    //SquareRoot.calculate(1,6,8);

     String[] array = new String[10];
     MyIterator iter = new MyIterator(array);

     while (iter.hasNext()) {
       System.out.println(iter.next());
     }

  }
}
