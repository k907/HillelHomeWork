package Lesson_9;

import java.util.ArrayList;
import java.util.LinkedList;

public class Run {

  public static void main(String[] args) {

    LinkedList<String> linkedList = new LinkedList();

    linkedList.add("0");
    linkedList.add("1");
    linkedList.add(null);
    linkedList.clear();
    System.out.println(linkedList.toString());

    // добавить элементы в коллекцию
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.add("0");
    myLinkedList.add("1");
    myLinkedList.add(null);

    // сравнение элементов
    System.out.println(myLinkedList.compare(linkedList));

    //myLinkedList.add("2");
    //myLinkedList.add("33");
    //myLinkedList.add("789");
    //myLinkedList.add("30");

    //System.out.println(myLinkedList);
    //myLinkedList.delete(0);
    //System.out.println(myLinkedList);

    /*
    // добавить коллекцию  эл.
    ArrayList<String> arrList = new ArrayList();
    arrList.add("0");
    arrList.add("2");
    arrList.add("3");
    myLinkedList.addAll(arrList);
    */

    /*
    // добавить массив  эл.
    String[] arr = new String[3];
    arr[0] = "0";
    arr[1] = "1";
    arr[2] = "3";

    myLinkedList.addAll(arr);
    */

    // удалить элемент по индексу
    //myLinkedList.delete(3);
    //System.out.println(myLinkedList);

    // удалить элемент по значению
    //myLinkedList.delete(null);
    //myLinkedList.delete("789");
   // System.out.println(myLinkedList);

    // содержит значение
    //System.out.println(myLinkedList.contains("2"));
    //System.out.println(myLinkedList.contains(null));

    // получить эл. по индексу
    //System.out.println(myLinkedList.get(3));

    // очистка
    //myLinkedList.clear();
    //System.out.println(myLinkedList);

    /*
    myLinkedList.add("2");
    myLinkedList.add("3");
    myLinkedList.add("4");

    System.out.println(myLinkedList);

    myLinkedList.delete(0);
    System.out.println(myLinkedList);
    */
  }
}


