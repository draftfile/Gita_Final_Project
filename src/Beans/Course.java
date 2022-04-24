package Beans;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Course {
    private String name;
    private ArrayList <Student> students = new ArrayList<>();
    private Lector assistance;
    private Lector lector;

    public static final int MAX_STUDENTS = 30;

    public Course(String name) {
        this.name = name;
    }
    public Course(String name,  Lector lector, Lector assistance) {
        this.name = name;
        this.lector = lector;
        this.assistance = assistance;
    }

    public void addingStudent(Student student) {
        if (students.size() == MAX_STUDENTS || students.contains(student)) {
            System.out.println("Can't add student");
        } else {
            System.out.println("successfully add student");
            students.add(student);
        }

    }
    public void deleteStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("successfully delete student");
            students.remove(student);
        }else {
            System.out.println("Can't delete student");
        }
    }


    public boolean setAssistance(Lector assistance) {
        if (this.assistance != null && this.assistance.equals(assistance)) {
            return false;
        }
        this.assistance = assistance;
        return true;
    }
    public boolean setLector(Lector lector) {
        if(this.lector != null && this.lector.equals(lector)) {
            return false;
        }

        this.lector = lector;
        return true;
    }

    public String getName() {
        return name;
    }
    public Lector getAssistance() {
        return assistance;
    }

    public Lector getLector() {
        return lector;
    }
    public boolean addStudentToCourse(Student student)   {

        if(students.size() >= 30) return false;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == student.getId() && Student.getLastName().equalsIgnoreCase(student.getLastName())
                && Student.getFirstName().equalsIgnoreCase(student.getFirstName()));
        for(Student element: students){
            if(checkStudent.test(element)){

                return false;
            }
        }
        Student newStudent = new Student(student.getFacNumber(), student.getId(), student.getFirstName(), student.getLastName());
        students.add(newStudent);
        return true;
    }
    public void  printStudentArray(){
        System.out.println("---Course With Students---");
        if(getAssistance() != null){
            System.out.println("Assistance: " + getAssistance().getId() + " " + getAssistance().getFirstName() + " " + getAssistance().getLastName());

        }
        if(getLector() != null){
            System.out.println("Lector: " + getLector().getId() + " " + getLector().getFirstName() + " " + getLector().getLastName());
        }

        for (Student element : students){
            System.out.println("[" +element.getId() + ", " + element.getFirstName() + ", " + element.getLastName()+"]");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }


}
