import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentManager {
    ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(Scanner sc, StudentManager sm, CourseManager cm) {
        System.out.print("Enter student ID: ");
        int sid = Integer.parseInt(sc.nextLine());
        System.out.print("Enter course ID: ");
        int cid = Integer.parseInt(sc.nextLine());

        boolean studentFound = false;
        boolean courseFound = false;

        for (Student s : sm.students)
            if (s.id == sid) studentFound = true;

        for (Course c : cm.courses)
            if (c.id == cid) courseFound = true;

        if (studentFound && courseFound) {
            enrollments.add(new Enrollment(sid, cid));
            System.out.println("Enrollment successful!");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void viewEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        for (Enrollment e : enrollments) {
            System.out.println("Student ID: " + e.studentId +
                    " | Course ID: " + e.courseId +
                    " | Marks: " + (e.marks < 0 ? "Not added" : e.marks) +
                    " | Grade: " + e.grade() +
                    " | Attendance: " + e.attendance + "%");
        }
    }

    public void addMarks(Scanner sc) {
        System.out.print("Enter student ID: ");
        int sid = Integer.parseInt(sc.nextLine());
        System.out.print("Enter course ID: ");
        int cid = Integer.parseInt(sc.nextLine());

        for (Enrollment e : enrollments) {
            if (e.studentId == sid && e.courseId == cid) {
                System.out.print("Enter marks (0-100): ");
                e.marks = Double.parseDouble(sc.nextLine());
                System.out.println("Marks added. Grade: " + e.grade());
                return;
            }
        }
        System.out.println("Enrollment not found.");
    }

    public void addAttendance(Scanner sc) {
        System.out.print("Enter student ID: ");
        int sid = Integer.parseInt(sc.nextLine());
        System.out.print("Enter course ID: ");
        int cid = Integer.parseInt(sc.nextLine());

        for (Enrollment e : enrollments) {
            if (e.studentId == sid && e.courseId == cid) {
                System.out.print("Enter attendance percentage: ");
                e.attendance = Integer.parseInt(sc.nextLine());
                System.out.println("Attendance updated.");
                return;
            }
        }
        System.out.println("Enrollment not found.");
    }

    public void showReport(StudentManager sm, CourseManager cm) {
        System.out.println("\n===== BASIC REPORT =====");
        System.out.println("Total Students: " + sm.students.size());
        System.out.println("Total Courses: " + cm.courses.size());
        System.out.println("Total Enrollments: " + enrollments.size());
    }
}
