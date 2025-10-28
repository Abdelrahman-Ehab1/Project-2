package model;

public class Student {
    private String studentID;
    private String name;
    private int age;
    private boolean gender;
    private String department;
    private float gpa;

    public Student(String studentID, String name, int age, boolean gender, String department,float gpa){  // to be modified
        setStudentID(studentID);
        setName(name);
        setAge(age);
        setGender(gender);
        setDepartment(department);
        setGpa(gpa);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID){    //check for random id generate part //
       if( studentID!=null && studentID.matches("\\d+") && !studentID.trim().isEmpty() ){  //studentID doesn't contain letters only digits
             this.studentID = studentID;
       }
       else{
           System.out.println("Student ID must consist of digits only and must not be empty");
       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty() && name.matches("^[a-zA-Z]+(\\s+[a-zA-Z]+)+$")) {  //^:bedayt el string  // $:nehayt el string
            this.name = name;
        } else {
            System.out.println("Name must have only letters and spaces and be atleast 2 names (cannot be empty)");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {   // kda kda msh hy2bl haga tdkhlo gher el int
        if( age >= 16 && age <= 60){
            this.age = age;
        }
        else{
            System.out.println("Age must range from 16 to 60");
        }
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {  // true means male   // false means female
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department!=null && !department.trim().isEmpty()){
            this.department = department;
        }
        else{
            System.out.println("Department can't be empty");
        }
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {  // kda kda msh hy2bl haga tdkhlo gher el float
        if( gpa >= 0 && gpa <= 4 ){
            this.gpa = gpa;
        }
        else{
            System.out.println("GPA must range from 0 to 4");
        }
    }

    public String lineRepresentation() {  // sent to database
        String line = studentID+","+name+","+age+","+gender+","+department+","+gpa;
        return line;
    }

    public String getSearchKey() {   // will be used to delete or update student
        return studentID;
    }

}
