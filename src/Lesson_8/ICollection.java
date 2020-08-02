package Lesson_8;

import java.util.Collection;

public interface ICollection {

  boolean add(Object o);

  boolean add(int index, Object o);

  boolean delete (Object o);

  Object get(int index);

  boolean contain(Object o);

  boolean equals (Collection str);

  boolean clear();

  int size();

}
