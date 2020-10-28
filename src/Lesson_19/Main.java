package Lesson_19;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ATM atm = new ATM();

        Thread thread1 = new Thread(atm);
        Thread thread2 = new Thread(atm);

        thread1.start();
        thread2.start();
    }

}


