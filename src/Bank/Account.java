package Bank;

public class Account {
    String name;
    double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    synchronized boolean purchase(double amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            balance -= amount;
            return true;
        }
        return false;
    }
}
