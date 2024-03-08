package Bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCard {
    int[][] nums;
    List<Integer> my_numbers;
    int id;

    public BingoCard(int id) {
        this.id = id;
        nums = new int[5][5];
        my_numbers = new ArrayList<>();
        Random r = new Random();
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 5; row++) { // 16-30
                int rand;
                do {
                    rand = 15*col + r.nextInt(15)+1;
                } while (my_numbers.contains(rand));
                nums[row][col] = rand;
                my_numbers.add(rand);
            }
        }
        nums[2][2] = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0;row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
