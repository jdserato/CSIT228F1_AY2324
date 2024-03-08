package Bingo;

import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern implements Runnable {
    List<BingoChecker> checkers;
    BingoCard card;

    public BingoPattern(BingoCard card) {
        this.card = card;
        checkers = new ArrayList<>();
    }

    @Override
    public void run() {
        List<Thread> threads = new ArrayList<>();
        for (BingoChecker checker : checkers) {
            threads.add(new Thread(checker));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                for (Thread t1 : threads) {
                    t1.interrupt();
                }
                System.out.println("Card " + card.id + " loses");
                return;
            }
        }
        BingoGame.bingo = true;
        System.out.println("Card " + card.id + " completes " + getClass().toString());
        System.out.println(card);
    }
}
