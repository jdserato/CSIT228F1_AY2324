package Feb16;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int thr_ctr = 0;
    static Integer total_primes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("until what number? ");
        int num = sc.nextInt();
        System.out.print("How many threads? ");
        int thrcnt = sc.nextInt();
        ArrayList<Thread> threads = new ArrayList<>();
        int each = num / thrcnt;
        for (int i = 0; i < thrcnt; i++) {
            int start = each * i + 1;
            int end = each * (i+1);
            if (i == thrcnt-1) {
                end = num;
            }
            threads.add(new Thread(new NamedRunnable(i + "", start, end)));
            System.out.println("Created. Is alive? " + threads.get(i).isAlive());

        }
        for (int i = 0; i < thrcnt; i++) {
            threads.get(i).start();
            System.out.println("Started. Is alive? " + threads.get(i).isAlive());
        }
        for (int i = 0; i < thrcnt; i++) {
            threads.get(i).interrupt();
            System.out.println("Started. Is alive? " + threads.get(i).isAlive());
        }
        System.out.println("AWAKE NA MEEE");
        int h=0;
        for (int i = 0; i < thrcnt; i++) {
            System.out.println("Looping " + i);
            try {
                System.out.println(i+" b4 join. Is alive? " + threads.get(i).isAlive());
                threads.get(i).join();
                System.out.println(i+" af join. Is alive? " + threads.get(i).isAlive());

            } catch (InterruptedException e) {
            }
        }

        System.out.println("MANA KO HEHE with total of " + total_primes);

    }
}
