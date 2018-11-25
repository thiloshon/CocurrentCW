/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class Student {
    // thread group he/she is in;
    private ThreadGroup threadGroup;

    // his/her printer;
    private Printer printer;

    // his/her name
    private String studentName;

    public Student(String studentName, Printer printer, ThreadGroup threadGroup) {
        this.printer = printer;
        this.studentName = studentName;
        this.threadGroup = threadGroup;
    }

    void printDocument(){
        Document CWK1 = new Document( studentName, "cwk1", 20 );
        printer.printDocument( CWK1 ) ;

        try {
            Thread.sleep( (int)( Math.random() * 1000 ) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully printed " + CWK1.getDocumentName());



        Document CWK2 = new Document( studentName, "cwk2", 20 );
        printer.printDocument( CWK2 ) ;

        try {
            Thread.sleep( (int)( Math.random() * 1000 ) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully printed " + CWK2.getDocumentName());



        Document CWK3 = new Document( studentName, "cwk3", 20 );
        printer.printDocument( CWK3 ) ;

        try {
            Thread.sleep( (int)( Math.random() * 1000 ) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully printed " + CWK3.getDocumentName());



        Document CWK4 = new Document( studentName, "cwk4", 20 );
        printer.printDocument( CWK4 ) ;

        try {
            Thread.sleep( (int)( Math.random() * 1000 ) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully printed " + CWK4.getDocumentName());



        Document CWK5 = new Document( studentName, "cwk5", 20 );
        printer.printDocument( CWK5 ) ;

        try {
            Thread.sleep( (int)( Math.random() * 1000 ) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully printed " + CWK5.getDocumentName());


    }

}
