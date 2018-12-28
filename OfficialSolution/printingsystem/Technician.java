/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

/**
 *
 * @author RJ
 */
public class Technician extends Thread {

    protected LaserPrinter printer;
    protected String name;

    // the default constructor for the technician class
    public Technician(String name, ThreadGroup group, LaserPrinter printer) {
        super(group, name);
        this.printer = printer;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
