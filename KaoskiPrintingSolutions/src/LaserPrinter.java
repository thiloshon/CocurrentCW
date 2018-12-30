/**
 * *************************************************************
 * File:	  LaserPrinter.java (Class)
 * Author:	  Thiloshon
 * Contents:  6SENG002W CWK
 * This provides the functions of printer. (Acts as the thread monitor)
 * Date:	  25-Nov-18
 * Version:	  1.0
 * *************************************************************
 */
public class LaserPrinter implements ServicePrinter {

    //printer's name/id
    private String printerName;

    //printer's name/id
    private String printerID;

    // the current paper level
    private int currentPaperLevel = ServicePrinter.Full_Paper_Tray;

    // the current toner level
    private int currentTonerLevel = ServicePrinter.Full_Toner_Level;

    // and the number of documents printed
    private int printedDocuments = 0;

    // Thread Group students belong to
    private ThreadGroup students;


    /**
     * @param printerName
     * @param printerID
     */
    LaserPrinter(String printerName, String printerID, ThreadGroup students) {
        this.printerName = printerName;
        this.printerID = printerID;

        this.students = students;
    }


    /**
     * @param document
     */
    @Override
    public synchronized void printDocument(Document document) {
        message(Utilities.PRINTING_REQUEST_RECEIVED);

        int documentPages = document.getNumberOfPages();

        while (!hasEnoughPaperToners(documentPages)) { // The guarded action
            try {
                message(Utilities.WAITING_FOR_PRINTING_RESOURCES);
                wait(); // Insufficient resources. Wait till it's refilled.

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message(Utilities.ENOUGH_PRINTING_RESOURCES);

        // Printing
        currentPaperLevel -= documentPages;
        currentTonerLevel -= documentPages;
        printedDocuments += 1;

        message("PRINTING " + document.getUserID() + "'s" + document.getDocumentName() + " of pages " + document.getNumberOfPages() + "...");
        message(toString());
        message(Utilities.PRINTING_DOC_DONE);

        notifyAll();
    }


    @Override
    public synchronized void replaceTonerCartridge() {
        message(Utilities.TONER_REPLACE_REQUEST_RECEIVED);

        while (hasEnoughToners()) { // can cause deadlock, issue in the logic
            try {
                if (stillPrinting()) { // Still students are using printer
                    message(Utilities.WAITING_FOR_TONER_REQUEST);
                    wait(5000);
                } else {
                    // No student waiting. Can stop concurrent loop
                    message(Utilities.STUDENT_OUT);
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!hasEnoughToners()) {
            // toner replace
            message(Utilities.TONER_REPLACING);
            currentTonerLevel = ServicePrinter.Full_Toner_Level;
            System.out.println("Replacing Toner");
            message(Utilities.TONER_REPLACE_DONE);
        }

        message(Utilities.TONER_REPLACE_REQUEST_PROCESSED);
        notifyAll();
    }

    @Override
    public synchronized void refillPaper() {
        message(Utilities.PAPER_REPLACE_REQUEST_RECEIVED);

        while (paperWillOverfill()) {
            // paper overfill
            try {
                if (stillPrinting()) { // Still student is using printer
                    message(Utilities.WAITING_FOR_PAPER_REQUEST);
                    wait(5000);
                } else {
                    // No student waiting. Can stop concurrent loop
                    message(Utilities.STUDENT_OUT);
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!paperWillOverfill()) {
            // refill
            message(Utilities.PAPER_REPLACING);
            currentPaperLevel += ServicePrinter.SheetsPerPack;
            System.out.println("Replacing Paper");
            System.out.println(toString());
            message(Utilities.PAPER_REPLACE_DONE);
        }

        message(Utilities.PAPER_REPLACE_REQUEST_PROCESSED);
        notifyAll();
    }


    // -------------------- SUPPORT FUNCTIONS -------------------------

    private boolean stillPrinting() {
        return students.activeCount() > 0;
    }

    private boolean hasEnoughPaperToners(int documentPages) {
        return currentPaperLevel >= documentPages || currentTonerLevel >= documentPages;
    }

    private boolean hasEnoughToners() {
        return currentTonerLevel > ServicePrinter.Minimum_Toner_Level;
    }

    private boolean paperWillOverfill() {
        return currentPaperLevel + ServicePrinter.SheetsPerPack > ServicePrinter.Full_Paper_Tray;
    }

    private void message(String msg) {
        System.out.println(msg);
    }

    @Override
    public String toString() {
        return "LaserPrinter{" +
                "printerName='" + printerName + '\'' +
                ", printerID='" + printerID + '\'' +
                ", currentPaperLevel=" + currentPaperLevel +
                ", currentTonerLevel=" + currentTonerLevel +
                ", printedDocuments=" + printedDocuments +
                ", students=" + students +
                '}';
    }
}
