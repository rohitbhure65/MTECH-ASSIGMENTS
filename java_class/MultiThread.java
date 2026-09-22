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
        // Thread Class
        System.out.println("Method 1 using Thread Class");
        A t1 = new A();
        t1.start();

        // Runnable Interface
        System.out.println("Method 2 using Runnable interface");
        Thread t2 = new Thread(new B());
        t2.start();
    }
}
