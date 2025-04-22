public class Transaction {
    public int acc_no;
    public int amount;
    public int balance;

    public Transaction(int acc_no, int amount, int balance) {
        this.acc_no = acc_no;
        this.amount = amount;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return acc_no;
    }

    public int getAmount() {
        return amount;
    }

    public void getBalance() {
        System.out.println("Balance before Transaction : Rs." + balance);
    }
}

class Deposit extends Transaction {
    public Deposit(int acc_no, int amount, int balance) {
        super(acc_no, amount, balance);
    }

    public void depositAmount() {
        balance += amount;
    }

    public void getDepositStatus() {
        System.out.println("---------------------------------");
        System.out.println("Amount Rs." + amount + " is deposited successfully.");
        System.out.println("Your current balance is Rs." + balance);
    }

    @Override
    public void getBalance() {
        System.out.println("---------------------------------");
        System.out.println("Balance after Transaction (Depositing) : Rs." + balance);
    }
}

class Withdraw extends Transaction {
    public Withdraw(int acc_no, int amount, int balance) {
        super(acc_no, amount, balance);
    }

    public void withdrawAmount() {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void getWithdrawStatus() {
        System.out.println("---------------------------------");
        System.out.println("Amount Rs." + amount + " is Withdrawn successfully.");
        System.out.println("Your current balance is Rs." + balance);
    }

    @Override
    public void getBalance() {
        System.out.println("---------------------------------");
        System.out.println("Balance after Transaction (Withdrawing) : Rs." + balance);
    }
}
