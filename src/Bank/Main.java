package Bank;

public class Main {
    public static void main(String[] args) {
        Account akoa = new Account("JVM", 1000);
        Thread shopee = new Thread(new TransactionRunnable(akoa, 700, "Shopee"));
        Thread hoyo = new Thread(new TransactionRunnable(akoa, 280, "Hoyoverse"));
        Thread lazada = new Thread(new TransactionRunnable(akoa, 500, "Lazada"));
        lazada.start();
        hoyo.start();
        shopee.start();
        while (lazada.isAlive() || hoyo.isAlive() || shopee.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println("Lazada: " + lazada.getState());
            System.out.println("Shopee: " + shopee.getState());
            System.out.println("Hoyo: " + hoyo.getState());

        }
//        System.out.println("Balance: " + akoa.balance);
    }
}
