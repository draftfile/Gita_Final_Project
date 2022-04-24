package Services;

import Beans.lectorType;

public class ArgumentParser {
    public static final String CREATE_STUDENT = "createStudent";
    public static final String DELETE_STUDENT = "deleteStudent";
    public static final String CREATE_COURSE = "createCourse";
    public static final String DELETE_COURSE = "deleteCourse";
    public static final String CREATE_ASSISTANCE = "createAssistance";
    public static final String DELETE_ASSISTANCE = "deleteAssistance";
    public static final String CREATE_PROFESSOR = "createProfessor";
    public static final String DELETE_PROFESSOR = "deleteProfessor";
    public static final String ASIGHSTUDENTTOCOURSE = "asighStudentToCourse";
    public static final String REMOVESTUDENTFROMCOURSE = "removeStudentFromCourse";
    public static final String ASIGHASSISTANCETOCOURSE = "asighAssistanceToCourse";
    public static final String REMOVEASSISTANCEFROMCOURSE = "removeAssistanceFromCourse";
    public static final String ASIGHPROFESSORTOCOURSE = "asighProfessorToCourse";
    public static final String REMOVEPROFESSORFROMCOURSE = "removeProfessorFromCourse";


    private int id;
    private String facNumber;
    private String firstName;
    private String lastName;
    private String courseName;
    private lectorType lectortype;

    public void parseArguments(String argument){
        String[] array = argument.split(" ");
        if(argument.contains(CREATE_STUDENT)) {
            facNumber = (array[4].trim());
            firstName = (array[2].trim());
            lastName = (array[3].trim());
        }
        if(argument.contains(CREATE_STUDENT) || argument.contains(DELETE_STUDENT) ||
                argument.contains(CREATE_ASSISTANCE) || argument.contains(DELETE_ASSISTANCE) ||
                argument.contains(DELETE_PROFESSOR) || argument.contains(CREATE_PROFESSOR)){
            id = Integer.parseInt(array[1].trim());
        }
        if(argument.contains(CREATE_COURSE) || argument.contains(DELETE_COURSE)){
            courseName = array[1].trim();
        }
        if(argument.contains(CREATE_ASSISTANCE)){
            firstName = array[2].trim();
            lastName = array[3].trim();
        }
        if(argument.contains(CREATE_PROFESSOR)){
            firstName = array[2].trim();
            lastName = array [3].trim();
            if(array[4].trim().equalsIgnoreCase("docent")) {
                lectortype = lectorType.DOCENT;
            }
            if(array[4].trim().equalsIgnoreCase("professor")){
                lectortype = lectorType.PROFESSOR;
            }
        }
        if(argument.contains(ASIGHSTUDENTTOCOURSE)|| argument.contains(REMOVESTUDENTFROMCOURSE) ||
                argument.contains(ASIGHASSISTANCETOCOURSE) || argument.contains(ASIGHPROFESSORTOCOURSE) ||
                argument.contains(REMOVEASSISTANCEFROMCOURSE) || argument.contains(REMOVEPROFESSORFROMCOURSE)){
            id = Integer.parseInt(array[1].trim());
            courseName = array[2].trim();
        }


    }
    public int getID(){
        return id;
    }
    public String getFacNumber(){
        return facNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public lectorType getLectortype() {
        return lectortype;
    }
}