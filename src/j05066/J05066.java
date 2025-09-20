package j05066;
import java.util.*;
import java.io.*;

class Employee {
    private String position;
    private String name;
    private String code;
    private String salary;

    public Employee(String position, String name, String code, String salary) {
        this.position = position;
        this.name = name;
        this.code = code;
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + position + " " + code + " " + salary;
    }

}

public class J05066 {
    public static void main(String[] args)  {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        Stack<Employee> gdStack = new Stack<>();
        Stack<Employee> tpStack = new Stack<>();
        Stack<Employee> ppStack = new Stack<>();
        ArrayList<Employee> employeeList = new ArrayList<>();
        for(int i=0; i<n ; i++){
            String line = sc.nextLine().trim();
            String[] tokens = line.split(" ", 2);
            String empCode = tokens[0].trim();
            String name = tokens[1].trim();
            String position = empCode.substring(0, 2);
            String salary = empCode.substring(2,4);
            String code = empCode.substring(4);
            Employee emp = new Employee(position,name,code,salary);

            if(position.equals("GD")){
                if(gdStack.size() >= 1){
                    emp.setPosition("NV");
                }
                else{
                    gdStack.push(emp);
                }
            }

            if(position.equals("TP")){
                if(tpStack.size() >= 3){
                    emp.setPosition("NV");
                }
                else{
                    tpStack.push(emp);
                }
            }

            if(position.equals("PP")){
                if(ppStack.size() >= 3){
                    emp.setPosition("NV");
                }
                else{
                    ppStack.push(emp);
                }
            }
            employeeList.add(emp);
        }
//        for(Employee e : employeeList){
//            System.out.println(e);
//        }/
        int m = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < m; i++) {
            String subStr = sc.nextLine();
            ArrayList<Employee> subList = new ArrayList<>();
            for (Employee e : employeeList) {
                String name = e.getName();
                String lowerName = name.toLowerCase();
                if (lowerName.contains(subStr.toLowerCase())) {
                    subList.add(e);
                }
            }
            Collections.sort(subList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    if (o1.getSalary().equals(o2.getSalary())) {
                        return o1.getCode().compareTo(o2.getCode());
                    }
                    return o2.getSalary().compareTo(o1.getSalary());
                }
            });
            for (Employee e : subList) {
                System.out.println(e);
            }
            System.out.println();
        }
//        System.out.println(Integer.parseInt("001"));
    }
}
