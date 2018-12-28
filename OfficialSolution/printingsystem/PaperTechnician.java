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
public class PaperTechnician extends Technician{
    
    // constructor for the paper technician class
    public PaperTechnician(String name, ThreadGroup group, LaserPrinter printer) {
		
		// calling the parent constructor
        super(name, group, printer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
				// call the method that tries to refill papers
                this.printer.refillPaper();
				
				// sleep the current thread for a random amount of time
                sleep(RandomSleepTimeGenerator());
            } catch (InterruptedException ex) {
               System.out.println(ex.toString());
            }
        }
    }
    
     public int RandomSleepTimeGenerator(){
        
        Random ran=new Random();
        int random=ran.nextInt(2000 - 1000 + 1) + 1000;
        return random;
    }
}
