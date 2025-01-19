import java.util.Scanner;

public class CourseRegistrationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize databases
        CourseDatabase courseDatabase = new CourseDatabase();
        
        // Sample courses
        courseDatabase.addCourse(new Course("CS101", "Introduction to Computer Science", "Basics of programming.", 30, "Mon/Wed 10-11 AM"));
        courseDatabase.addCourse(new Course("CS102", "Data Structures", "Learn about various data structures.", 25, "Tue/Thu 1-2 PM"));
        
        // Display available courses
        courseDatabase.displayCourses();
        
        // Create a student
        Student student = new Student("S001", "Alice");

        // Register for a course
        System.out.print("Enter the code of the course to register: ");
        String codeToRegister = scanner.nextLine();
        
        Course selectedCourse = courseDatabase.findCourse(codeToRegister);
        
        if (selectedCourse != null) {
            student.registerCourse(selectedCourse);
            System.out.println("Registered Courses: " + student.getRegisteredCourses().size());
            // Display updated available courses after registration
            courseDatabase.displayCourses();
            
            // Drop a course
            System.out.print("Enter the code of the course to drop: ");
            String codeToDrop = scanner.nextLine();
            
            selectedCourse = courseDatabase.findCourse(codeToDrop);
            
            if (selectedCourse != null) {
                student.dropCourse(selectedCourse);
                System.out.println("Registered Courses after dropping: " + student.getRegisteredCourses().size());
                // Display updated available courses after dropping
                courseDatabase.displayCourses();
            } else {
                System.out.println("Course not found.");
            }
            
        } else {
            System.out.println("Course not found.");
        }
        
        scanner.close();
    }
}
