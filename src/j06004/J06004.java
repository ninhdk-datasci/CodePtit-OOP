package j06004;
import java.io.*;
import java.util.*;


class Student{
    private String code;
    private String name;
    private String phoneNumber;
    private String teamNumber;
    private String assignment;


    @Override
    public String toString() {
        return code + " " + name + " " + phoneNumber + " " + teamNumber + " " +  assignment;
    }


    public void solve(){
        Scanner sc = new Scanner(System.in);

        String[] in = sc.nextLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        ArrayList<Student> stus = new ArrayList<Student>();
        HashMap<String, String> assign = new HashMap<>();
        for(int i=0 ; i<N ; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            String phoneNumber = sc.nextLine();
            String teamNumber = sc.nextLine();
            Student s = new Student();
            s.code = code;
            s.name = name;
            s.phoneNumber = phoneNumber;
            s.teamNumber = teamNumber;
            stus.add(s);
        }

        for(int i=1 ; i<=M ; i++){
            String assignment = sc.nextLine();
            assign.put(i+"", assignment);
        }

        Collections.sort(stus, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.code.compareTo(o2.code);
            }
        });

        for(int i=0 ; i<N ; i++) {
            Student s = stus.get(i);
            s.assignment = assign.get(s.teamNumber);
            System.out.println(s);
        }


    }

}




public class J06004 {
    public static void main(String[] args)  {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Student s = new Student();
        s.solve();
    }
}
