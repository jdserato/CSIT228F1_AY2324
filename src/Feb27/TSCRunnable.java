package Feb27;

public class TSCRunnable implements Runnable{
    ThreadSafeCounter tsc;

    public TSCRunnable(ThreadSafeCounter tsc) {
        this.tsc = tsc;
    }

    @Override
    public synchronized void run() {
        tsc.increment();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        synchronized (tsc) {
            if (tsc.getCount() != 0) {
                int cnt = tsc.getCount();
                tsc.reset();
                int answer = 13 / cnt;
                System.out.println("Answer: " + answer);

            } else {
                System.out.println("Zero count");
            }
        }


    }
}
