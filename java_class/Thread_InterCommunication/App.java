package Thread_InterCommunication;

public class App {

    // Shared object jiske through t1 aur t2 aapas me baat karenge
    static class SharedResource {

        // t1 is method ko call karke wait karega
        synchronized void waitForSignal() {
            System.out.println("t1: Kaam shuru kiya, ab wait() kar raha hu...");
            try {
                wait(); // t1 yaha ruk jayega aur lock chhod dega
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("t1: t2 se notification mil gayi! Kaam complete ho gaya.");
        }

        // t2 is method ko call karke notify karega
        synchronized void sendSignal() {
            try {
                Thread.sleep(1000); // 1 sec wait taaki pehle t1 wait() state me chala jaye
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println("t2: Maine apna kaam kar liya, ab t1 ko notify() kar raha hu.");
            notify(); // t1 ko signal bhej diya
        }
    }

    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        // Thread t1: wait karega
        Thread t1 = new Thread(() -> {
            obj.waitForSignal();
        });

        // Thread t2: notify karega
        Thread t2 = new Thread(() -> {
            obj.sendSignal();
        });

        t1.start();
        t2.start();
    }
}
