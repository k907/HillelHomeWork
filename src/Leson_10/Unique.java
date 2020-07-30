package Leson_10;

import java.util.*;

/**
 *   Данный класс получает коллекцию объектов, а возвращает коллекцию уже без дубликатов
 */
public class Unique {


  /**
   * Убрать дубликаты из коллекции
   * @param collation
   * @return колекцию без дубликатов
   */
  public static Collection removeDuplicates (Collection collation ) {

    Iterator iter =  collation.iterator();
    List<Object> arrList = new ArrayList();

    while (iter.hasNext()) {

       Object value = iter.next();

       if ( arrList.contains(value) == false ) {

          arrList.add(value);

       } else {

         iter.remove();

       }

    }

    return collation;
  }



}
