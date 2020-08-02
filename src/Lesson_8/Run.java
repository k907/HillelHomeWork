package Lesson_8;

import java.util.ArrayList;

public class Run {

  public static void main(String[] args) {

    MyCollection colection = new MyCollection();
    colection.add("0");
    colection.add("1");
    colection.add("2");
    colection.add("3");

    MyCollection colection2 = new MyCollection();
    colection2.add("0");
    colection2.add("1");
    colection2.add("2");
    colection2.add("3");
    colection2.add("34");

    ArrayList<String> arrList = new ArrayList();
    arrList.add("0");
    arrList.add("1");
    arrList.add("2");
    arrList.add("3");

    System.out.println(colection.equals(arrList));
    System.out.println(colection.equals(colection2));

    // System.out.println("res " + colection.delete(0));
  }

}
