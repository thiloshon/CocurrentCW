/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class Student extends Thread {
    // thread group he/she is in;
    private ThreadGroup threadGroup;

    // his/her printer;
    private LaserPrinter printer;

    // his/her name
    private String studentName;

    public Student(String studentName, LaserPrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + studentName);

        this.printer = printer;
        this.studentName = studentName;
        this.threadGroup = threadGroup;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5 ; i ++){
            Document CWK = new Document(studentName, "cwk" + i, (int) (Math.random() * 25));
            printer.printDocument(CWK);

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
