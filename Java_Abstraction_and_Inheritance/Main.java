import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void showProfile(Person p, int id){
        if (p.getId() == id){
            p.display();
        }
    }

    public static void main(String[] args) {
        System.out.println("**** Part A ****");
        //Person p = new Person("Raya", "Whitker", 800555555);
        // p.display();

        System.out.println("**** Part B ****");
        Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        Student s5 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        System.out.println(s1);
        s1.setTransfer(true);
        s1.setBalance(100);
        s1.addCourse("Java Programming");
        s1.addCourse("Calculus");

        s1.display();

        if (s1.dropCourse("Spanish")){
            System.out.println("Class Dropped");
        }else{
            System.out.println("Not Enrolled in Course, Nothing Dropped");
        }

        ArrayList<String> enrolledCourses = s1.getEnrolledCourses();
        System.out.println("Current Enrollment:");
        for (String course : enrolledCourses){
            System.out.println(course);
        }


        System.out.println("**** Part C ****");
        Student s2 = new Student("Katherine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kinberly", "Bryant", 902, "EE", 3.0, 80);

        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
        System.out.println(prof1);
        prof1.addAdvisee(s2);
        prof1.addAdvisee(s3);
        prof1.addAdvisee(s4);
        prof1.display();

        if (prof1.removeAdvisee(902)){
            System.out.println("Advisee Removed");
        }else{
            System.out.println("Not an advisee of Professor " + prof1.getFirstName() + " " + prof1.getLastName());
        }

        ArrayList<Student> myAdvisees = prof1.getAdvisees();
        System.out.println("Professor " + prof1.getFirstName() + " " + prof1.getLastName() + " Advisees:");
        for (Student s : myAdvisees){
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals(prof1));

        Person[] personArray ={s1,s2,prof1};
        ArrayList<Person> personList = new ArrayList();
        personList.add(s1);
        personList.add(s2);
        personList.add(prof1);
        System.out.println("Contents of Person List:");
        for (Person person : personList)
            System.out.println(person);


        //Lab 8 A:
        System.out.println("LAB 8: *********************************8");
        ArrayList<Person> contactList = new ArrayList();
        contactList.add(s1);
        contactList.add(s2);
        contactList.add(s3);
        contactList.add(s4);
        contactList.add(prof1);
        
        //Person p2 = new Person("Ellie", "Kambol", 800);
        // contactList.add(p2);
        Professor prof2 = new Professor("Frank", "Black", 801, "Math", 85000);
        contactList.add(prof2);
        Student s6 = new Student("Grace", "Maxeem", 903, "Psychology", 3.4, 95);
        contactList.add(s6);
        for(int i = 0; i < contactList.size(); i++){
            contactList.get(i).display();
        }

        //Lab 8 B:
        System.out.println("Part B:Lab 8");
        for (Person person: contactList){
            showProfile(person, 903);
        }
        //Lab 8 C:
        //Person p3 = new Student("Maya", "Adams", 700, "Music", 3.5, 105);
        // System.out.println(((Student)p3).getGPA());
        // Person p4 = new Person("Bob", "Lowe", 701);
        // if (p4 instanceof Student) {
        //     System.out.println(((Student)p4).getGPA());
        // }

        for (Person person: contactList)
            if (person instanceof Student) {
                if (((Student)person).getGPA()>3.5){
                    System.out.println("*******Meets Scholarship Req.:*******");
                    person.display();
                }

            }

        for (Person person: contactList)
            if (person instanceof Professor) {
                if (((Professor)person).getDepartment() == "CS"){
                    System.out.println("*******Meets Department Req.:*******");
                    person.display();
                }

            }
        System.out.println("****************Sort*****************");

        int compareStudents = s4.compareTo(s1);
        System.out.println(compareStudents);    
        
        ArrayList<Student> students = new ArrayList();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        Collections.sort(students);
        for (Student s : students){
            System.out.println(s.getGPA());
        }
        System.out.println("*************************************");

    }


}
