import java.util.ArrayList;

public class Account {
    private String name;
    private String addr;
    private String phoneno;
    private String aadhar;
    private String dob;
    private int balance;
    private int acc_no;

    static int nextAccNo = 70780; // static to auto-increment account number
    static ArrayList<Account> acc = new ArrayList<>(); // shared account list

    public Account(String name, String addr, String phoneno, String aadhar, String dob) {
        this.name = name;
        this.addr = addr;
        this.phoneno = phoneno;
        this.aadhar = aadhar;
        this.dob = dob;
        this.balance = 0;
        this.acc_no = nextAccNo++;
    }

    public void createAccount() {
        acc.add(this);
        System.out.println("---------------------------------");
        System.out.println("Account created successfully.");
        System.out.println("Your Account no: " + acc_no);
    }

    public int getAccountNumber() {
        return acc_no;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public static Account findAccountByNumber(int number) {
        for (Account a : acc) {
            if (a.getAccountNumber() == number) {
                return a;
            }
        }
        return null;
    }
}
