import java.util.ArrayList;

public class Student {
    private String studentId;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void registerCourse(Course course) {
        if (course.enrollStudent()) {
            registeredCourses.add(course);
            System.out.println(name + " successfully registered for " + course.getTitle());
        } else {
            System.out.println("Registration failed: " + course.getTitle() + " is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course) && course.dropStudent()) {
            System.out.println(name + " successfully dropped " + course.getTitle());
        } else {
            System.out.println("Drop failed: " + course.getTitle() + " not found in registered courses.");
        }
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}
