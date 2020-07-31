package Leson_10;

import java.util.Iterator;
import java.util.function.Consumer;
/**
 *  итератор по массиву(не коллекции), размер массива задаетя через конструктор
 */
public class MyIterator  {

  private String[] array;
  private int currInd;

  MyIterator (String[] paramArray ) {
    this.array = paramArray;
  }

  public boolean hasNext() {

    return currInd < array.length;
  }

  public Object next() throws ArrayIndexOutOfBoundsException {

    if (currInd >= array.length) {
      throw new ArrayIndexOutOfBoundsException ("Индекс массива выходит за пределы");
    }
    return array[currInd++];
  }

}
