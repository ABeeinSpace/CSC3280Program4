/*
 USING LATE PASS
 Aidan Border
 11/10/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
 99
*/

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

        int totalMinutes = 0;

        FSCcarCleanQ custQueue = new FSCcarCleanQ(maxQueueSize);

//        in.nextLine(); // Consuming a hanging newline here to avoid possible unexpected behavior from the scanner.
        //endregion

        System.out.println("Welcome to the FSC Car Clean Simulator\n");

        do {
            int timeForWash = in.nextInt();
            int timeForWax = in.nextInt();
            int timeForVacuum = in.nextInt();
            int numMinutes = 0;
            in.nextLine();

            String numCustomersString = in.nextLine();
            int numCustomers = Integer.parseInt(numCustomersString);

            FSCvouchers vouchersStack = new FSCvouchers(numCustomers + 20);

            System.out.printf("**********\n");
            System.out.printf("Day %d:\n", numDaysSimulated + 1);
            System.out.printf("**********\n\n");

            FSCcarCleanQ outsideLine = setupOutsideLine(in, numCustomers, timeForWash, timeForWax, timeForVacuum);
            FSCmember customerBeingServiced = outsideLine.dequeque();
            if (customerBeingServiced.getCode().equals("Z")) {
                minionActions(vouchersStack, customerBeingServiced.getArrivalTime());
                numMinutes = customerBeingServiced.getArrivalTime();
            }
            customerBeingServiced = outsideLine.dequeque();
            System.out.printf("%s  %s %s arrived at the FSC Car Clean and immediately started Class %s service\n",
                    computeCurrentTime(customerBeingServiced.getArrivalTime()), customerBeingServiced.getFirstName(),
                    customerBeingServiced.getLastName(), customerBeingServiced.getCode());
            custQueue.enqueue(customerBeingServiced);
            FSCvoucher customerVoucher = new FSCvoucher(customerBeingServiced.getArrivalTime(),
                    customerBeingServiced.getID(), customerBeingServiced.getFirstName(),
                    customerBeingServiced.getLastName(),
                    customerBeingServiced.getCode());
            vouchersStack.push(customerVoucher);
            customerVoucher.setTimeStarted(customerBeingServiced.getArrivalTime());
            numMinutes = customerVoucher.getArrivalTime();

            while (numMinutes <= 361 || !custQueue.isEmpty()) {
                if (outsideLine.peek() != null) {
                    if (customerBeingServiced.getMinutesRemaining() == 0) {
                        if (!customerBeingServiced.didFinishWork) {
                            customerBeingServiced.didFinishWork = true;
                            vouchersStack.peek().setTimeFinished(numMinutes);
                            System.out.println(vouchersStack.peek().printFinishedMessage(computeCurrentTime(numMinutes)));
                        }

                        if (outsideLine.peek().getCode().equals("Z")) {
                            minionActions(vouchersStack, numMinutes);
                            numMinutes++;
                            continue;
                        }

                        if (numMinutes == outsideLine.peek().getArrivalTime() && custQueue.isEmpty()) {
                            customerBeingServiced = outsideLine.dequeque();
                            if (customerBeingServiced.getCode().equals("Z")) {
                                minionActions(vouchersStack, numMinutes);
                            }
                            System.out.printf("%s  %s %s arrived at the FSC Car Clean and immediately started Class " +
                                            "%s" +
                                            " " +
                                    "service\n", computeCurrentTime(numMinutes), customerBeingServiced.getFirstName(),
                                    customerBeingServiced.getLastName(), customerBeingServiced.getCode());
                            customerVoucher = new FSCvoucher(customerBeingServiced.getArrivalTime(),
                                    customerBeingServiced.getID(), customerBeingServiced.getFirstName(),
                                    customerBeingServiced.getLastName(),
                                    customerBeingServiced.getCode());
                            vouchersStack.push(customerVoucher);
                            customerBeingServiced.setTimeStarted(numMinutes);
                            vouchersStack.peek().setTimeStarted(numMinutes);
                        } else if (!custQueue.isEmpty()) {
                            customerBeingServiced = custQueue.dequeque();
                            if (customerBeingServiced.getCode().equals("Z")) {
                                minionActions(vouchersStack, numMinutes);
                                numMinutes++;
                                continue;
                            }
                            customerBeingServiced.setTimeStarted(numMinutes);
                            System.out.printf("%s  %s %s has started class %s service\n",
                                    computeCurrentTime(numMinutes),
                                    customerBeingServiced.getFirstName(), customerBeingServiced.getLastName(),
                                    customerBeingServiced.getCode());
                            customerVoucher = new FSCvoucher(customerBeingServiced.getArrivalTime(),
                                    customerBeingServiced.getID(), customerBeingServiced.getFirstName(),
                                    customerBeingServiced.getLastName(),
                                    customerBeingServiced.getCode());
                            vouchersStack.push(customerVoucher);
                        }
                    }

                    if (!outsideLine.isEmpty() && numMinutes == outsideLine.peek().getArrivalTime()) {
                        FSCmember cust = outsideLine.dequeque();
                        if (cust.getCode().equals("Z")) {
                            minionActions(vouchersStack, numMinutes);
                            while(outsideLine.peek() != null && numMinutes == outsideLine.peek().getArrivalTime()) {
                                cust = outsideLine.dequeque();
                                custQueue.enqueue(cust);
                                System.out.printf("%s  %s %s arrived at the FSC Car Clean and was placed into the " +
                                                "Wash Queue\n", computeCurrentTime(numMinutes),
                                        custQueue.peek().getFirstName(), custQueue.peek().getLastName());
                                cust.setArrivalTime(numMinutes);
                            }
                        }
                        if (custQueue.getNumCustomers() + 1 >= maxQueueSize) {
                            System.out.printf("%s  %s %s arrived at the FSC Car Clean. Unfortunately, the Wash Queue " +
                                    "is " +
                                    "full, and the customer left disappointed.\n", computeCurrentTime(numMinutes),
                                    cust.getFirstName(),
                                    cust.getLastName());
                        } else {
                            custQueue.enqueue(cust);
                            cust.setArrivalTime(numMinutes);
                            System.out.printf("%s  %s %s arrived at the FSC Car Clean and was placed into the Wash " +
                                            "Queue\n", computeCurrentTime(numMinutes),
                                    cust.getFirstName(), cust.getLastName());
                            while(outsideLine.peek() != null && numMinutes == outsideLine.peek().getArrivalTime()) {
                                cust = outsideLine.dequeque();
                                custQueue.enqueue(cust);
                                System.out.printf("%s %s %s arrived at the FSC Car Clean and was placed into the " +
                                                "Wash Queue\n", computeCurrentTime(numMinutes),
                                        custQueue.peek().getFirstName(), custQueue.peek().getLastName());
                                cust.setArrivalTime(numMinutes);
                            }
                        }
                    }


                } else {
                    break;
                }
                if (customerBeingServiced.getMinutesRemaining() != 0) {
                    customerBeingServiced.setMinutesRemaining(customerBeingServiced.getMinutesRemaining() - 1);
                }


                numMinutes++;
            }
            minionActions(vouchersStack, numMinutes);
            numDaysSimulated++;

        } while (numDaysSimulated < numDays);
    }


    /* minionActions()
     * Parameters: FSCvouchers voucherStack, int numMinutes
     * Returns: N/A ()
     * Description: Simulates the actions of the Lowly Minion*/
    public static void minionActions(FSCvouchers voucherStack, int numMinutes) {
        if (voucherStack.isEmpty() || voucherStack.peek() == null) {
            System.out.println(computeCurrentTime(numMinutes) + "  LOWLY Minion came but found the box empty");
            return;
        }
        System.out.println(computeCurrentTime(numMinutes) + "  LOWLY Minion came and collected the following " +
                "vouchers:");
        voucherStack.printStack();
        voucherStack.clearStack();
    }

    /* setupOutsideLine()
     * Parameters: Scanner in, int numCustomers, int timeForWash, int timeForWax, int timeForVacuum
     * Returns: An FSCcarCleanQ object
     * Description: Setup for the Outside Line before each program run*/
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
            outsideLine.enqueue(customer);
        }
        return outsideLine;
    }

    /* computeCurrentTime()
     * Parameters: int numMinutesElapsed
     * Returns: String (main() never returns anything)
     * Description: This method performs some Math Silliness to get the current time in HH:mm for output */
    public static String computeCurrentTime(int numMinutesElapsed) {
        int numHours = numMinutesElapsed / 60;
        int numMinutes = numMinutesElapsed % 60;
        String numMinutesString = String.format("%d", numMinutes);
        String currentTime;

        if (numHours >= 2) {
            if (numMinutesString.length() == 1) {
                currentTime = String.format("%2d:0%1d PM:", numHours + 10, numMinutes);
            } else {
                currentTime = String.format("%2d:%2d PM:", numHours + 10, numMinutes);
            }
        } else {
            if (numMinutesString.length() == 1) {
                currentTime = String.format("%2d:0%1d AM:", numHours + 10, numMinutes);
            } else {
                currentTime = String.format("%2d:%1d AM:", numHours + 10, numMinutes);
            }
        }

        return currentTime;
    }

    /* computeMinutesRemaining()
     * Parameters: String[] args
     * Returns: N/A (main() never returns anything)
     * Description: This method computes how much time is needed for each car */
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