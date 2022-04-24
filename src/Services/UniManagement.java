package Services;

import Beans.Course;
import Beans.Lector;
import Beans.Student;
import Beans.lectorType;

public interface UniManagement {
    Course createCourse(String courseName);
    boolean deleteCourse(String courseName);

    Student createStudent(int id, String firstName, String lastName, String facNumber);
    boolean deleteStudent(int id);

    Lector createAssistance(int id, String firstName, String lastName);
    boolean deleteAssistance(int id);

    Lector createProfessor(int id, String firstName, String lastName, lectorType lectorType);
    boolean deleteProfessor(int id);

    boolean assignAssistantToCourse(Lector assistant, Course course);
    boolean assignProfessorToCourse(Lector professor, Course course);

    boolean asighStudentToCourse(Student student, Course course);
    boolean asighStudentToCourse(Student[] students, Course course);

    boolean removeStudentFromCourse(Student student, Course course);

    Student getStudentById(int id);
    Course getCourseByName(String name);
    Lector getAssistantById(int id);
    Lector getLectorById(int id);

}
