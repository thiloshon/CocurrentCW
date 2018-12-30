import java.util.concurrent.Semaphore;

/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class Student extends Thread {

    // his/her printer;
    private LaserPrinter printer;

    // his/her name
    private String studentName;

    private Semaphore semaphore;

    Student(String studentName, LaserPrinter printer, ThreadGroup threadGroup, Semaphore semaphore) {
        super(threadGroup, "Thread:" + studentName);

        this.semaphore = semaphore;
        this.printer = printer;
        this.studentName = studentName;
    }

    @Override
    public void run() {

        try { // TODO : SEMAPHORE CODE
            semaphore.acquire();
            try{
                for (int i = 0; i < 5 ; i ++){
                    Document CWK = new Document(studentName, "cwk" + i, (int) (Math.random() * 250));
                    printer.printDocument(CWK);

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



        /*for (int i = 0; i < 5 ; i ++){
            Document CWK = new Document(studentName, "cwk" + i, (int) (Math.random() * 25));
            printer.printDocument(CWK);

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }

}
