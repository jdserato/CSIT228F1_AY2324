package Bingo;

public class BingoPatternPlus extends BingoPattern{

    public BingoPatternPlus(BingoCard card) {
        super(card);
        checkers.add(new BingoColumnChecker(card, 3));
        checkers.add(new BingoRowChecker(card, 3));
    }
}
