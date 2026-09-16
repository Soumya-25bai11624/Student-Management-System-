import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            students.add(new Student(id, name, email, phone));
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) s.display();
    }

    public void searchStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
