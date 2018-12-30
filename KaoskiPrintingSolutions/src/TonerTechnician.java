import java.util.concurrent.Semaphore;

/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class TonerTechnician extends Thread{

    // his/her printer;
    private LaserPrinter printer;

    private Semaphore semaphore;

    TonerTechnician(String technicianName, LaserPrinter printer, ThreadGroup threadGroup, Semaphore semaphore) {
        super(threadGroup, "Thread:" + technicianName);

        this.semaphore = semaphore;
        this.printer = printer;
    }


    @Override
    public void run() {
        try { // TODO : SEMAPHORE CODE
            semaphore.acquire();
            try{
                for (int i = 0; i < 3; i++) {
                    printer.replaceTonerCartridge();
                    try {
                        sleep(Utilities.timeRandomizer()); // Sleeping for random time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


       /* for (int i = 0; i < 3; i++) {
            printer.replaceTonerCartridge();
            try {
                sleep(Utilities.timeRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }
    
}
