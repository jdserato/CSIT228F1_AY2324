package Bingo;

public abstract class BingoChecker implements Runnable {
    BingoCard card;

    public BingoChecker(BingoCard card) {
        this.card = card;
    }
}
