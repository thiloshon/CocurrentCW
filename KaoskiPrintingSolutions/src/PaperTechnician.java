/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class PaperTechnician extends Thread {
    // thread group he/she is in;
    //private ThreadGroup threadGroup;

    // his/her printer;
    private LaserPrinter printer;

    // his/her name
    //private String technicianName;

    public PaperTechnician(String technicianName, LaserPrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + technicianName);

        //this.threadGroup = threadGroup;
        this.printer = printer;
        //this.technicianName = technicianName;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            printer.refillPaper();
            try {
                sleep(Utilities.timeRandomizer()); // Sleeping for random time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
