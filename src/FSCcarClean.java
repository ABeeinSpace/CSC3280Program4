import java.util.Scanner;

public class FSCcarClean {

    /*Main()
    * Parameters: String[] args
    * Returns: N/A (main() never returns anything)
    * Description: Core method for program execution. Java will run this method automatically when we press the big
    * green button */
    public static void main(String[] args) {
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

        in.nextLine(); // Consuming a hanging newline here to avoid possible unexpected behavior from the scanner.

        do {
            FSCcarCleanQ custQueue = new FSCcarCleanQ();
            while (totalMinutes < 361 || !custQueue.isEmpty()) {
                if (totalMinutes) {

                }
                String[] nextCustomer = in.nextLine().split(" ");
                int arrivalTime = Integer.parseInt(nextCustomer[0]);

                int ID = Integer.parseInt(nextCustomer[1]);
                String firstName = nextCustomer[2];
                String lastName = nextCustomer[3];
                String servicesRequested = nextCustomer[4];
                int minutesRemaining = computeMinutesRemaining(servicesRequested, timeForWash, timeForWax, timeForVacuum);

                FSCvoucher customerVoucher = new FSCvoucher(arrivalTime, ID, firstName, lastName, servicesRequested,
                        minutesRemaining);

            }

        } while (numDaysSimulated < numDays);
    }

    public static void addCar() {

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
