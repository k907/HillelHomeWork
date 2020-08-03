package Lesson_9;

import java.util.*;

/**
 *  Коллекция на основе связного списка
 */
public class MyLinkedList implements ICollection {

  Entry header;
  int size;

  public MyLinkedList ()
  {
    header = new Entry();
  }

  /** добавить элемент
   * - создается новый экземпляр класса Entry
   * - переопределяются указатели на предыдущий и следующий элемент
   * - увеличивается size
   */
  @Override
  public boolean add(String str)  {

    Entry lastElem = header.prev;

    // создать новый узел
    Entry newEntry = new Entry(str, header, lastElem );

    // изменить связи соседей
    header.prev = newEntry;
    lastElem.next = newEntry;

    size++;
    return true;
  }

  @Override
  public boolean addAll(String[] strArr) {

    if ( strArr.length == 0 ) {
        return false;
    }

    for (String s: strArr) {
      add(s);
    }

    size += strArr.length;
    return true;
  }

  @Override
  public boolean addAll(Collection strColl) {

    if ( strColl.size() == 0 ) {
      return false;
    }

    Iterator<String> iter = strColl.iterator();
    while (iter.hasNext()) {
      add( (String) iter.next());
    }

    return true;
  }

  // нумерация элементов начинается с 0
  @Override
  public boolean delete(int index) throws IndexOutOfBoundsException {

    if (index < 0 || index >= size ) {
      throw new IndexOutOfBoundsException("Элемент с индексом " + index + " не существует");
    }

    // получим узел по индексу
    Entry currEntry = getEntryByIndex(index);

    //  удалить элемент
    unlink ( currEntry );

    return true;
  }

  /**
   * Удалит первый найденный элемент
   * @param str
   * @return
   */
  @Override
  public boolean delete(String str)  {

    if ( size == 0 ) return false;

    Entry currEntry = header.next;
    int index = 0;

    do {

      if ( compareItems(currEntry.element, str) ) {
          unlink(currEntry);
          return true;
      }

      currEntry = currEntry.next;
    } while(++index < size );

    return false;
  }

  @Override
  public String get(int index) throws IndexOutOfBoundsException {

    if (index < 0 || index >= size ) {
      throw new IndexOutOfBoundsException("Элемент с индексом " + index + " не существует");
    }

    // получим узел по индексу
    Entry currEntry = getEntryByIndex(index);

    return currEntry.element;
  }

  /**
   * Проверяет содержит ли список значение перданное str
   */
  @Override
  public boolean contains(String str)  {

    if ( size == 0 ) return false;

    Entry currEntry = header.next;
    int index = 0;

    do {

      if ( containsNull(currEntry.element, str)  ) {
        return true;
      }

      currEntry = currEntry.next;
    } while(++index < size );

    return false;
  }

  /**
   *  удалить все эл. коллекции
   *  перебрать все эл. списка, присвоить null соседям
   */
  @Override
  public boolean clear() {

    if ( size == 0 ) return true;

    Entry currEntry = header.next;
    int index = 0;

    do {

      Entry nextEntry= currEntry.next;
      currEntry.next = null;
      currEntry.prev = null;
      // currEntry.element = null;  должен уничтожиться вместе с Entry содержащим свойство element

      // на последней итерации currEntry == header
      currEntry = nextEntry;
    } while(++index < size );

    header = new Entry();
    size = 0;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  // удаляет из коллекции ВСЕ элементы со значением null
  // если был найден и удалел хотябы один элемент, вернет true иначе false
  @Override
  public boolean trim() {

    if ( size == 0 ) return false;

    // хранит объекты Entry для удаления
    List<Entry> listElemFofDelete = new ArrayList();

    Entry currEntry = header.next;
    int index = 0;

    do {

      if ( compareItems(currEntry.element, null)  ) {
        listElemFofDelete.add(currEntry);
      }

      currEntry = currEntry.next;
    } while(++index < size );

    if ( listElemFofDelete.size() != 0 ) {
      for (Entry elem: listElemFofDelete) {
        unlink(elem);
      }

      return true;
    }

    return false;
  }

  // сравнить каждый эл. coll с эл. списка
  // если совпадают все эл. и их количество, вернуть true, иначе false
  @Override
  public boolean compare(Collection coll) {

    if ( size != coll.size() )  return false;
    if ( size == 0 & coll.size() == 0 ) return true;

    Iterator<String> iter = coll.iterator();
    while (iter.hasNext()) {

      Entry currEntry = header.next;
      int index = 0;

      do {
        if ( compareItems(currEntry.element, iter.next()) == false   ) {
          return false;
        }

        currEntry = currEntry.next;
      } while(++index < size );

    }

  return true;
  }

  @Override
  public String toString() {

    if ( size == 0 ) {
      return "[]";
    }

    Entry currEntry = header.next;
    String res = "[ " + currEntry.element + " ";

    for (int i = 0; i < size - 1; i++) {
      currEntry = currEntry.next;
      res += ", " + currEntry.element + " ";
    }

    return res + "]";
  }

  // проверить содержит ли элемент подстроку, учитывать null значения
  private boolean containsNull ( String str1, String str2 ) {

    if ( str1 == null || str2 == null ) {

      if ( str1 == str2  ) return true;

    } else {

      if ( str1.contains(str2) ) return true;

    }

    return false;
  }

  // сравнение строк, учитывать null значения
  private boolean compareItems ( String str1, String str2 ) {

    if ( str1 == null || str2 == null ) {

      if ( str1 == str2  ) return true;

    } else {

      if ( str1.equals(str2) ) return true;

    }

    return false;
  }

  // удалить элемент списка и обновить связи соседей
  private void unlink ( Entry paramEntry ) {

    // изменим связи
    Entry nextEntry = paramEntry.next;
    Entry prevEntry = paramEntry.prev;

    prevEntry.next = nextEntry;
    nextEntry.prev = prevEntry;

    size--;

    // на объект paramEntry теперь нет ссылок, он доступен для сборщика мусора
  }

  private Entry getEntryByIndex (int index) {

    Entry currEntry = header.next;
    for (int i = 0; i < index; i++) {
      currEntry = currEntry.next;
    }

    return currEntry;
  }

  private static class Entry {

    String element;
    Entry next;
    Entry prev;

    Entry(String element, Entry nextElem, Entry prevElem ) {
      this.element = element;
      this.next = nextElem;
      this.prev = prevElem;
    }

    // использовать для создания header
    Entry() {
      this.element = null;
      this.next = this;
      this.prev = this;
    }
  }
}
