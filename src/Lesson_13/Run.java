package Lesson_13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Run {

  public static void main(String[] args) {

    // Задача 1. Имеется коллекция из Integes, использую стримы посчитать среденее значения всех чисел

      //----------- вариант 1 -------------//
      OptionalDouble result = IntStream.range(0,100).average();
      System.out.println("result average: " +  (result.isPresent() ? result.getAsDouble() : "null object") );

      result = IntStream.empty().average();
      System.out.println("result average: " +  (result.isPresent() ? result.getAsDouble() : "null object") );


      //----------- вариант 2 -------------//
       IntStream.range(0,100).average().ifPresentOrElse( x -> System.out.println("result average: " + x),
                                                        ()  -> System.out.println("null object") );

       IntStream.empty().average().ifPresentOrElse( x -> System.out.println("result average: " + x),
                                                    ()  -> System.out.println("null object")  );
       System.out.println("----------------------------------------\n");


    // Задача 2. Имеется коллекция из String, привести все стринги в UPPERCASE и вернуть коллекцию List<Pair>
    // in: "one", "two", ...
    // out: {"one":"ONE"}, {"two", "TWO"}, ...

    var listString = new ArrayList<String>();
    listString.add("one");
    listString.add("two");
    listString.add("three");

    List<Pair> pair = listString.stream()
            .map(s -> new Pair(s))
            .collect(Collectors.toList());

    System.out.println(pair);
    System.out.println("----------------------------------------\n");

    // Задача 3. Имеется коллекция из String, отфильтровать и вывести на экран все значения, которые написаны в loverCase and length = 4
    var arrayList = new ArrayList<String>();
    arrayList.add("oNe8");
    arrayList.add("tWo");
    arrayList.add("thTee");
    arrayList.add("three");
    arrayList.add("four");
    arrayList.add("five");
    arrayList.add("six");

    arrayList.stream()
             .filter( s ->  s.length() == 4 )
             .filter( s ->  s.equals(s.toLowerCase()) )
             .forEach(System.out::println);

  }

}

