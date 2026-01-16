package uestc.EX1;
import java.io.*;
import java.util.Scanner;

public class SimpleDatabase implements Serializable{
    private String filepath;

    public SimpleDatabase(String filepath, CourseSelection[] cs) {
        this.filepath = filepath;
        this.cs = cs;
    }

    public CourseSelection[] cs;

    public void setCs(CourseSelection[] cs) {
        this.cs = cs;
    }

    public void readData() {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
            for (int i = 0; i < cs.length; i++) {
                cs[i] = (CourseSelection) ois.readObject();
                System.out.println(cs[i].getStudent());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath, true));
            for (int i = 0; i < cs.length; i++) {
                CourseSelection courseSelection = cs[i];
                oos.writeObject(courseSelection);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
