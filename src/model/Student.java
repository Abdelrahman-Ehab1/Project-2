package model;

public class Student {
    private String studentID;
    private String name;
    private int age;
    private boolean gender;
    private String department;
    private float gpa;

    public Student(String studentID, String name, int age, boolean gender, String department,float gpa){  // to be modified
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa =gpa;
    }

    public String lineRepresentation() {  // sent to database
        String line = studentID + "," + name + "," + age + "," + gender + "," + department +","+ gpa;
        return line;
    }

    public String getSearchKey() {   // will be used to delete or update student
        return studentID;
    }

}
