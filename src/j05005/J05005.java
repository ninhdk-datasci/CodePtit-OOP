package j05005;
import java.util.*;
import java.io.*;

class Student{
    private String code, name, date, grade;
    private float gpa;

    public Student(String code, String name, String date, String grade, float gpa) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.grade = grade;
        this.gpa = gpa;
    }

    public float getGpa() {
        return gpa;
    }

    static String stdName(String name){
        name = name.toLowerCase();
        String[] parts = name.split("\\s+");
        int len = parts.length;

        for(int i=0 ; i<len ; i++) {
            String part =  parts[i];
            part = part.substring(0,1).toUpperCase() + part.substring(1);
            parts[i] = part;
        }
        String res = "";
        for(String part : parts) res += (part + " ");
        return res.trim();
    }

    static String stdDate(String date){
        String[] parts = date.split("/");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        if(day.length() < 2) day = "0" + day;
        if(month.length() < 2) month = "0" + month;
        return day + "/" + month + "/" + year;
    }
    @Override
    public String toString() {
        return code + " " + name + " " + grade + " " + date + " " + String.format("%.2f", gpa);
    }
}

public class J05005 {
    public static void main(String[] args)  {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Student> stus = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            String code = "B20DCCN" + String.format("%03d", i+1);
            String name = sc.nextLine().trim();
            name = Student.stdName(name);
            String grade = sc.nextLine().trim();
            String date = sc.nextLine().trim();
            date = Student.stdDate(date);
            float gpa = Float.parseFloat(sc.nextLine().trim());
            Student s = new Student(code, name, date, grade, gpa);
            stus.add(s);
        }
        Collections.sort(stus, new Comparator<Student>(){
           @Override
           public int compare(Student o1, Student o2) {
               if(o1.getGpa() > o2.getGpa()) return -1;
               return 1;
           }
        });
        for(Student s : stus) {
            System.out.println(s);
        }
    }
}
