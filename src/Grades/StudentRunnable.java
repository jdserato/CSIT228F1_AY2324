package Grades;

public class StudentRunnable implements Runnable{
    Grade my_grade;
    String student;

    public StudentRunnable(Grade my_grade, String student) {
        this.my_grade = my_grade;
        this.student = student;
    }

    @Override
    public void run() {
        System.out.println(student + ": Yey my grade is " + my_grade.getGrade());
    }
}
