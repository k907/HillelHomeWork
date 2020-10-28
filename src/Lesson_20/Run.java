package Lesson_20;

public class Run {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(5);

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());


    }
}
