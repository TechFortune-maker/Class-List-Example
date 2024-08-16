
package za.ac.tut.student;

import java.util.List;

/**
 *
 * @author Osego
 */
public class Student {
    private String name;
    private String surname;
    private int studentNo;
    private List<String> listOfSubjects;

    public Student(String name, String surname, int studentNo, List<String> listOfSubjects) {
        this.name = name;
        this.surname = surname;
        this.studentNo = studentNo;
        this.listOfSubjects = listOfSubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public List<String> getListOfSubjects() {
        return listOfSubjects;
    }

    public void setListOfSubjects(List<String> listOfSubjects) {
        this.listOfSubjects = listOfSubjects;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", studentNo=" + studentNo + ", listOfSubjects=" + listOfSubjects + '}';
    }
    
    
}
