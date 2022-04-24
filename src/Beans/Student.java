package Beans;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Student extends User {

    private String facNumber;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String facNumber, int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.facNumber = facNumber;
    }

    public static final int MAX_COURSES = 10;

    public boolean addCoursesForStudent(String name, Lector assistance, Lector lector) {
        if (courses.size() >= MAX_COURSES) return false;
        Predicate<Course> checkCourse = (course) -> course.getName().equalsIgnoreCase(name);
        for(Course element: courses){
            if(checkCourse.test(element)) return false;
        }
        courses.add(new Course(name,assistance,lector));
        return true;
    }
    public void deleteCoursesForStudent(Course course) {
        if (courses.contains(course)) {
            System.out.println("successfully delete courses for student");
            courses.remove(course);
        }else {
            System.out.println("Can't delete courses for student");
        }


    }

    public String getFacNumber() {
        return facNumber;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
