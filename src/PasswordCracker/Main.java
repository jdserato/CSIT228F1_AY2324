package PasswordCracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        int len = pass.length();
        String atk = "a".repeat(len);
        while (!atk.equals(pass)) {
            System.out.println(atk);
            int i;
            for (i = len-1; atk.charAt(i) == 'z'; i--);
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len-i-1);
            atk = first + next + after;
        }
        System.out.println("Found: " + atk);
    }
}
