
package listexample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import za.ac.tut.student.Student;
/**
 *
 * @author Osego
 */
public class ListExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare all variables
        String name="";
        int studNo = 0;
        
        List<Student> students = new ArrayList<>();
        
        //add subjects to the list of students 
        
        List<String> subject1 = new ArrayList<>();
        subject1.add("Mathematics");
        subject1.add("Physical Sciences");
        subject1.add("Life Sciences");
        
        List<String> subject2 = new ArrayList<>();
        subject2.add("Accounting");
        subject2.add("Business Studies");
        subject2.add("Economics");
        
        List<String> subject3 = new ArrayList<>();
        subject3.add("Tourism");
        subject3.add("Economics");
        subject3.add("History");
        
        List<String> subject4 = new ArrayList<>();
        subject4.add("Music");
        subject4.add("Arts and culture");
        subject4.add("Geography");
        subject4.add("Agricultural Sciences");
          
        
        //add subjects to the list of students 
        
        students.add(new Student("Osego","Mere",222810000,subject1));
        students.add(new Student("Lesedi","Matlokwe",222789011,subject2));
        students.add(new  Student("John", "Kubayi", 239484947, subject3));
        
        Student student1 = new Student("Boineelo","Mere", 240911209,subject4);
        
        students.add(student1);
  
        //display all students in the class list
        for(Student student: students){
            System.out.println(student.toString());
        }

        //invoke the method to remove a student
        RemoveStudent(students, name);
       
        //List after the removal 
        System.out.println("After we removed the student");
        
        for (int i = 0; i < students.size(); i++) {
            
            System.out.println(students.get(i).toString());
        }
        
        //search a student 
        searchStudent(students, studNo);
        
        //update a student 
        updateStudent(students);
        
        //save to file 
        saveTofile(students);
       
    }public static void RemoveStudent(List<Student> students, String name){
        
         //prompt the user the student number we want to remove 
         Scanner sc = new Scanner(System.in);
          
         System.out.println("\n");
         System.out.println("Enter the name of the student you want to remove: ");
         name = sc.next();
          
         //declare an object

        Student studentToRemove = null;
        
        for(Student student: students){
           //search the name of the student you want to remove 
           if(student.getName().equals(name)){
              studentToRemove = student;
              break;
           }
        }
        
        //check if the student to remove is not null
        
        if(studentToRemove!= null){
            students.remove(studentToRemove);
        }
  
    
    }public static void searchStudent(List<Student> students, int studNo){
        
        //Search for a student 
        
        //promt the use for the student number 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student number you want to search for: ");
        studNo = sc.nextInt();
  
        //declare an object to store the name
        Student searchStudent= null;

        //run through a loop to compare the student number with the one you have on the list
        
        for(Student student: students){
        
           if(student.getStudentNo() == studNo){
               searchStudent = student;
               break;
           }
        }
        
        //display the object
        
        System.out.println("Student we searched for: ");
        System.out.println(searchStudent.toString());
        
    }public static void updateStudent(List<Student> students){
         
        //Prompt the user for the student number 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student number you want to search for: ");
        int studNo = sc.nextInt();
        
        //find the student you want to update 
        Student studentUpdate = null;
        
            for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getStudentNo() == studNo){
                    studentUpdate = students.get(i);
                }  
            }
         //check if the student is not null
         
         if(studentUpdate != null){
             System.out.println("Student found: "+ studentUpdate.toString());
             
             System.out.println("Enter the part you want to update: ");
             System.out.println("1.Name: ");
             System.out.println("2.Surname: ");
             System.out.println("3.Student number: ");
             System.out.println("4.List of subjects: ");
             System.out.println("Your option: ");
             int option = sc.nextInt();
             
             switch(option){
                 case 1: 
                     System.out.print("Enter your new name: ");
                     String name = sc.next();
                     
                     studentUpdate.setName(name);
                 break;
                 
                 case 2: 
                     System.out.println("Enter the new surname: ");
                     String surname = sc.next();
                     
                     studentUpdate.setName(surname);
                break;
                
                 case 3: 
                     System.out.print("Enter the new student number: ");
                     int studentNo = sc.nextInt();
                     studentUpdate.setStudentNo(studentNo);
                     
                     studentUpdate.setStudentNo(studentNo);
                 break;
                 case 4: 
                     List<String> newSubject = new ArrayList<>();
                     
                     System.out.print("Enter the number of subjects: ");
                     int noOfSubjects = sc.nextInt();
                     
                     for (int i = 0; i < noOfSubjects; i++) {
                          System.out.print("Enter subject "+(i+1)+": "); 
                          String subject = sc.next();
                          
                          newSubject.add(subject);
     
                     }
                     studentUpdate.setListOfSubjects(newSubject);
                 break;
                 
                default:
                     System.out.println("Invalid option.");

             }
             System.out.println("Student details updated successfully!!!");

         }else{
             System.out.println("Student not found.");
         }
         
        System.out.println("After update: "+studentUpdate.toString());

    }public static void saveTofile(List<Student> students){
         File file = new File("student.txt");
         BufferedWriter bw;
         
        try {
            bw = new BufferedWriter(new FileWriter(file));
            //write data to a file 
            for (int i = 0; i < students.size(); i++) {
                
                //write data to a file 
                bw.write(students.get(i).toString()+"\n");
                
                //close the stream
                
                bw.close();
            }
            JOptionPane.showMessageDialog(null, "Students succefully saved to the student.txt");
            
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "An error occured while saving to the file.");
        }

    }
 
}

