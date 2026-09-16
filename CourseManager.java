import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Scanner sc) {
        try {
            System.out.print("Enter course ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter course name: ");
            String name = sc.nextLine();
            System.out.print("Enter credits: ");
            int credits = Integer.parseInt(sc.nextLine());

            courses.add(new Course(id, name, credits));
            System.out.println("Course added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course c : courses) c.display();
    }
}
