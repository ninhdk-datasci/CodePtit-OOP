package j05065;
import java.util.*;
import java.io.*;

class Employee {
    private String name;
    private String position;
    private String salary;
    private String code;

    public Employee(String name, String position, String salary, String code) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.code = code;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public String getCode() {
        return code;
    }
    @Override
    public String toString() {
        return name + " " + position + " " + code + " " + salary;
    }

}


public class J05065 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        HashMap<String, ArrayList<Employee>> emps = new HashMap<>();

        for(int i=1; i<=n ; i++){
            String line = sc.nextLine().trim();
            String[] tokens = line.split(" ", 2);

            String name = tokens[1];
            String position = tokens[0].substring(0, 2);
            String salary = tokens[0].substring(2, 4);
            String code = tokens[0].substring(4);

            Employee emp = new Employee(name, position, salary, code);

            if(!emps.containsKey(position)){
                ArrayList<Employee> list = new ArrayList<>();
                list.add(emp);
                emps.put(position, list);
            }
            else {
                emps.get(position).add(emp);
            }

        }

        for(String key:  emps.keySet()){
            if(key.equals("GD")){
                while(emps.get(key).size() > 1){
                    ArrayList<Employee> list = emps.get(key);
                    int len = list.size();
                    Employee emp = list.get(len - 1);
                    emp.setPosition("NV");
                    list.remove(len - 1);
                    emps.put(key, list);
                    emps.get("NV").add(emp);
                }
            }
            if(key.equals("TP")){
                while(emps.get(key).size() > 3){
                    ArrayList<Employee> list = emps.get(key);
                    int len = list.size();
                    Employee emp = list.get(len - 1);
                    emp.setPosition("NV");
                    list.remove(len - 1);
                    emps.put(key, list);
                    emps.get("NV").add(emp);
                }
            }
            if(key.equals("PP")){
                while(emps.get(key).size() > 3){
                    ArrayList<Employee> list = emps.get(key);
                    int len = list.size();
                    Employee emp = list.get(len - 1);
                    emp.setPosition("NV");
                    list.remove(len - 1);
                    emps.put(key, list);
                    emps.get("NV").add(emp);
                }
            }

        }
        int m = Integer.parseInt(sc.nextLine().trim());
        for(int i=0; i<m ; i++){
            String pos =  sc.nextLine().trim();
            ArrayList<Employee> posList = emps.get(pos);
            Collections.sort(posList, new Comparator<Employee>(){
                @Override
                public int compare(Employee o1, Employee o2) {
                    if(o1.getSalary().equals(o2.getSalary())) {
                        return o1.getCode().compareTo(o2.getCode());
                    }
                    return o2.getSalary().compareTo(o1.getSalary());
                }
            });
            for(Employee emp:posList){
                System.out.println(emp);
            }
            System.out.println();
        }

    }
}
