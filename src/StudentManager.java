import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class StudentManager {

    public static void main(String[] args) {
        Map<Integer, String> students = new TreeMap<>();
        StudentManager manager = new StudentManager();

        try {
            manager.addStudent(students, 145, "Alice");
            manager.addStudent(students, 72, "Benitha");
            manager.addStudent(students, 103, "Tetina");
            manager.addStudent(students, 42, "Dany");

            manager.sortStudents(students);
            manager.searchStudent(students, 103);
            manager.removeStudent(students, 42);
            manager.findStudentWithHighestId(students);
            manager.findStudentWithLowestId(students);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


    public void addStudent(Map<Integer, String> students, int studentId, String name) throws IllegalArgumentException {
        if (studentId <= 0 || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid student details provided.");
        }
        students.put(studentId, name);
        System.out.println("Added Student - ID: " + studentId + ", Name: " + name);
    }


    public void sortStudents(Map<Integer, String> students) {
        try {
            Map<Integer, String> sortedStudents = new TreeMap<>(students);
            System.out.println("Sorted Students by ID:");
            sortedStudents.forEach((id, name) -> System.out.println("ID: " + id + ", Name: " + name));
        } catch (Exception e) {
            System.err.println("An error occurred while sorting students: " + e.getMessage());
        }
    }


    public void searchStudent(Map<Integer, String> students, int studentId) {
        try {
            if (students.containsKey(studentId)) {
                System.out.println("Found Student - ID: " + studentId + ", Name: " + students.get(studentId));
            } else {
                throw new IllegalArgumentException("Student with ID: " + studentId + " not found.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Search Error: " + e.getMessage());
        }
    }

    public void removeStudent(Map<Integer, String> students, int studentId) {
        try {
            if (students.containsKey(studentId)) {
                students.remove(studentId);
                System.out.println("Removed Student with ID: " + studentId);
            } else {
                throw new IllegalArgumentException("Student with ID: " + studentId + " not found.");
            }
        } catch (NullPointerException e) {
            System.err.println("Removal Error: " + e.getMessage());
        }
    }


    public void findStudentWithHighestId(Map<Integer, String> students) {
        try {
            if (!students.isEmpty()) {
                int maxId = Collections.max(students.keySet());
                System.out.println("Student with Highest ID - ID: " + maxId + ", Name: " + students.get(maxId));
            } else {
                throw new IllegalArgumentException("No students in the list.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error finding highest ID: " + e.getMessage());
        }
    }


    public void findStudentWithLowestId(Map<Integer, String> students) {
        try {
            if (!students.isEmpty()) {
                int minId = Collections.min(students.keySet());
                System.out.println("Student with Lowest ID - ID: " + minId + ", Name: " + students.get(minId));
            } else {
                throw new IllegalArgumentException("No students in the list.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error finding lowest ID: " + e.getMessage());
        }
        finally {
            System.out.println("Sorted Students by ID:");
        }
    }
}
