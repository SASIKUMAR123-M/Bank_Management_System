//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bank Management System");

        int choice = 1;

        while (choice != 3) {
            System.out.println("---------------------------------");
            System.out.println("1: Create account");
            System.out.println("2: Transaction - Withdraw/Deposit");
            System.out.println("3: Exit");
            System.out.println("4: View All Accounts");
            System.out.println("---------------------------------");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter user details");
                System.out.println("Enter your name:");
                String name = sc.next();
                System.out.println("Enter your address:");
                String addr = sc.next();
                System.out.println("Enter your phone no:");
                String phoneno = sc.next();
                System.out.println("Enter your Aadhar no:");
                String aadhar = sc.next();
                System.out.println("Enter your DOB:");
                String dob = sc.next();

                Account acc = new Account(name, addr, phoneno, aadhar, dob);
                acc.createAccount();
            }

            else if (choice == 2) {
                System.out.println("Enter the details");
                System.out.println("Enter Account Number:");
                int acc_num = sc.nextInt();

                Account acc = Account.findAccountByNumber(acc_num);
                if (acc == null) {
                    System.out.println("Account not found!");
                    continue;
                }

                int balance = acc.getBalance();
                System.out.println("Your current balance is Rs." + balance);

                System.out.println("Enter the amount:");
                int amount = sc.nextInt();

                System.out.println("Would you like to Withdraw or Deposit:");
                System.out.println("1: Deposit");
                System.out.println("2: Withdraw");
                int transaction_choice = sc.nextInt();

                if (transaction_choice == 1) {
                    Deposit deposit = new Deposit(acc_num, amount, balance);
                    deposit.depositAmount();
                    acc.setBalance(deposit.balance);
                    deposit.getDepositStatus();
                    deposit.getBalance();
                } else if (transaction_choice == 2) {
                    if (amount > balance) {
                        System.out.println("Insufficient balance!");
                        continue;
                    }
                    Withdraw withdraw = new Withdraw(acc_num, amount, balance);
                    withdraw.withdrawAmount();
                    acc.setBalance(withdraw.balance);
                    withdraw.getWithdrawStatus();
                    withdraw.getBalance();
                } else {
                    System.out.println("Invalid transaction choice");
                }
            }

            else if (choice == 4) {
                System.out.println("All Accounts:");
                for (Account a : Account.acc) {
                    System.out.println("Account No: " + a.getAccountNumber() + " | Balance: Rs." + a.getBalance());
                }
            }

            else if (choice == 3) {
                System.out.println("Exiting... Thank you!");
            }

            else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}