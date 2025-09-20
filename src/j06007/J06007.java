package j06007;
import java.util.*;
import java.io.*;


class Lecturer {
    private String code;
    private String name;

    Lecturer(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

class Subject {
    private String code;
    private String name;

    Subject(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

public class J06007 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));

        Scanner sc = new Scanner(System.in);

        int ns = Integer.parseInt(sc.nextLine().trim());
        for(int i=0; i<ns; i++){
            String parts = sc.nextLine().trim();
        }

        int nl =  Integer.parseInt(sc.nextLine().trim());
        LinkedHashMap<String, String> lecturers = new LinkedHashMap<>();
        for(int i=0 ; i<nl ; i++){
            String[] parts = sc.nextLine().trim().split(" ", 2);
            String code = parts[0].trim();
            String name = parts[1].trim();
            lecturers.put(code, name);
        }

        int course = Integer.parseInt(sc.nextLine().trim());
        HashMap<String, Float> courses = new HashMap<>();
        for(int i=0 ; i<course ; i++){
            String[] parts = sc.nextLine().trim().split(" ");
            String lecCode = parts[0].trim();
            String subCode = parts[1].trim();
            float time = Float.parseFloat(parts[2].trim());
            if(!courses.containsKey(lecCode)){
                 courses.put(lecCode,time);
            }
            else {
                courses.put(lecCode, courses.get(lecCode) + time);
            }
        }

        for(String key : lecturers.keySet()){
            String name = lecturers.get(key);
            float time = courses.get(key);
            System.out.println(name + " " + String.format("%.2f", time));
        }
    }
}
