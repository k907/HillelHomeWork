package Lesson_19;

public class ATM implements Runnable {

    private int balance = 1000;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            runRandomTransaction(getRandNum(500, 1000));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void runRandomTransaction(int amount) {

        if (getRandNum(0, 1) == 1) {
            System.out.println("Поток " + Thread.currentThread().getName() + " пытается обналичить " + amount + " грн.");

            if (!checkBalance(amount)) {
                System.out.println("В банкомате недостаточно денег для транзакции\n");
            } else {
                getMoney(amount);
                System.out.println("Обналичено " + amount + " грн.");
                System.out.println("Текущий баланс: " + getBalance() + "грн.\n");
            }

        } else {
            putMoney(amount);
            System.out.println("Поток " + Thread.currentThread().getName() + " пополнил баланс на " + amount + " грн.");
            System.out.println("Текущий баланс: " + getBalance() + "грн.\n");
        }
    }

    private int getBalance() {
        return balance;
    }

    public void getMoney(int amount) {
        balance -= amount;
    }

    public void putMoney(int amount) {
        balance += amount;
    }

    private boolean checkBalance(int amount) {
        return amount <= getBalance();
    }

    public int getRandNum(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
