package print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ByCondition {
    private int times;
    private int state;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    ByCondition(int times) {
        this.times = times;
    }

    public void print(int targetState, String name, Condition current, Condition next) {
        for (int i = 0; i < times;) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                        current.await();
                }
                state ++;
                i ++;
                System.out.println(Thread.currentThread().getName() + ": " + name);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ByCondition byCondition = new ByCondition(2);

        new Thread(()->{
            byCondition.print(0, "A", ByCondition.a, ByCondition.b);
        }).start();

        new Thread(()->{
            byCondition.print(1, "B", ByCondition.b, ByCondition.c);
        }).start();

        new Thread(()->{
            byCondition.print(2, "C", ByCondition.c, ByCondition.a);
        }).start();

    }
}
