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

        int numCustomers = in.nextInt();

        in.nextLine(); // Consuming a hanging newline here to avoid possible unexpected behavior from the scanner.

        do {

        } while (numDaysSimulated < numDays);
    }

    public static void addCar() {

    }


}
