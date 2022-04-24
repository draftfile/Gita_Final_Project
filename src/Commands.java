import Services.ArgumentParser;
import Services.UniManagementImpl;

import java.util.Scanner;

public class Commands {


    public  void execute() {

        Scanner sc = new Scanner(System.in);
        UniManagementImpl uniManagement = new UniManagementImpl();
        String command;
        ArgumentParser argumentParser = new ArgumentParser();
        System.out.println("Enter Your Command!\n");
        System.out.println("------EXAMPLES------\n");
        System.out.println("createCourse Name\n" + "" +
                "createStudent ID FirstName LastName FacNumber\n" +
                "createAssistance ID FirstName LastName\n" +
                "createProfessor ID FirstName LastName LectorType\n" +
                "asighStudentToCourse Student Course\n");
        while (sc.hasNext()) {
            command = sc.nextLine().trim();
            argumentParser.parseArguments(command);

            if (command.contains(ArgumentParser.CREATE_STUDENT)) {
                uniManagement.createStudent(argumentParser.getID(), argumentParser.getFirstName(), argumentParser.getLastName(), argumentParser.getFacNumber());
            }
            if (command.contains(ArgumentParser.DELETE_STUDENT)) {
                uniManagement.deleteStudent(argumentParser.getID());
            }
            if (command.contains(ArgumentParser.CREATE_COURSE)) {
                uniManagement.createCourse(argumentParser.getCourseName());
            }
            if (command.contains(ArgumentParser.DELETE_COURSE)) {
                uniManagement.deleteCourse(argumentParser.getCourseName());
            }
            if (command.contains(ArgumentParser.CREATE_ASSISTANCE)) {
                uniManagement.createAssistance(argumentParser.getID(), argumentParser.getFirstName(), argumentParser.getLastName());
            }
            if (command.contains(ArgumentParser.DELETE_ASSISTANCE)) {
                uniManagement.deleteAssistance(argumentParser.getID());
            }
            if (command.contains(ArgumentParser.CREATE_PROFESSOR)) {
                uniManagement.createProfessor(argumentParser.getID(), argumentParser.getFirstName(), argumentParser.getLastName(), argumentParser.getLectortype());
            }
            if (command.contains(ArgumentParser.DELETE_PROFESSOR)) {
                uniManagement.deleteProfessor(argumentParser.getID());
            }
            if (command.contains(ArgumentParser.ASIGHSTUDENTTOCOURSE)) {
                uniManagement.asighStudentToCourse(uniManagement.getStudentById(argumentParser.getID()), uniManagement.getCourseByName(argumentParser.getCourseName()));
            }
            if (command.contains(ArgumentParser.REMOVESTUDENTFROMCOURSE)) {
                uniManagement.removeStudentFromCourse(uniManagement.getStudentById(argumentParser.getID()), uniManagement.getCourseByName(argumentParser.getCourseName()));
            }
            if(command.contains(ArgumentParser.ASIGHASSISTANCETOCOURSE)){
                uniManagement.assignAssistantToCourse(uniManagement.getAssistantById(argumentParser.getID()),uniManagement.getCourseByName(argumentParser.getCourseName()));
            }
            if(command.contains(ArgumentParser.ASIGHPROFESSORTOCOURSE)){
                uniManagement.assignProfessorToCourse(uniManagement.getLectorById(argumentParser.getID()),uniManagement.getCourseByName(argumentParser.getCourseName()));
            }

        }


    }
}