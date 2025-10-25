package controller;

import controller.StudentDatabase;
import model.Student;

public class AdminRole {
    private StudentDatabase database ;

    public AdminRole(){
        this.database = new StudentDatabase("students.txt");
        database.readFromFile();  // now when calling the admin's constructor data are loaded from File
    }

    public void addStudent(String StudentId, String name, int age, boolean
            gender, String department , float gpa){

        if(! database.contains(StudentId)) {  // to avoid repetition
            Student addedStudent = new Student(StudentId , name , age , gender , department , gpa);
            database.insertRecord(addedStudent);
            database.saveToFile();
        }
        else
            System.out.println("Student already exists !");
    }

    public void removeStudent(String key){
        if(database.contains(key)) {
            database.deleteRecord(key);
            database.saveToFile();
        }
        else
            System.out.println("No Student with this ID ");
    }

    public Student[] getListOfStudents(){

        Student[] students  = new Student[database.returnAllRecords().size()];
        students = database.returnAllRecords().toArray(students);  //converting the ready list into an array directly
        return students;
    }

    public void logout(){
        database.saveToFile();
        System.out.println("all changes saved successfully");
    }
}
