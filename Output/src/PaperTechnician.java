/**
 * *************************************************************
 * File:	  PaperTechnician.java (Class)
 * Author:	  Thiloshon
 * Contents:  6SENG002W CWK
 * This provides the functions of paper technician.
 * Date:	  25-Nov-18
 * Version:	  1.0
 * *************************************************************
 */
public class PaperTechnician extends Thread {
    // thread group he/she is in;
    //private ThreadGroup threadGroup;

    // his/her printer;
    private LaserPrinter printer;

    // his/her name
    //private String technicianName;

    PaperTechnician(String technicianName, LaserPrinter printer, ThreadGroup threadGroup) {
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
