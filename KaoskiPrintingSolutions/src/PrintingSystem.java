/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class PrintingSystem {

    public static void main(String[] params) {
        ThreadGroup studentThreads = new ThreadGroup("StudentGroup");
        ThreadGroup technicianThreads = new ThreadGroup("TechnicianGroup");

        LaserPrinter hpInkJet3200 = new LaserPrinter("hpInkJet3200", "printer001", studentThreads);

        Student student1 = new Student("Andy", hpInkJet3200, studentThreads);
        Student student2 = new Student("Broody", hpInkJet3200, studentThreads);
        Student student3 = new Student("Cindi", hpInkJet3200, studentThreads);
        Student student4 = new Student("Deppy", hpInkJet3200, studentThreads);

        PaperTechnician paperTechnician = new PaperTechnician("Philly", hpInkJet3200, technicianThreads);
        TonerTechnician tonerTechnician = new TonerTechnician("Tony", hpInkJet3200, technicianThreads);


        student1.start();
        student2.start();
        student3.start();
        student4.start();

        paperTechnician.start();
        tonerTechnician.start();

        /*try {
            student1.join();
            student2.join();
            student3.join();
            student4.join();
            paperTechnician.join();
            tonerTechnician.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // Thread myThread = new Thread( myThreadGroup, "Thread_A_1") ;');
    }
}
