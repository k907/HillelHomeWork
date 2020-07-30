package Leson_10;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *  итератор по массиву(не коллекции), размер массива задаетя через конструктор
 */
public class MyIterator  {

  private String[] array;

  MyIterator (String[] paramArray ) {
    this.array = paramArray;
  }

  public boolean hasNext() {
    return false;
  }

  public Object next() {
    return null;
  }

  public Object remove () {
    return null;
  }


}
