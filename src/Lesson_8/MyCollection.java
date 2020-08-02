package Lesson_8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class MyCollection implements ICollection {

  private int size;
  private Object[] arrayData = new Object[10];

  @Override
  public boolean contain(Object value) {

    for (int i = 0; i < size; i++) {
      if ( arrayData[i].equals(value) ) {
        return true;
      }
    }

    return false;
  }

  /*
    Сравнение с классами имплементирующими Collection
    Коллекции равны если порядок элементов и их содержимое равны
    getClass() не используем в сравнении, что бы можно было передать любую коллекцию
  */
  @Override
  public boolean equals(Collection collection) {

    if (this == collection) return true;
    if (collection == null) return false;
    if (collection.size() != size) return false;

    Iterator iter = collection.iterator();

    int index = 0;
    while (iter.hasNext()) {

      if (arrayData[index++].equals(iter.next()) == false) {
        return false;
      }
    }

  return true;
  }

  // сравнение с MyCollection и прочими объектами
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MyCollection colection = (MyCollection) o;
    return size == colection.size &&
            Arrays.equals(arrayData, colection.arrayData);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(arrayData);
    return result;
  }

  // удалить все значения массива
  @Override
  public boolean clear() {
    arrayData = new Object[10];
    size = 0;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  // Добавление в конец массива
  @Override
  public boolean add ( Object value ) {

    // увеличим массив если нужно
    ensureCapacity(size + 1 );
    arrayData[size++] = value;
    return true;
  }

  // Получить элемент по индексу
  @Override
  public Object get ( int index ) throws ArrayIndexOutOfBoundsException {

    if (index < 0 || index > size - 1 ) {
      throw new ArrayIndexOutOfBoundsException ("Некорректный индекс!");
    }

    return arrayData[index];
  }

  // Добавление по индексу
  @Override
  public boolean add ( int index, Object value ) throws ArrayIndexOutOfBoundsException {

    if (index < 0 || index > size - 1 ) {
      throw new ArrayIndexOutOfBoundsException ("Некорректный индекс!");
    }

    // увеличим массив если нужно
    ensureCapacity(size + 1 );
    arrayСopy(arrayData.clone(), index, arrayData, index + 1, size-index);

    arrayData[index] = value;
    size++;

    return true;
  }

  // Удаление по значению
  @Override
  public boolean delete ( Object value ) throws ArrayIndexOutOfBoundsException  {

    for (int i = 0; i < size; i++) {

      if ( arrayData[i].equals(value) ) {
          arrayСopy(arrayData.clone(), i+1, arrayData, i,  size - i - 1);
          arrayData[--size] = null;
          return true;
      }
    }

    return false;
  }

  @Override
  public String toString() {
    return "MyColection{" +
            "size=" + size +
            ", arrayData=" + Arrays.toString(arrayData) +
            '}';
  }

  // Увеличивает массив если закончились свободные элементы
  private void ensureCapacity ( int minCapacity ) {

    if ( minCapacity > arrayData.length ) {
      Object[] oldData = arrayData;
      arrayData = new Object[(oldData.length*3)/2+1];
      arrayСopy(oldData, 0, arrayData, 0 , oldData.length );
    }
  }

  /**
   * Копирует элементы в новый массив
   * @param from - массив, который копируем
   * @param fromIndex индекс в массиве from начиная с которого берем элементы для копирования
   * @param to - массив, который копируем
   * @param toIndex - индекс в массиве to начиная с которого вставляем элементы
   * @param count - количество элементов которые берем из массива from и вставляем в массив to
   */
  private void arrayСopy(Object[] from, int fromIndex, Object[] to, int toIndex, int count ) throws IllegalArgumentException
  {

    if ( to.length  < (toIndex + count) || from.length < (fromIndex + count)  ) {
      throw new IllegalArgumentException("Длина массива меньше минимально значения");
    }

    for( int i = fromIndex; i < (fromIndex + count); i++  ) {
      to[toIndex++] = from[i];
    }
  }

}
