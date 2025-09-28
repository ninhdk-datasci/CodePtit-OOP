package j04006;

import java.util.*;

class Student {

    private String code, name, date, grade;
    private float gpa;
//    static ArrayList<Student> arr;


    static String handleDate(String date) {
        String[] parts = date.split("/");
        if (parts[0].length() < 2) {
            parts[0] = "0" + parts[0];
        }
        if (parts[1].length() < 2) {
            parts[1] = "0" + parts[1];
        }
        return parts[0] + "/" + parts[1] + "/" + parts[2];
    }

    public void input() {
//        arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        String grade = sc.nextLine().trim();
        String date = sc.nextLine().trim();
        float gpa = Float.parseFloat(sc.nextLine().trim());
        date = handleDate(date);
        this.code = "B20DCCN001"; 
        this.name = name; 
        this.grade = grade; 
        this.date = date;
        this.gpa = gpa; 
    }

    public void output() {
//        this.input();
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.code + " " + this.name + " " + this.grade + " " + this.date + " " + String.format("%.2f", this.gpa);
    }
}

public class J04006 {

    public static void main(String[] args) {
        Student s = new Student(); 
        s.input();
        s.output();
    }
}
