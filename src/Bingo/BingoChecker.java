package Bingo;

public abstract class BingoChecker implements Runnable {
    BingoCard card;

    public BingoChecker(BingoCard card) {
        this.card = card;
    }

    protected boolean waitForMe(int num) {
        while (!BingoGame.result[num]) {
            System.out.println("Card " + card.id + ": Waiting for " + num);
            try {
                synchronized (BingoGame.result) {
                    BingoGame.result.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Card " + card.id + " loses while doing stuff");
                return false;
            }
        }
        return true;
    }
}
