/**
 * *************************************************************
 * File:	  Utilities.java (Class)
 * Author:	  Thiloshon
 * Contents:  6SENG002W CWK
 * This provides the utility functions and alert strings.
 * Date:	  25-Nov-18
 * Version:	  1.0
 * *************************************************************
 */
class Utilities {

    final static String PRINTING_REQUEST_RECEIVED = "--- PRINTING_REQUEST_RECEIVED ---";
    final static String WAITING_FOR_PRINTING_RESOURCES = "--- WAITING_FOR_PRINTING_RESOURCES ---";
    final static String PRINTING_DOC_DONE = "--- PRINTING_DOC_DONE ---";
    final static String ENOUGH_PRINTING_RESOURCES = "--- ENOUGH_PRINTING_RESOURCES | OUT OF WAIT LOOP ---";
    final static String WAITING_FOR_PAPER_REQUEST = "--- ENOUGH_PAPER_DETECTED | WAITING_FOR_REFILL_REQUEST ---";
    final static String WAITING_FOR_TONER_REQUEST = "--- ENOUGH_TONER_DETECTED | WAITING_FOR_REFILL_REQUEST ---";
    final static String STUDENT_OUT = "--- STUDENT_OUT ---";
    final static String TONER_REPLACE_REQUEST_RECEIVED = "--- TONER_REPLACE_REQUEST_RECEIVED ---";
    final static String TONER_REPLACING = "--- TONER_REPLACING ---";
    final static String TONER_REPLACE_DONE = "--- TONER_REPLACE_DONE ---";
    final static String TONER_REPLACE_REQUEST_PROCESSED = "--- TONER_REPLACE_REQUEST_PROCESSED ---";
    final static String PAPER_REPLACE_REQUEST_RECEIVED = "--- PAPER_REPLACE_REQUEST_RECEIVED ---";
    final static String PAPER_REPLACING = "--- PAPER_REPLACING ---";
    final static String PAPER_REPLACE_DONE = "--- PAPER_REPLACE_DONE ---";
    final static String PAPER_REPLACE_REQUEST_PROCESSED = "--- PAPER_REPLACE_REQUEST_PROCESSED ---";


    static int timeRandomizer() {
        int seconds = (int) (Math.random() * 1000);

        System.out.println("TIMES: " + seconds);
        return seconds;
    }
}
