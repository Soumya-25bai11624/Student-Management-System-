public class Course {
    int id;
    String name;
    int credits;

    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public void display() {
        System.out.println("Course ID: " + id + " | Name: " + name +
                " | Credits: " + credits);
    }
}
