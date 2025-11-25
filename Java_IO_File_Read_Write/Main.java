/* 
    Remember, you can check your work once you
    are done by pressing "Check Answer" in the
    bottom left of your screen without penalty
    
    Be sure to submit ASAP for max points!
*/
import java.util.*;
import java.io.*;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        ArrayList<Student> studentList = new ArrayList<Student> ();
        try{
            Scanner fileScanner = new Scanner(new File("inputData.txt"));
            String line;
            while(fileScanner.hasNext()){
                line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        }catch (FileNotFoundException ex) {
            System.out.println("Caught FNFE for inputData.txt");
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader("inputFile.txt"));
            String line2 = reader.readLine();
            while (line2 != null) {
                String[] studentData = line2.split(",");
                if (studentData.length == 7) {
                    String firstName = studentData[1];
                    String lastName = studentData[2];
                    int id = Integer.parseInt(studentData[3]);
                    String major = studentData[4];
                    double gpa = Double.parseDouble(studentData[5]);
                    int credits = Integer.parseInt(studentData[6]);
                    Student student = new Student(firstName, lastName, id, major, gpa, credits);
                    studentList.add(student);
                }
                line2 = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Collections.sort(studentList);
        for (Student student: studentList){
            student.display();
        }
        try{
            FileOutputStream fs = new FileOutputStream("ScholarshipCandididates.txt");
            PrintWriter outFS = new PrintWriter(fs);
            outFS.println("Our top Scholarships candidates are:");
            for (Student student : studentList) {
                if (student.getGPA()>=3.5){
                    outFS.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    outFS.println("GPA: " + student.getGPA());
                    outFS.println("Major: " + student.getMajor());
                    outFS.println();
                }
            }
            outFS.println("Our middle Scholarships candidates are:");
            for (Student student : studentList) {
                if (student.getGPA()<3.5 && student.getGPA()>=3.2){
                    outFS.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    outFS.println("GPA: " + student.getGPA());
                    outFS.println("Major: " + student.getMajor());
                    outFS.println();
                }
            }
            outFS.println("Ineligible Scholarships candidates are:");
            for (Student student : studentList) {
                if (student.getGPA()<3.2){
                    outFS.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    outFS.println("GPA: " + student.getGPA());
                    outFS.println("Major: " + student.getMajor());
                    outFS.println();
                }
            }
            outFS.close();
            fs.close();

        }catch (FileNotFoundException ex){
            System.out.println("Caught FNFE for ScholarshipCandididates.txt");
        }catch (IOException ex){
            System.out.println("Caught IOE for ScholarshipCandididates.txt");
        }


    }

}