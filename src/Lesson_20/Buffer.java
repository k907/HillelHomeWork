package Lesson_20;

import java.util.ArrayList;

public class Buffer {

    private ArrayList<Data> container;
    private int maxSize;

    /**
     * @param size макисмальный размер беффера
     */
    public Buffer(int size) {
       maxSize = size;
    }

    public synchronized Data getData() {
        return new Data(1);
    }

    public synchronized void setData() {
//        return new Data(1);
    }


}
