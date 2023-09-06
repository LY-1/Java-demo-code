package print;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序打印ABC，N次
 */
public class ByReentranLock {
    private int times;
    private int state;
    private ReentrantLock lock = new ReentrantLock();

    ByReentranLock(int times) {
        this.times = times;
    }

    public void print(int targetStatus, String name) {
        for (int i = 0; i < times;) {
            if (lock.tryLock()) {
                if (state % 3 == targetStatus) {
                    System.out.println(Thread.currentThread().getName() + ": " + name);
                    i++;
                    state++;
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ByReentranLock byReentranLock = new ByReentranLock(10);

        new Thread(()->{
            byReentranLock.print(0, "A");
        }).start();

        new Thread(()->{
            byReentranLock.print(1, "B");
        }).start();

        new Thread(()->{
            byReentranLock.print(2, "C");
        }).start();
    }
}
