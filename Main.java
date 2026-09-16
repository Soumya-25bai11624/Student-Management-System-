import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!user.equals("admin") || !pass.equals("admin123")) {
            System.out.println("Invalid login!");
            return;
        }

        StudentManager sm = new StudentManager();
        CourseManager cm = new CourseManager();
        EnrollmentManager em = new EnrollmentManager();

        int choice;
        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Add Course");
            System.out.println("5. View Courses");
            System.out.println("6. Enroll Student");
            System.out.println("7. View Enrollments");
            System.out.println("8. Add Marks");
            System.out.println("9. Attendance");
            System.out.println("10. Reports");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> sm.addStudent(sc);
                case 2 -> sm.viewStudents();
                case 3 -> sm.searchStudent(sc);
                case 4 -> cm.addCourse(sc);
                case 5 -> cm.viewCourses();
                case 6 -> em.enrollStudent(sc, sm, cm);
                case 7 -> em.viewEnrollments();
                case 8 -> em.addMarks(sc);
                case 9 -> em.addAttendance(sc);
                case 10 -> em.showReport(sm, cm);
                case 11 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 11);

        sc.close();
    }
}
