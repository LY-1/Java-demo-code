package print;

import java.util.concurrent.Semaphore;

public class BySemaphore {
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + "A");
                    semaphoreB.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + "B");
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.println(Thread.currentThread().getName() + ": " + "C");
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
