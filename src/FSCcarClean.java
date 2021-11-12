/*
 Aidan Border
 11/10/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
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

        do {
            int timeForWash = in.nextInt();
            int timeForWax = in.nextInt();
            int timeForVacuum = in.nextInt();
            in.nextLine();

            String numCustomersString = in.nextLine();
            int numCustomers = Integer.parseInt(numCustomersString);

            FSCvouchers vouchersStack = new FSCvouchers(numCustomers + 1);

            System.out.printf("**********\n");
            System.out.printf("Day %d:\n", numDaysSimulated + 1);
            System.out.printf("**********\n");

            FSCcarCleanQ outsideLine = setupOutsideLine(in, numCustomers, timeForWash, timeForWax, timeForVacuum,
                    vouchersStack);
            FSCmember customerBeingServiced = outsideLine.dequeque();
            FSCvoucher customerVoucher = new FSCvoucher(customerBeingServiced.arrivalTime,
                    customerBeingServiced.ID, customerBeingServiced.firstName,
                    customerBeingServiced.lastName,
                    customerBeingServiced.code);
            vouchersStack.push(customerVoucher);
            customerVoucher.setTimeStarted(0);
            for (int i = 0; i < 361; i++) {
                if (outsideLine.peek() != null) {
                    if (customerBeingServiced.getMinutesRemaining() == 0) {
                        if (!customerBeingServiced.didFinishWork) {
                            customerBeingServiced.didFinishWork = true;
                            vouchersStack.peek().setTimeFinished(i);
                            System.out.println(vouchersStack.peek().printFinishedMessage());
                        }

                        if (i == outsideLine.peek().getArrivalTime() && custQueue.isEmpty()) {
                            customerBeingServiced = outsideLine.dequeque();
                            System.out.printf("%s %s arrived at the FSC Car Clean and immediately started Class %s " +
                                    "service\n", customerBeingServiced.getFirstName(),
                                    customerBeingServiced.getLastName(), customerBeingServiced.getCode());
                            customerVoucher = new FSCvoucher(customerBeingServiced.arrivalTime,
                                    customerBeingServiced.ID, customerBeingServiced.firstName,
                                    customerBeingServiced.lastName,
                                    customerBeingServiced.code);
                            vouchersStack.push(customerVoucher);
                            customerBeingServiced.setTimeStarted(i);
                            vouchersStack.peek().setTimeStarted(i);
                        } else if (!custQueue.isEmpty()) {
                            customerBeingServiced = custQueue.dequeque();
                            customerBeingServiced.setTimeStarted(i);
                            System.out.printf("%s %s has started class %s service\n",
                                    customerBeingServiced.getFirstName(), customerBeingServiced.getLastName(),
                                    customerBeingServiced.getCode());
                            customerVoucher = new FSCvoucher(customerBeingServiced.arrivalTime,
                                    customerBeingServiced.ID, customerBeingServiced.firstName,
                                    customerBeingServiced.lastName,
                                    customerBeingServiced.code);
                            vouchersStack.push(customerVoucher);
                        }
                    }

                    if (!outsideLine.isEmpty() && i == outsideLine.peek().getArrivalTime()) {
                        if (custQueue.numCustomers + 1 < maxQueueSize) {
                            FSCmember cust = outsideLine.dequeque();
                            custQueue.enqueue(cust);
                            System.out.printf("%s %s arrived at the FSC Car Clean and was placed into the Wash Queue\n",
                                    cust.getFirstName(), cust.getLastName());
                            while(outsideLine.peek() != null && i == outsideLine.peek().getArrivalTime()) {
                                cust = outsideLine.dequeque();
                                custQueue.enqueue(cust);
                                System.out.printf("%s %s arrived at the FSC Car Clean and was placed into the Wash Queue\n",
                                        custQueue.peek().getFirstName(), custQueue.peek().getLastName());

                                continue;
                            }
                        } else {
                            FSCmember cust = outsideLine.dequeque();
                            System.out.printf("%s %s arrived at the FSC Car Clean. Unfortunately, the Wash Queue is " +
                                    "full, and the customer left disappointed.", cust.getFirstName(), cust.getLastName());
                        }
                    }


                } else {
                    break;
                }
                if (customerBeingServiced.getMinutesRemaining() != 0) {
                    customerBeingServiced.setMinutesRemaining(customerBeingServiced.getMinutesRemaining() - 1);
                }

            }
            minionActions(vouchersStack);
            numDaysSimulated++;

        } while (numDaysSimulated < numDays);
    }


    public static void minionActions(FSCvouchers voucherStack) {
        voucherStack.printStack();
        voucherStack.clearStack();
    }

    public static FSCcarCleanQ setupOutsideLine(Scanner in, int numCustomers, int timeForWash, int timeForWax,
                                                int timeForVacuum, FSCvouchers vouchersStack) {
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



