import java.util.Scanner;

public class FSCcarClean {

    /*Main()
    * Parameters: String[] args
    * Returns: N/A (main() never returns anything)
    * Description: Core method for program execution. Java will run this method automatically when we press the big
    * green button */
    public static void main(String[] args) {

        //region Before Sim Setup
        Scanner in = new Scanner(System.in);

        String maxQueueSizeString = in.nextLine();
        int maxQueueSize = Integer.parseInt(maxQueueSizeString);


        String numDaysString = in.nextLine();
        int numDays = Integer.parseInt(numDaysString);
        int numDaysSimulated = 0;


        int timeForWash = in.nextInt();
        int timeForWax = in.nextInt();
        int timeForVacuum = in.nextInt();

        int totalMinutes = 0;

        int numCustomers = in.nextInt();

        FSCcarCleanQ custQueue = new FSCcarCleanQ(maxQueueSize);
        FSCcarCleanQ outsideLine = setupOutsideLine(in, numCustomers);

        FSCvouchers vouchersStack = new FSCvouchers();

        in.nextLine(); // Consuming a hanging newline here to avoid possible unexpected behavior from the scanner.
        //endregion

        do {
            System.out.printf("**********\n");
            System.out.printf("Day %d:", numDaysSimulated);
            System.out.printf("**********\n");

            while (totalMinutes < 361 && !custQueue.isEmpty() && !outsideLine.isEmpty()) {
                if (customerBeingServiced.isServiceCompleted()) {
                    customerBeingServiced = custQueue.dequeque(); //Departures are to be processed first if an arrival
                    // and departure occur in the same minute, so that's what this line is designed to facilitate.
                }

                if (custQueue.isEmpty()) {
                    if (totalMinutes == outsideLine.peek().getArrivalTime()) ;
                    customerBeingServiced = outsideLine.dequeque();
                }
                // If the queue is NOT empty, we need to add any customers that come in to the queue
                if (custQueue.peek().isServiceCompleted()) {
                    custQueue.dequeque();
                }
                totalMinutes++;
            }
            numDaysSimulated++;
        } while (numDaysSimulated < numDays);
    }

    public static FSCcarCleanQ setupOutsideLine(Scanner in, int numCustomers, int timeForWash, int timeForWax,
                                                int timeForVacuum) {
        FSCcarCleanQ outsideLine = new FSCcarCleanQ();
        for (int i = 0; i < numCustomers; i++) {
            String[] nextCustomer = in.nextLine().split(" ");
            int arrivalTime = Integer.parseInt(nextCustomer[0]);

            int ID = Integer.parseInt(nextCustomer[1]);
            String firstName = nextCustomer[2];
            String lastName = nextCustomer[3];
            String servicesRequested = nextCustomer[4];
            FSCmember customer = new FSCmember(arrivalTime, ID, firstName, lastName, servicesRequested,
                    computeMinutesRemaining(servicesRequested, timeForWash, timeForWax, timeForVacuum));

        }
        return outsideLine;
    }
    public static int computeMinutesRemaining(String servicesRequested, int timeForWash, int timeForWax, int timeForVacuum) {
        if (servicesRequested.equals("W")) {
            return timeForWash;
        } else if (servicesRequested.equals("WW")) {
            return timeForWash + timeForWax;
        } else if (servicesRequested.equals("WWV")) {
            return timeForWash + timeForWax + timeForVacuum;
        }
        return -1;
    }


}
