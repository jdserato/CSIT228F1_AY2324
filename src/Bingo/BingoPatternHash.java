package Bingo;

public class BingoPatternHash extends BingoPattern{
    public BingoPatternHash(BingoCard card) {
        super(card);
        checkers.add(new BingoColumnChecker(card, 2));
        checkers.add(new BingoColumnChecker(card, 4));
        checkers.add(new BingoRowChecker(card, 2));
        checkers.add(new BingoRowChecker(card, 4));
    }
}
