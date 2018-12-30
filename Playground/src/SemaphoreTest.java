import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    // max 4 people
    static Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {

        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyATMThread t1 = new MyATMThread("A", semaphore);
        t1.start();

        MyATMThread t2 = new MyATMThread("B", semaphore);
        t2.start();

        MyATMThread t3 = new MyATMThread("C", semaphore);
        t3.start();

        MyATMThread t4 = new MyATMThread("D", semaphore);
        t4.start();

        MyATMThread t5 = new MyATMThread("E", semaphore);
        t5.start();

        MyATMThread t6 = new MyATMThread("F", semaphore);
        t6.start();

    }
}