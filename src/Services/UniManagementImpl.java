package Services;

import Beans.Course;
import Beans.Lector;
import Beans.Student;
import Beans.lectorType;

import java.util.function.Predicate;

public class UniManagementImpl implements UniManagement{
    public static Student[] students = new Student[1000];
    public static Course[] courses = new Course[10];
    public static Lector[] assistancences = new Lector[1000];
    public static Lector[] lectors = new Lector[1000];

    private int lastUsedStudentIndex = 0;
    private int lastUsedCourseIndex = 0;
    private int lastUsedAssistanceIndex = 0;
    private int lastUsedSLectorIndex = 0;

    public void printCoursesArray() {
        System.out.println("---Courses---");
        for(Course element:courses){
            if(element != null)
                System.out.println(" Course: "+element.getName()  );

        }

    }
    public void printStudentsArray(){
        System.out.println("---Students---");
        for(Student element:students){
            if(element != null)
                System.out.println("[ ID: " + element.getId() + ", FacNumber: " +element.getFacNumber() + ", FirstName: " +element.getFirstName() + ", LastName: " + element.getLastName() + "]");

        }
    }
    public void printAssistanceArray(){
        System.out.println("---Assistances---");
        for(Lector element:assistancences){
            if(element != null)
                System.out.println("[ ID: " + element.getId() + ", FirstName: " +element.getFirstName() + ", LastName: " + element.getLastName() + "]");

        }
    }
    public void printLectorArray(){
        System.out.println("---Lectors---");
        for(Lector element:lectors){
            if(element != null)
                System.out.println("[ ID: " + element.getId() + ", FirstName: " +element.getFirstName() + ", LastName: " + element.getLastName()+ "]");

        }
    }

    @Override
    public Course createCourse(String courseName) {
        Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
        for (Course element : courses) {
            if (element != null) {
                if (checkCourse.test(element)) {
                    throw new IllegalArgumentException("Course With this Name Already Exists");
                }
            }
        }
        Course newCourse = new Course(courseName);
        courses[lastUsedCourseIndex] = newCourse;
        lastUsedCourseIndex++;
        printCoursesArray();
        return newCourse;
    }

    @Override
    public boolean deleteCourse(String courseName) {
        if (courses.length == 0) return false;
        int indexCounter = 0;
        Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
        for (Course element : courses) {
            if (element != null && checkCourse.test(element)) {
                for (int i = indexCounter; i < courses.length; i++) {
                    if (indexCounter == courses.length - 1) {
                        courses[indexCounter] = null;
                        break;
                    }
                    courses[indexCounter] = courses[indexCounter + 1];
                    indexCounter++;

                }
                lastUsedCourseIndex--;
                printCoursesArray();
                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Course Doesn't Exist");
    }

    @Override
    public Student createStudent(int id, String firstName, String lastName, String facNumber) {
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id);
        for (Student element : students) {
            if (element != null) {
                if (checkStudent.test(element)) {
                    throw new IllegalArgumentException("Student With this ID Already Exists");
                }
            }
        }

        Student newStudent = new Student(facNumber,id,firstName,lastName);
        students[lastUsedStudentIndex] = newStudent;
        lastUsedStudentIndex++;
        printStudentsArray();
        return newStudent;
    }

    @Override
    public boolean deleteStudent(int id) {
        if (students.length == 0) return false;
        int indexCounter = 0;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id);
        for (Student element : students) {
            if (element != null && checkStudent.test(element)) {
                for (int i = indexCounter; i < students.length; i++) {
                    if (indexCounter == students.length - 1) {
                        students[indexCounter] = null;
                        break;
                    }
                    students[indexCounter] = students[indexCounter + 1];
                    indexCounter++;
                }
                lastUsedStudentIndex--;
                printStudentsArray();
                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Student Doesn't Exist");
    }

    @Override
    public Lector createAssistance(int id, String firstName, String lastName) {
        Predicate<Lector> checkAssistance = (Lector) -> (Lector.getId() == id );
        for (Lector element : assistancences) {
            if (element != null) {
                if (checkAssistance.test(element)) {
                    throw new IllegalArgumentException("Assistance With this ID and LastName Already Exists");
                }
            }
        }
        Lector newAssistance = new Lector(id,firstName,lastName, lectorType.ASSISTANCE);
        assistancences[lastUsedAssistanceIndex] = newAssistance;
        lastUsedAssistanceIndex++;
        printAssistanceArray();
        return newAssistance;
    }

    @Override
    public boolean deleteAssistance(int id) {
        if (assistancences.length == 0) return false;
        int indexCounter = 0;
        Predicate<Lector> checkAssistance = (Lector) -> (Lector.getId() == id);
        for (Lector element : assistancences) {
            if (element != null && checkAssistance.test(element)) {
                for (int i = indexCounter; i < assistancences.length; i++) {
                    if (indexCounter == assistancences.length - 1) {
                        assistancences[indexCounter] = null;
                        break;
                    }
                    assistancences[indexCounter] = assistancences[indexCounter + 1];
                    indexCounter++;
                }
                lastUsedAssistanceIndex--;
                printAssistanceArray();
                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Assistance Doesn't Exist");
    }

    @Override
    public Lector createProfessor(int id, String firstName, String lastName, lectorType lectorType) {
        Predicate<Lector> checkLector = (Lector) -> (Lector.getId() == id);
        for (Lector element : lectors) {
            if (element != null) {
                if (checkLector.test(element)) {
                    throw new IllegalArgumentException("Lector With this ID Already Exists");
                }
            }
        }
        Lector newLector = new Lector(id, firstName, lastName, lectorType);
        lectors[lastUsedSLectorIndex] = newLector;
        lastUsedSLectorIndex++;
        printLectorArray();
        return newLector;
    }

    @Override
    public boolean deleteProfessor(int id) {
        if (lectors.length == 0) return false;
        int indexCounter = 0;
        Predicate<Lector> checkLector = (Lector) -> (Lector.getId() == id);
        for (Lector element : lectors) {
            if (element != null && checkLector.test(element)) {
                for (int i = indexCounter; i < lectors.length; i++) {
                    if (indexCounter == lectors.length - 1) {
                        lectors[indexCounter] = null;
                        break;
                    }
                    lectors[indexCounter] = lectors[indexCounter + 1];
                    indexCounter++;

                }
                lastUsedSLectorIndex--;
                printLectorArray();

                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Lector Doesn't Exist");
    }

    @Override
    public boolean assignAssistantToCourse(Lector assistant, Course course) {
        course.setAssistance(assistant);
        assistant.addCoursesForLector(course.getName());
        return true;
    }

    @Override
    public boolean assignProfessorToCourse(Lector professor, Course course) {
        course.setLector(professor);
        professor.addCoursesForLector(course.getName());
        return true;
    }

    @Override
    public boolean asighStudentToCourse(Student student, Course course) {
        course.addStudentToCourse(student);
        student.addCoursesForStudent(course.getName(),course.getAssistance(),course.getLector());
        course.printStudentArray();
        return true;
    }

    @Override
    public boolean asighStudentToCourse(Student[] students, Course course) {
        for(Student element: students){
            course.addStudentToCourse(element);
            element.addCoursesForStudent(course.getName(),course.getAssistance(),course.getLector());
        }
        course.printStudentArray();
        return true;
    }

    @Override
    public boolean removeStudentFromCourse(Student student, Course course) {
        course.deleteStudent(student);
        student.deleteCoursesForStudent(course);
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        try {
            Predicate<Student> checkStudent = (Student) -> Student.getId() == id;
            for (Student element : students) {
                if (checkStudent.test(element)) {
                    return element;
                }
            }
        }catch (NullPointerException e){
            throw new IllegalArgumentException("This Student Or Course Is Not Created");
        }
        return null;
    }

    @Override
    public Course getCourseByName(String name) {
        try {
            Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(name);
            for (Course element : courses) {
                if (checkCourse.test(element)) {
                    return element;
                }
            }

        }catch(NullPointerException e){
            throw new IllegalArgumentException("This Student Or Course Is Not Created");
        }
        return null;
    }

    @Override
    public Lector getAssistantById(int id) {
        try {
            Predicate<Lector> checkAssistance = (Lector) -> Lector.getId() == id;
            for (Lector element : assistancences) {
                if (checkAssistance.test(element)) {
                    return element;
                }
            }
        }catch (NullPointerException e) {
            throw new IllegalArgumentException("This Assistance Or Course Is Not Created");
        }
        return null;
    }

    @Override
    public Lector getLectorById(int id) {
        try {
            Predicate<Lector> checkLector = (Lector) -> Lector.getId() == id;
            for (Lector element : lectors) {
                if (checkLector.test(element)) {
                    return element;
                }
            }
        }catch (NullPointerException e) {
            throw new IllegalArgumentException("This Lector Or Course Is Not Created");
        }
        return null;
    }
}
