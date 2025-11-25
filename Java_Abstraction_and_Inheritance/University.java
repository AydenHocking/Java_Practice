import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class University implements UniversitySpecification {
    private ArrayList<Person> personnel;
    private String name;

    public ArrayList<Person> getPersonnel() {
        return personnel;
    }
    public University(String name) {
        this.name = name;
        personnel = new ArrayList<Person>();
    }
    public void setUp(ArrayList<Person>personnel){
        this.personnel = personnel;
    }
    public ArrayList<Student>getStudents(){
        ArrayList<Student> students = new ArrayList<Student>();
        for (Person person : personnel){
            if (person instanceof Student){
                students.add((Student) person);            
            }
        }
        return students;
    }
    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professors = new ArrayList<Professor>();
        for (Person person : personnel){
            if (person instanceof Professor){
                professors.add((Professor)person);
            }
        }
        return professors;
    }
    public void newStudent(Student s){
        personnel.add(s);
    }
    public void newProfessor(Professor p){
        personnel.add(p);
    }
}