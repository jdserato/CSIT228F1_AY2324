package Grades;

import java.util.Random;

public class Grade {
    String name;
    double grade;

    public Grade(String name) {
        this.name = name;
    }

    public double getGrade() {
        if (grade == 0) {
            synchronized (this) {
                try {
                    this.wait(2000);
                } catch (InterruptedException e) {
                }
            }
        }
        return grade;
    }

    public void calculateGrade() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        synchronized (this) {
            grade = r.nextDouble() * 5;
            this.notifyAll();
        }
    }
}
