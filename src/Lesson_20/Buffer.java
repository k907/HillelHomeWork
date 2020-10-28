package Lesson_20;

import java.util.Stack;

public class Buffer {

    private Stack<Data> container = new Stack<>();
    private int maxSize;

    /**
     * @param size макисмальный размер буфера
     */
    public Buffer(int size) {
        maxSize = size;
    }

    public synchronized Data getData() {

        if (container.size() < 1) {
            System.out.println("Буфер не содержит объекты");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Data data = container.pop();
        System.out.println("Из буфера удален объект: " + data.toString());
        notifyAll();
        return data;
    }

    public synchronized void putData(Data data) {

        if (container.size() >= maxSize) {
            System.out.println("Буфер достиг максимального размера");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("В буфер добавлен объект: " + container.push(data).toString());
        notifyAll();
    }

}
