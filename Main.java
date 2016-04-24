/** @author mariacheline **/

package bankaccount;

import java.sql.Timestamp;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner inpt = new Scanner(System.in);
        int user;
        boolean check = false;
        int withdrawAmount;
        int depositAmount;

        CC conto = new CC(1000);  // initial balance
        System.out.printf("Current balance: %.2f%n%n", conto.getBalance());
        System.out.println("Please choose by entering the number:\n 1) Withdraw\n 2) Deposit\n 3) Balance\n"
                + " 4) Transaction History\n 5) Exit");
                
        ArrayList history = new ArrayList();   
       
         /* Menu to prompt the user */
        do {
            System.out.print("\nChoose an action: ");
            user = inpt.nextInt();

        switch (user) {
            case 1: /* Withdraw */
                if (conto.getBalance() <= 0) {
                    System.out.printf("Insufficient balance!\nYour balance is: %.2f%n",
                            conto.getBalance());
                } else {
                    System.out.print("Enter an  amount to withdraw: ");
                    withdrawAmount = inpt.nextInt();
                    if (withdrawAmount > conto.getBalance()) {
                        System.out.println("Insufficient balance! Impossible to perform action.");
                    } else {
                        conto.withdraw(withdrawAmount);
                        history.add("You have withdrawn: " +withdrawAmount);
                    }
                }
                break;
            case 2: /* Deposit */
                System.out.print("Enter an amount to deposit: ");
                depositAmount = inpt.nextInt();
                conto.deposit(depositAmount);
                history.add("You have deposited: " + depositAmount);
                break;
                
            case 3: /* Display current/total balance */
                System.out.printf("Total balance: %.2f%n", conto.getBalance());
                break;
                
            case 4: /* Display transaction history */
                System.out.printf("%n%35s%n","Transaction History\n");
                
                /* For timestamp */
                Date date= new Date();
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);
                String buffer = (""+ts).substring(0,(""+ts).indexOf('.')); // credits to siordache94 for this line of code
                
                /* Print Arraylist elements */
                if(history.size() < 5){
                    for (Object x: history){
                        System.out.println(buffer + "\t" + x);
                    }
                }else{
                    for(int i = 0 ; i < 5 ; i++){
                        System.out.println(buffer + "\t" + history.get(history.size()-(1+i)));
                    }
                }
                

                /********* This is another method for printing the Arraylist elements
                // Count size of arraylist
                int countSize = 0;
                for (Object x: history){
                    countSize++;
                }
                // Print desried elements
                if (history.size() < 5){
                    for(int i = history.size()-1; i > history.size() - (countSize + 1); i--){
                        System.out.println(buffer + "\t" + history.get(i));
                    }
                }else if (history.size() >= 5){
                    for(int i = history.size()-1; i > history.size() - 6; i--){
                    System.out.println(buffer + "\t" + history.get(i));
                  }  
                }**********/                
                break;
                
            case 5: /* Exit system */
                System.out.println("\nThank you and goodbye!\n");
                System.exit(0);
                break;               
            default:
                System.out.println("Invalid option. Please try again!");
        }
        } while (!check);
        /* End of the menu */
    }
}
