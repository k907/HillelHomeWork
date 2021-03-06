package Lesson_10;

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

  public String next() throws ArrayIndexOutOfBoundsException {

    if (currInd >= array.length) {
      throw new ArrayIndexOutOfBoundsException ("Индекс массива выходит за пределы");
    }
    return array[currInd++];
  }

}
