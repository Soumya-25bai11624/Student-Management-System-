public class Enrollment {
    int studentId;
    int courseId;
    double marks;
    int attendance;

    public Enrollment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = -1;
        this.attendance = 0;
    }

    public String grade() {
        if (marks < 0) return "Not added";
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }
}
