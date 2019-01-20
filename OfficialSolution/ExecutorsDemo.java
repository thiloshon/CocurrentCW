import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Thiloshon on 18-Jan-19.
 */
public class ExecutorsDemo {
    public static void main(String[] a ){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable1 = () -> {
            System.out.println();
        };


        executorService.submit(runnable);
        executorService.submit(runnable1);

    }
}
