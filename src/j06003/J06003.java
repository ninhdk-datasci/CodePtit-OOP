package j06003;
import java.io.*;
import java.util.*;

class Group{
    static HashMap<String, ArrayList<Student>> stus = new HashMap<>();
    static HashMap<String, String> exercise =  new HashMap<>();
}

class Student{
    private String code;
    private String name;
    private String phoneNumber;
    private String teamNumber;


    public void solve(){
        Scanner sc = new Scanner(System.in);
        String[] in =  sc.nextLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        for(int i=0 ; i<N ; i++){

            String code = sc.nextLine();
            String name = sc.nextLine();
            String phoneNumber = sc.nextLine();
            String teamNumber = sc.nextLine();
            Student s = new Student();
            s.code = code;
            s.name = name;
            s.phoneNumber = phoneNumber;

            if(!Group.stus.containsKey(teamNumber)){
                ArrayList<Student> as = new ArrayList<Student>();
                as.add(s);
                Group.stus.put(teamNumber, as);
            }
            else{
                Group.stus.get(teamNumber).add(s);
            }
        }

        for(int i=1; i<=M; i++){
            String assignment =  sc.nextLine();
            Group.exercise.put(i + "", assignment);
        }

        int Q = Integer.parseInt(sc.nextLine());
        for(int i=0 ; i<Q ; i++){
            String groupNumber = sc.nextLine();
            System.out.println("DANH SACH NHOM " +  groupNumber + ":");
            for(Student s : Group.stus.get(groupNumber)){
                System.out.println(s);
            }
            System.out.println("Bai tap dang ky: " + Group.exercise.get(groupNumber));
        }
    }
    @Override
    public String toString(){
        return this.code + " " + this.name + " " + this.phoneNumber;
    }
}


public class J06003 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Student s = new Student();
        s.solve();
    }
}
