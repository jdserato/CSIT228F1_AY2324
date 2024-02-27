package Feb27;

public class Main {
    public static void main(String[] args) {
        Object o;
        
        ThreadSafeCounter tsc = new ThreadSafeCounter();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new TSCRunnable(tsc));
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}
