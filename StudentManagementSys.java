import java.util.ArrayList;
import java.util.Scanner;

class Student {
    long prn;
    String name;
    String dob;
    double marks;

    // Constructor
    public Student(long prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    // Display method
    public void display() {
        System.out.println("PRN: " + prn);
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Marks: " + marks);
        System.out.println("------------");
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update/Edit Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByPRN();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    // You can implement search by position logic here
                    break;
                case 6:
                    updateStudent();
                    break;
                case 7:
                    deleteStudent();
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 8);
    }

    static void addStudent() {
        System.out.print("Enter PRN (11 digits): ");
        long prn = scanner.nextLong();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth: ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student newStudent = new Student(prn, name, dob, marks);
        studentList.add(newStudent);

        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for (Student student : studentList) {
                student.display();
            }
        }
    }

    static void searchByPRN() {
        System.out.print("Enter PRN to search: ");
        long prn = scanner.nextLong();

        for (Student student : studentList) {
            if (student.prn == prn) {
                student.display();
                return;
            }
        }

        System.out.println("Student with PRN " + prn + " not found.");
    }

    static void searchByName() {
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();

        for (Student student : studentList) {
            if (student.name.equalsIgnoreCase(name)) {
                student.display();
                return;
            }
        }

        System.out.println("Student with name " + name + " not found.");
    }

    static void updateStudent() {
        System.out.print("Enter PRN to update: ");
        long prn = scanner.nextLong();

        for (Student student : studentList) {
            if (student.prn == prn) {
                scanner.nextLine();  // Consume the newline character
                System.out.print("Enter new Name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter new Date of Birth: ");
                student.dob = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                student.marks = scanner.nextDouble();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student with PRN " + prn + " not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter PRN to delete: ");
        long prn = scanner.nextLong();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).prn == prn) {
                studentList.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student with PRN " + prn + " not found.");
    }
}
