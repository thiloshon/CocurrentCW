/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class TonerTechnician extends Thread{
    // thread group he/she is in;
    private ThreadGroup threadGroup;

    // his/her printer;
    private LaserPrinter printer;

    // his/her name
    private String technicianName;

    public TonerTechnician(String technicianName, LaserPrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + technicianName);

        this.threadGroup = threadGroup;
        this.printer = printer;
        this.technicianName = technicianName;
    }


    @Override
    public void run() {
        while (true){
            printer.replaceTonerCartridge();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // TODO

    }
    
}
