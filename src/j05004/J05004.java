package j05004;
import java.util.*;
import java.io.*;


class Student {
    private String code, name, date, grade;
    private float gpa;

    public Student(){
        this.code = "";
        this.name = "";
        this.date = "";
        this.grade = "";
        this.gpa = 0;
    }

    static String stdName(String name){
        String lowerName = name.toLowerCase();

        String[] parts = lowerName.split("\\s+");

        int len = parts.length;

        for(int i=0 ; i<len ; i++) {
            String part = parts[i];
            String newPart = part.substring(0, 1).toUpperCase() + part.substring(1);
            parts[i] = newPart;
        }
        String res = "";
        for(int i=0 ; i<len ; i++) {
            res = res + parts[i] + " ";
        }
        return res.trim();
    }
    static String stdDate(String date){
        String[] parts = date.split("/");
        if (parts[0].length() < 2) parts[0] = "0" + parts[0];
        if (parts[1].length() < 2) parts[1] = "0" + parts[1];
        String res = parts[0] +  "/" + parts[1] + "/" +  parts[2];
        return res;
    }



    public void solve(){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        for(int i=0 ; i<n ; i++) {
            String code = "B20DCCN" + String.format("%03d", i+1);
            String name = sc.nextLine().trim();
            String grade =  sc.nextLine().trim();
            String date = sc.nextLine().trim();
            name = stdName(name);
            float gpa = Float.parseFloat(sc.nextLine().trim());
            String[] tokens = date.split("/");
            String day = tokens[0];
            String month = tokens[1];
            String year = tokens[2];
            if(day.length() < 2) day = "0" + day;
            if(month.length() < 2) month = "0" + month;
            date = day + "/" + month + "/" + year;
            System.out.println(code + " " +  name + " " + grade + " " + date + " " + String.format("%.2f", gpa));
        }
    }


}



public class J05004 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));

        Student s = new Student();
        s.solve();
    }
}
