import java.util.concurrent.locks.ReentrantLock;

public class print {
    static int i = 1;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Runnable r1 = ()->{
            while (i < 101) {
                if (lock.tryLock()) {
                    if (i % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + i++);
                    }
                    lock.unlock();
                }
            }
        };
        Runnable r2 = ()->{
            while (i < 101) {
                if (lock.tryLock()) {
                    if (i % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + ": " + i++);
                    }
                    lock.unlock();
                }
            }
        };

        Runnable r3 = ()->{
            while (i < 101) {
                if (lock.tryLock()) {
                    if (i % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i++);
                    }
                    lock.unlock();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }
}
