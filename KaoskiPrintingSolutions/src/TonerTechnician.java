/**
 * *************************************************************
 * File:	  PaperTechnician.java (Class)
 * Author:	  Thiloshon
 * Contents:  6SENG002W CWK
 * This provides the functions of toner technician.
 * Date:	  25-Nov-18
 * Version:	  1.0
 * *************************************************************
 */
public class TonerTechnician extends Thread {

    // his/her printer;
    private LaserPrinter printer;

    TonerTechnician(String technicianName, LaserPrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + technicianName);

        this.printer = printer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            printer.replaceTonerCartridge();
            try {
                sleep(Utilities.timeRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
