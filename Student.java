public class Student {
    int id;
    String name;
    String email;
    String phone;

    public Student(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name +
                " | Email: " + email + " | Phone: " + phone);
    }
}
