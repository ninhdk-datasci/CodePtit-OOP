package j05003;
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

    public void solve(){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for(int i=0 ; i<n ; i++) {
            String code = "B20DCCN" + String.format("%03d", i+1);
            String name = sc.nextLine();
            String grade =  sc.nextLine();
            String date = sc.nextLine();
            float gpa = Float.parseFloat(sc.nextLine());
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


public class J05003 {
    public static void main(String[] args)  {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Student s = new Student();
        s.solve();
    }
}
