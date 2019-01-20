import java.util.concurrent.Semaphore;


public class PC {
    public static void main(String[] a) {
        Q q = new Q();

        new Consumer(q);
        new Producer(q);
    }
}


class Q {
    int item;

    static Semaphore semCom = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCom.acquire();
        } catch (InterruptedException e) {
        }

        // consume

        semProd.release();
    }

    void put(int item) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {

        }

        this.item = item;

        semCom.release();
    }


}


class Producer implements Runnable {

    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            q.put(i);
        }
    }
}


class Consumer implements Runnable {

    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            q.get();
        }
    }
}

