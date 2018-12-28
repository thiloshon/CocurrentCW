/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

/**
 *
 * @author RJ
 */
public class PrintingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          // declaring and initializing the two thread groups technician and student
       
        ThreadGroup studentGroup = new ThreadGroup("Student Thread Group");
        ThreadGroup technicianGroup = new ThreadGroup("Technician Thread Group");

        // the laser printer object
        LaserPrinter laserPrinter = new LaserPrinter("lp-N1-01", studentGroup);

        // the student and technician threads
        Student student1 = new Student("A", studentGroup, laserPrinter);
        Student student2 = new Student("B", studentGroup, laserPrinter);
        Student student3 = new Student("C", studentGroup, laserPrinter);
        Student student4 = new Student("D", studentGroup, laserPrinter);

        Technician paperTechnician = new PaperTechnician("T1",technicianGroup, laserPrinter);
        Technician tonerTechnician = new TonerTechnician("T2",technicianGroup,laserPrinter);
        
        // starting all threads
        student1.start();
        student2.start();
        student3.start();
        student4.start();
        paperTechnician.start();
        tonerTechnician.start();

        // wait for all the threads to complete
        try {
            student1.join();
            student2.join();
            student3.join();
            student4.join();
            paperTechnician.join();
            tonerTechnician.join();
        } catch (InterruptedException ex) {
             System.out.println(ex.toString());
        }


    }
}
