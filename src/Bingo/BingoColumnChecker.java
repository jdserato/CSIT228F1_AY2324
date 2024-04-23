package Bingo;

public class BingoColumnChecker extends BingoChecker{
    int col;
    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col-1;
    }

    @Override
    public void run() {
        for (int row = 0; row < 5; row++) {
            int num = card.nums[row][col];
            waitForMe(num);
        }
        System.out.println("Card " +card.id +" done with col "+ (col+1));
    }
}
