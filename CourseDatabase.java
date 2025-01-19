import java.util.ArrayList;

public class CourseDatabase {
    private ArrayList<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.printf("Code: %s | Title: %s | Description: %s | Capacity: %d | Enrolled: %d | Schedule: %s%n",
                    course.getCourseCode(), course.getTitle(), course.getDescription(),
                    course.getCapacity(), course.getEnrolledStudents(), course.getSchedule());
        }
    }

    public Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course; // Return the matching course
            }
        }
        return null; // Course not found
    }
}
