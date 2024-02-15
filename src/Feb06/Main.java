package Feb06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cat c = null;
        try {
            System.out.print("Enter age of cat: ");
            c = new Cat(sc.nextInt());
            System.out.println("Age of cat is " + c.getAge());
            c.birthday();
//        } catch (InputMismatchException e) {
//            System.out.println("NOT A NUMBER");
        } catch (BadAgeException e) {
            System.out.println("Class: " + e.getClass());
            System.out.println(e.getMessage());
//        } finally {
//            sc.next();
//            int a= sc.nextInt();
//            System.out.println("IM DONE" + a);
        }
//        System.out.println(c);
    }

}
