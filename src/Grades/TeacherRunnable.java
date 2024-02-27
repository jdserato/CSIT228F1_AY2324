package Grades;

public class TeacherRunnable implements Runnable{
    Grade stud_grade;

    public TeacherRunnable(Grade stud_grade) {
        this.stud_grade = stud_grade;
    }

    @Override
    public void run() {
        System.out.println("Calculating Grade");
        stud_grade.calculateGrade();
    }
}
