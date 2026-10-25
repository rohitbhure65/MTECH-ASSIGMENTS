
package Thread_Synchronization;

public class App extends Thread {

    synchronized public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        App obj = new App();

        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);

        t1.start();
        t2.start();
    }
}
