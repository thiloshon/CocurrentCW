/**
 * *************************************************************
 * File:	  PaperTechnician.java (Class)
 * Author:	  Thiloshon
 * Contents:  6SENG002W CWK
 * This provides the thread behaviour of students.
 * Date:	  25-Nov-18
 * Version:	  1.0
 * *************************************************************
 */
public class Student extends Thread {

    // his/her printer;
    private LaserPrinter printer;

    // his/her name
    private String studentName;

    Student(String studentName, LaserPrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + studentName);

        this.printer = printer;
        this.studentName = studentName;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
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
