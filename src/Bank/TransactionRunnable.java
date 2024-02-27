package Bank;

public class TransactionRunnable implements Runnable{
    Account acct;
    double amount;
    String details;

    public TransactionRunnable(Account acct, double amount, String details) {
        this.acct = acct;
        this.amount = amount;
        this.details = details;
    }

    @Override
    public void run() {
        System.out.println(details + " status: " + acct.purchase(amount));
        System.out.println("Balance: " + acct.balance);
    }
}
