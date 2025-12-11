import java.util.Scanner;

public class StudentGradeSystem {

    static Scanner input = new Scanner(System.in);
    static String[] names;
    static int[] marks;
    static char[] grades;
    static int totalStudents = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=== STUDENT GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Enter Number of Students");
            System.out.println("2. Input Student Names and Marks");
            System.out.println("3. Calculate Grades");
            System.out.println("4. Display Summary Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    enterNumberOfStudents();
                    break;
                case 2:
                    inputStudentData();
                    break;
                case 3:
                    calculateGrades();
                    break;
                case 4:
                    displayReport();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);
    }

    // 1. Enter student count
    public static void enterNumberOfStudents() {
        System.out.print("Enter total number of students: ");
        totalStudents = input.nextInt();
        names = new String[totalStudents];
        marks = new int[totalStudents];
        grades = new char[totalStudents];
        System.out.println("Student slots created: " + totalStudents);
    }

    // 2. Input student names & marks
    public static void inputStudentData() {
        if (totalStudents == 0) {
            System.out.println("Please set number of students first.");
            return;
        }

        for (int i = 0; i < totalStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            names[i] = input.next();

            int mark;
            do {
                System.out.print("Enter mark (0-100): ");
                mark = input.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid mark! Try again.");
                }
            } while (mark < 0 || mark > 100);

            marks[i] = mark;
        }
    }

    // 3. Calculate Grades
    public static void calculateGrades() {
        if (marks == null) {
            System.out.println("Please input student data first.");
            return;
        }

        for (int i = 0; i < totalStudents; i++) {
            int m = marks[i];
            if (m >= 80) grades[i] = 'A';
            else if (m >= 70) grades[i] = 'B';
            else if (m >= 60) grades[i] = 'C';
            else if (m >= 50) grades[i] = 'D';
            else grades[i] = 'F';
        }

        System.out.println("Grades calculated successfully!");
    }

    // 4. Display full summary report
    public static void displayReport() {
        if (grades == null) {
            System.out.println("Please calculate grades first.");
            return;
        }

        System.out.println("\n===== STUDENT REPORT =====");

        int sum = 0;
        int highest = marks[0];
        int lowest = marks[0];

        for (int i = 0; i < totalStudents; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - Mark: " + marks[i] + " - Grade: " + grades[i]);

            sum += marks[i];
            if (marks[i] > highest) highest = marks[i];
            if (marks[i] < lowest) lowest = marks[i];
        }

        double average = (double) sum / totalStudents;

        System.out.println("\nAverage Mark: " + average);
        System.out.println("Highest Mark: " + highest);
        System.out.println("Lowest Mark: " + lowest);
    }
}
