/**
 * Created by Thiloshon on 25-Nov-18.
 */
public class LaserPrinter implements ServicePrinter {

    //printer's name/id
    private String printerName;

    // the current paper level,
    private String printerID;

    // the current toner level
    private int paperLevel = 250;

    // and the number of documents printed
    private int tonerLevel = 500;

    private final int MAX_PAPERS;
    private final int MAX_TONER;

    private final int PAPER_PER_PACK = 50;
    private final int TONER_REPLACE_VAL = 10;


    /**
     *
     * @param printerName
     * @param printerID
     * @param paperLevel
     * @param tonerLevel
     */
    public LaserPrinter(String printerName, String printerID, int paperLevel, int tonerLevel) {
        this.printerName = printerName;
        this.printerID = printerID;
        this.paperLevel = paperLevel;
        this.tonerLevel = tonerLevel;

        this.MAX_PAPERS = paperLevel;
        this.MAX_TONER = tonerLevel;
    }


    /**
     *
     * @param document
     */
    @Override
    public synchronized void printDocument(Document document) {
        int documentPages = document.getNumberOfPages();

        if (paperLevel >= documentPages && tonerLevel >= documentPages){
            System.out.println("PRINTING " + document.getUserID() + "'s" +  document.getDocumentName() + " of pages " + document.getNumberOfPages() +"...");
            paperLevel-=documentPages;
            tonerLevel-=documentPages;
            System.out.println("PRINTED...");

            System.out.println(toString());

        } else {
            // can't print, wait for refill
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll() ;
    }

    @Override
    public synchronized void replaceTonerCartridge() {
        if (tonerLevel < TONER_REPLACE_VAL){
            // toner replace
            tonerLevel += MAX_TONER;
            System.out.println("Replacing Toner");
            System.out.println(toString());
        } else {
            // toner wastage
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll() ;
    }

    @Override
    public synchronized void refillPaper() {
        if (paperLevel + PAPER_PER_PACK > MAX_PAPERS){
            // paper overfill
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            // refill
            paperLevel+=PAPER_PER_PACK;
            System.out.println("Replacing Paper");
            System.out.println(toString());

        }
        notifyAll() ;
    }

    @Override
    public synchronized String toString() {
        return "LaserPrinter{" +
                "printerName='" + printerName + '\'' +
                ", printerID='" + printerID + '\'' +
                ", paperLevel=" + paperLevel +
                ", tonerLevel=" + tonerLevel +
                ", MAX_PAPERS=" + MAX_PAPERS +
                ", MAX_TONER=" + MAX_TONER +
                ", PAPER_PER_PACK=" + PAPER_PER_PACK +
                ", TONER_REPLACE_VAL=" + TONER_REPLACE_VAL +
                '}';
    }
}
