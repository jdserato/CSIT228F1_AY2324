package Grades;

public class Main {
    public static void main(String[] args) {
        Grade csit227 = new Grade("Nino Rey");
        Thread nino = new Thread(new StudentRunnable(csit227, "Nino"));
        Thread angel = new Thread(new StudentRunnable(csit227, "Angel"));
        Thread summer = new Thread(new StudentRunnable(csit227, "Summer"));
        Thread sirvince = new Thread(new TeacherRunnable(csit227));
        nino.start();
        angel.start();
        summer.start();
        sirvince.start();
        while (true) {
            System.out.println("Nino: " + nino.getState());
            System.out.println("angel: " + angel.getState());
            System.out.println("summer: " + summer.getState());
            System.out.println("sirvince: " + sirvince.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
