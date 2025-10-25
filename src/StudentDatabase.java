

import java.io.*;
import java.util.ArrayList;

public class StudentDatabase {
    private ArrayList<Student> records;
    private String filename;

    public StudentDatabase(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }

//    public abstract Student createRecordFrom(String line);
public Student createRecordFrom(String line) {
    String[] parts = line.split(",");
    int studentAge = Integer.parseInt(parts[2]);
    boolean studentGender = Boolean.parseBoolean(parts[3]);
    return new Student(parts[0], parts[1],studentAge ,studentGender , parts[4]);
}

    public void readFromFile() {
        records.clear();    // bms7 el old records before loading el new records 34an avoid duplication
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(createRecordFrom(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    public ArrayList<Student> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Student r : records) {      //for each
            if (r.getSearchKey().equals(key))
                return true;
        }
        return false;
    }
    public Student getRecord(String key) {
        for (Student r : records) {
            if (r.getSearchKey().equals(key))
                return r;
        }
        return null;
    }

    public void insertRecord(Student record) {
        records.add(record);
    }
    public void deleteRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                records.remove(i);
                break;
            }
        }
    }
        public void saveToFile() {
            try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
                for (Student r : records) {
                    pw.println(r.lineRepresentation());
                }
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }
        


}
