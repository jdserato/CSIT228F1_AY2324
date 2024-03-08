package Bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable{
    List<BingoCard> cards;
    static Boolean[] result;
    static boolean bingo;
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();
        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i+1));
        }
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }
        result = new Boolean[76];
        for (int i = 1;i<76; i++) {
            result[i] = Boolean.FALSE;
        }
        result[0] = true;
        // TODO create your checker threads per card
        Thread[] checkerThrds = new Thread[cnt];
        for (int i = 0; i < cnt; i++) {
            checkerThrds[i] = new Thread(new BingoPatternPlus(cards.get(i)));
        }
        // TODO start all threads
        for (Thread t : checkerThrds) {
            t.start();
        }
        // TODO RANDOM RESULTS
        // TODO randomly get number from 1-75 while not bingo

        Random r = new Random();
        while (!bingo) {
            int rand;
            do {
                rand = r.nextInt(75) + 1;
            } while (result[rand]);
            result[rand] = true;
            System.out.println("Number " + rand);
            System.out.print("Results: ");
            for (int i = 1; i <= 75; i++) {
                if (result[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            synchronized (result) {
                System.out.println("Notified " + rand + ": " + result[rand]);
                result.notifyAll();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            for (Thread t : checkerThrds) {
                System.out.println(t.getState());
            }
        }
        System.out.println("INTERRUPTING OTHER THREADS:");
        for (Thread t : checkerThrds) {
            t.interrupt();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        for (Thread t : checkerThrds) {
            System.out.println(t.getState());
        }
    }
}
