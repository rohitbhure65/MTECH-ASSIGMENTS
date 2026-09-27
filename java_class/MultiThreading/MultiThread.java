package MultiThreading;

// Method 1: extending Thread
class A extends Thread {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " ");
        }
    }
}

// Method 2: implementing Runnable (preferred — allows extending another
class B implements Runnable {
    public void run() {
        for (int i = 0; i <= 200; i++) {
            System.out.println(i + " ");

        }
    }
}

public class MultiThread {
    public static void main(String[] args) {

        A t1 = new A();
        t1.setPriority(Thread.MIN_PRIORITY); // Priority = 1

        Thread t2 = new Thread(new B());
        t2.setPriority(Thread.MAX_PRIORITY); // Priority = 10
        // t2.setPriority(Thread.MIN_PRIORITY); // Priority = 1
        // t2.setPriority(Thread.NORM_PRIORITY); // Priority = 5

        t1.start();
        t2.start();
    }
}
