package j06008;

import java.util.*;
import java.io.*;


class Subject{
    private String code;
    private String name;
    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

class Lecturer {
    private String code;
    private String name;
    public Lecturer(String code, String name) {
        this.code = code;
        this.name = name;
    }
}


public class J06008 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);

        int ns = Integer.parseInt(sc.nextLine().trim());
        LinkedHashMap<String, String> subjects = new LinkedHashMap<>();
        for(int i=0 ; i<ns ; i++){
            String[] parts = sc.nextLine().trim().split(" ", 2);
            String code = parts[0].trim();
            String name = parts[1].trim();
            subjects.put(code, name);
        }

        int nl = Integer.parseInt(sc.nextLine().trim());
        LinkedHashMap<String, String> lecturers = new LinkedHashMap<>();
        for(int i=0; i<nl ; i++){
            String[] parts = sc.nextLine().trim().split(" ", 2);
            String code = parts[0].trim();
            String name = parts[1].trim();
            lecturers.put(code, name);
        }

        int c = Integer.parseInt(sc.nextLine().trim());
        LinkedHashMap<String, Float> times = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> modules = new LinkedHashMap<>();
        for(int i=0; i<c ; i++){
            String[] parts = sc.nextLine().trim().split(" ");
            String lecCode = parts[0].trim();
            String subCode = parts[1].trim();
            float time = Float.parseFloat(parts[2].trim());
            if(!modules.containsKey(lecCode)) {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(subCode + " " + time);
                modules.put(lecCode, tmp);
            }
            else{
                modules.get(lecCode).add(subCode + " " + time);
            }
            if(!times.containsKey(lecCode)){
                times.put(lecCode, time);
            }
            else{
                times.put(lecCode, times.get(lecCode) + time);
            }

        }

        String staCode = sc.nextLine().trim();
        System.out.println("Giang vien: " + lecturers.get(staCode));

        ArrayList<String> moduleList = modules.get(staCode);
        for(String module : moduleList){
            String[] p = module.split(" ");
            String subject = p[0].trim();
            String time = p[1].trim();
            System.out.println(subjects.get(subject) + " " + time);
        }

        float total = times.get(staCode);
        System.out.println("Tong: " + String.format("%.2f", total));

    }
}
