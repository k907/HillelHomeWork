package Lessons_7;

import java.util.Arrays;

/*
Реализовать простую коллекцию для String на базе массива.
методы:
добавлять (add), (по индеку или значению)
удалять(delete), (по индексу или значению)
доставать по индексу (get),
*/
public class MyColection {

    private int size;
    private String[] arrayData = new String[10];

    // Получить элемент по индексу
    public String get ( int index ) throws ArrayIndexOutOfBoundsException {

        if (index < 0 || index > size - 1 ) {
            throw new ArrayIndexOutOfBoundsException ("Некорректный индекс!");
        }

        return arrayData[index];
    }

    // Добавление в конец массива
    public void add ( String value ) {

        // увеличим массив если нужно
        ensureCapacity(size + 1 );
        arrayData[size++] = value;
    }

    // Добавление по индексу
    public void add ( int index, String value ) throws ArrayIndexOutOfBoundsException {

        if (index < 0 || index > size - 1 ) {
            throw new ArrayIndexOutOfBoundsException ("Некорректный индекс!");
        }

        // увеличим массив если нужно
        ensureCapacity(size + 1 );
        arrayСopy(arrayData.clone(), index, arrayData, index + 1, size-index);

        arrayData[index] = value;
        size++;
    }

    // Удаление по индексу
    public void remove ( int index ) throws ArrayIndexOutOfBoundsException {

        if (index < 0 || index > size - 1 ) {
            throw new ArrayIndexOutOfBoundsException ("Некорректный индекс!");
        }

        arrayСopy(arrayData.clone(), index+1, arrayData, index,  size - index - 1);
        arrayData[--size] = null;
    }

    // Удаление по значению
    public void remove ( String value ) {

            for (int i = 0; i < size; i++) {

                 if ( arrayData[i].equals(value) ) {
                     remove (i);
                 }
            }
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
            String[] oldData = arrayData;
            arrayData = new String[(oldData.length*3)/2+1];
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
    private void arrayСopy(String[] from, int fromIndex, String[] to, int toIndex, int count ) throws IllegalArgumentException
    {

        if ( to.length  < (toIndex + count) || from.length < (fromIndex + count)  ) {
            throw new IllegalArgumentException("Длина массива меньше минимально значения");
        }

        for( int i = fromIndex; i < (fromIndex + count); i++  ) {
            to[toIndex++] = from[i];
        }
    }

}
