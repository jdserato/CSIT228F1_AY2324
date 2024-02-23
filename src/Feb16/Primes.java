package Feb16;

import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("until what number? ");
        int num = sc.nextInt();
        int ctr = 0;
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
