package Lesson_9;

import java.util.List;

interface IColection {

  boolean add(Object o);

  boolean add(int intex, Object o);

  boolean delete (Object o);

  Object get(int index);

  boolean contain(Object o);

  boolean equals ( List str);

  boolean clear();

  int size();
}
