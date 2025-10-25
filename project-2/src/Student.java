public class Student {
    private String studentID;
    private String name;
    private int age;
    private boolean gender;
    private String department;
    private float gpa;

    public Student(String studentID, String name, int age, boolean gender, String department,float gpa){
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa =gpa;
    }

    public String lineRepresentation() {
//        String ageStr = Integer.toString(age);
//        String genderStr = Boolean.toString(gender);
//        String gpaStr = float.toString(gpa);
        String line = studentID + "," + name + "," + age + "," + gender + "," + department +","+ gpa;
        return line;
    }


    public String getSearchKey() {
        return studentID;
    }


    public String toString() {
        return "Student ID: " + studentID +
                ", Name: " + name +
                ", age: " + age +
                ", gender: " + gender +
                ", Department: " + department;
    }
}
