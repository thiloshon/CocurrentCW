/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsystem;

/**
 *
 * @author RJ
 */
public class LaserPrinter implements ServicePrinter {

    private int currentPapers;
    private int currentToner;
    private int printedDocs;
    private final String printerName;
    private ThreadGroup students;

    public LaserPrinter(String printerName, ThreadGroup students) {
        this.printerName = printerName;
        this.currentPapers = ServicePrinter.Full_Paper_Tray;
        this.currentToner = ServicePrinter.Full_Toner_Level;
        this.printedDocs = 0;
        this.students=students;
                

    }

    @Override
    public String toString() {
        return "LaserPrinter{" + "currentPapers=" + currentPapers + ", currentToner=" + currentToner + ", printedDocs=" + printedDocs + ", printerName=" + printerName + '}';
    }

    @Override
    public synchronized void replaceTonerCartridge() {

        while (this.currentToner > LaserPrinter.Minimum_Toner_Level) {
            try {
                 if (this.checkStudentAvailability()) {
                 displayMessage(5, 0);
                 wait(5000);
                 } else {
                  displayMessage(7, 0);
                 break;
                 }

            } catch (InterruptedException ex) {
                  System.out.println(ex.toString());
            }
        }

        if (this.currentToner < LaserPrinter.Minimum_Toner_Level) {
            this.currentToner = LaserPrinter.Full_Toner_Level;
            displayMessage(6, 0);
        }
        notifyAll();

    }

    @Override
    public synchronized void refillPaper() {

        while (this.currentPapers + LaserPrinter.SheetsPerPack > LaserPrinter.Full_Paper_Tray) {
            try {
                if (this.checkStudentAvailability()) {
                    displayMessage(3, 0);
                    wait(5000);
                 } else {
                  displayMessage(7, 0);
                 break;
                 }
               

            } catch (InterruptedException ex) {
                  System.out.println(ex.toString());
            }
        }

        if (this.currentPapers + LaserPrinter.SheetsPerPack < LaserPrinter.Full_Paper_Tray) {
            int newLevel = this.currentPapers += LaserPrinter.SheetsPerPack;
            this.displayMessage(4, newLevel);

        }

        notifyAll();
    }

    @Override
    public synchronized void printDocument(Document document) {

        
        displayMessage(0, 0);

        // wait until there is enough of resources to print
        while (this.currentPapers < document.getNumberOfPages() || this.currentToner < document.getNumberOfPages()) {
            try {
                this.displayMessage(1, 0);
                wait();
            } catch (InterruptedException ex) {
                 System.out.println(ex.toString());
            }
        }

        // check if the printer has the sufficient resources to print the document
        if (this.currentPapers > document.getNumberOfPages() && this.currentToner > document.getNumberOfPages()) {
            currentPapers -= document.getNumberOfPages();
            currentToner -= document.getNumberOfPages();
            printedDocs += 1;
            displayMessage(2, 0);
        }

        this.displayMessage(0, 0);

        // notify all other threads
        notifyAll();

    }
    
    
     private boolean checkStudentAvailability() {
         if(students.activeCount()>0){
             return true;
         } 
         else{
             return false;
         }
        
    }

    public void displayMessage(int message, int count) {

        switch (message) {

            case 0:
                System.out.println(this.toString());
                break;
            case 1:
                System.out.println("Waiting for printing");
                break;
            case 2:
                System.out.println("Printing sucessfull");
                break;
            case 3:
                System.out.println("Wait for paper addiotion");
                break;
            case 4:
                System.out.println("Paper addition sucessfull");
                break;
                case 5:
                System.out.println("Wait for replace toner");
                break;
            case 6:
                System.out.println("Toner replacing successfull");
                break;
            case 7:
                System.out.println("Student finished priting process");
                break;


        }


    }
}
