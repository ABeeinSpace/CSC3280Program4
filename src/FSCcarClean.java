import java.util.Scanner;

public class FSCcarClean {

    /*Main()
    * Parameters: String[] args
    * Returns: N/A (main() never returns anything)
    * Description: Core method for program execution. Java will run this method automatically when we press the big
    * green button */
    public static void main(String[] args) {

        //region Before Sim Start Setup
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

        FSCcarCleanQ custQueue = new FSCcarCleanQ();
        FSCcarCleanQ outsideLine = new FSCcarCleanQ();

        in.nextLine(); // Consuming a hanging newline here to avoid possible unexpected behavior from the scanner.
        //endregion

        do {
            FSCmember newCustomer = addNewCustomer(in, timeForWash, timeForWax, timeForVacuum);
            custQueue.enqueue(newCustomer);
            while (totalMinutes < 361 || !custQueue.isEmpty()) {

                custQueue.peek().setMinutesRemaining(custQueue.peek().getMinutesRemaining() - 1);
                if (custQueue.peek().isServiceCompleted()) {
                    custQueue.dequeque();
                }
                totalMinutes++;
            }

        } while (numDaysSimulated < numDays);
    }

    public static FSCmember addNewCustomer(Scanner in, int timeForWash, int timeForWax, int timeForVacuum) {
        String[] nextCustomer = in.nextLine().split(" ");
        int arrivalTime = Integer.parseInt(nextCustomer[0]);

        int ID = Integer.parseInt(nextCustomer[1]);
        String firstName = nextCustomer[2];
        String lastName = nextCustomer[3];
        String servicesRequested = nextCustomer[4];
        int minutesRemaining = computeMinutesRemaining(servicesRequested, timeForWash, timeForWax, timeForVacuum);

        FSCmember customerVoucher = new FSCmember(arrivalTime, ID, firstName, lastName, servicesRequested,
                minutesRemaining);
        return customerVoucher;
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
