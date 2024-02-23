package Feb16;

public class NamedThread extends Thread{
    String name;
    int num;
    public NamedThread(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public void run() {
        int ctr = 0;
        System.out.println("Hello! My name is " + name);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= num; i++) {
            // how to know if i is prime ???????
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            ctr += isPrime ? 1 : 0;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Prime is " + ctr);
        System.out.println("Total time: " + (endTime-startTime));
    }
}
