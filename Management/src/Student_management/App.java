package Student_management;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Create Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Update Student Name");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                case 1:
                    // Create student
                    System.out.print("Enter ID: ");
                    int sid = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    String sname = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    String sage = scanner.nextLine();  

                    System.out.print("Enter Email: ");
                    String smail = scanner.nextLine();

                    Student student = new Student(sid, sname, sage, smail);
                    StudentDao.createStudent(student);
                    System.out.println("Student created successfully.");
                    break;


                    case 2:
                        // Read all students
                        ArrayList<Student> students = StudentDao.readStudents();
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                        break;

                    case 3:
                        // Update student
                        System.out.print("Enter Student ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();

                        StudentDao.updateStudent(updateId, newName);
                        System.out.println("Student updated successfully.");
                        break;

                    case 4:
                        // Delete student
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = scanner.nextInt();
                        StudentDao.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                        break;

                    case 5:
                        exit = true;
                        System.out.println("Exiting program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
