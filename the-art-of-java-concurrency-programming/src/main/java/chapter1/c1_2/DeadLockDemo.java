package chapter1.c1_2;

/**
 * @author: Harry Zhang
 * @since: 16/Feb/2023
 */
public class DeadLockDemo {

    private static String A = "A";

    private static String B = "B";

    /**
     * 锁A, B互相等待
     */
    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B) {
                    synchronized(A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
