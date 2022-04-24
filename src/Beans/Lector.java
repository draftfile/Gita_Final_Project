package Beans;

import java.util.ArrayList;

public class Lector extends User {

    private lectorType lectorType;

    public static final int MAX_COURSES = 4;

    private ArrayList<Course> courses = new ArrayList<>();

    public Lector(int id, String firstName, String lastName, lectorType lectorType) {
        super(id, firstName, lastName);
        this.lectorType = lectorType;
    }

    public void addCoursesForLector(String name) {
        if (courses.size() == MAX_COURSES || courses.contains(name)) {
            System.out.println("Can't add courses for lector");
        } else {
            System.out.println("successfully add courses for lector");
            courses.add(new Course(name));
        }

    }
    public void deleteCoursesForLector(String name) {
        if (courses.contains(name)) {
            System.out.println("successfully delete courses for lector");
            courses.remove(name);

        } else {
            System.out.println("Can't delete courses for lector");
        }

    }


}
