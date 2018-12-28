/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

import java.util.Random;

/**
 *
 * @author RJ
 */
public class Student extends Thread {
    
    private LaserPrinter printer;
    
    public Student(String threadName, ThreadGroup group, LaserPrinter printer) {
        super(group, threadName);
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Document doc = new Document(this.getName(), "DOC "+i + i, RandomPageNumGenerator());
            this.printer.printDocument(doc);
            System.out.println(this);

            try {
                sleep(RandomSleepTimeGenerator());
            } catch (InterruptedException ex) {
                 System.out.println(ex.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Student Name : " + this.getName() + "\t" + "Finish printing doc";
    }
    
    public int RandomPageNumGenerator(){
        
        Random ran=new Random();
        int random=ran.nextInt(25 - 10 + 1) + 10;
        return random;
        
    }
    
     public int RandomSleepTimeGenerator(){
        
        Random ran=new Random();
        int random=ran.nextInt(2000 - 1000 + 1) + 1000;
        return random;
    }
    
}
