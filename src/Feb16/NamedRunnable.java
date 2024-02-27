package Feb16;

public class NamedRunnable implements Runnable{

    String name;
    int num;
    int start, end;
    public NamedRunnable(String name, int start, int end ) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int ctr = 0;
        System.out.println("Hello! My runnable name is " + name + " starting with " + start + " until " + end);
        long startTime = System.currentTimeMillis();
        for (int i = start; i <= end; i++) {
            // how to know if i is prime ???????
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            ctr += isPrime ? 1 : 0;
            if (isPrime) {
                addTotal();
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println(name + " Prime is " + ctr + " now with total of " + Main.total_primes);
        System.out.println(name + " Total time: " + (endTime-startTime));
        Main.thr_ctr++;
    }

    public static synchronized void addTotal() {
        Main.total_primes++;
    }
}
