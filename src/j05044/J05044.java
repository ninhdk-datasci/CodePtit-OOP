package j05044;

import java.util.*;
import java.io.*;
import java.lang.*;

class Employee {
    private String code, name, position;
    private long salary, workdays;

    public Employee(String code, String name, String position, long salary, long workdays) {
        this.code = code;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.workdays = workdays;
    }
    public long calSalary() {
        return salary * workdays;
    }

    public long subsidy(){
        if (this.position.equals("GD")) return 500;
        else if (this.position.equals("PGD")) return 400;
        else if (this.position.equals("TP")) return 300;
        else if (this.position.equals("KT")) return 250;
        else return 100;
    }
    public long calCashAdvance(){
        long mainSalary = this.calSalary();
        long sub = 0;
        if (this.position.equals("GD")) sub = 500;
        else if (this.position.equals("PGD")) sub = 400;
        else if (this.position.equals("TP")) sub = 300;
        else if (this.position.equals("KT")) sub = 250;
        else sub = 100;
        long res = 0;
        long check = Math.round((mainSalary + sub) * 2.0/3/1000) * 1000;
        if (check < 25000) res = check;
        else res = 25000;
        return res;
    }

    @Override
    public String toString() {
        return code + " " + name;
    }
}


public class J05044 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        HashMap<String, ArrayList<Employee>> emps = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        long n = Integer.parseInt(sc.nextLine().trim());

        for(long i=0 ; i<n ; i++) {
            String code = "NV" + String.format("%02d", i+1);
            String name = sc.nextLine().trim();
            String position = sc.nextLine().trim();
            long salary = Long.parseLong(sc.nextLine().trim());
            long workdays = Long.parseLong(sc.nextLine().trim());
            Employee e = new Employee(code, name, position, salary, workdays);
            if (!emps.containsKey(position)){
                ArrayList<Employee> emp = new ArrayList<>();
                emp.add(e);
                emps.put(position, emp);
            }
            else {
                emps.get(position).add(e);
            }
        }
        String findedPos = sc.nextLine().trim();
        ArrayList<Employee> emp = emps.get(findedPos);
        for(Employee e : emp){
            long sub = e.subsidy();
            long mainSalary = e.calSalary();
            long cashAdvance = e.calCashAdvance();
            long remain = (sub + mainSalary) -  cashAdvance;
            System.out.println(e + " " + sub + " " + mainSalary + " " + cashAdvance + " " + remain);
        }

    }
}
