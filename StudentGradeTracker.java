import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    // Method to calculate average, highest, and lowest grades
    static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Show Statistics");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade! Must be between 0 and 100.");
            return;
        }

        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println("Name: " + s.name + " | Grade: " + s.grade);
        }
    }

    public static void showStatistics() {
        if (students.isEmpty()) {
            System.out.println("No data to calculate.");
            return;
        }

        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
            }
        }

        double average = total / students.size();

        System.out.println("\n--- Statistics ---");
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
    }
}
