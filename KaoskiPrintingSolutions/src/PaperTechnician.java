import java.util.concurrent.Semaphore;

/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class PaperTechnician extends Thread {

    // his/her printer;
    private LaserPrinter printer;
    private Semaphore semaphore; // TODO : SEMAPHORE CODE



    PaperTechnician(String technicianName, LaserPrinter printer, ThreadGroup threadGroup, Semaphore semaphore) {
        super(threadGroup, "Thread:" + technicianName);

        this.semaphore = semaphore; // TODO : SEMAPHORE CODE

        this.printer = printer;
    }


    @Override
    public void run() {

        try { // TODO : SEMAPHORE CODE
            semaphore.acquire();
            try{
                for (int i = 0; i < 3; i++) {
                    printer.refillPaper();
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


        /*for (int i = 0; i < 3; i++) {
            printer.refillPaper();
            try {
                sleep(Utilities.timeRandomizer()); // Sleeping for random time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
