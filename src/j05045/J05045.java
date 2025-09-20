package j05045;
import java.util.*;
import java.io.*;

import static java.lang.Math.round;

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
    public long getSubsidy(){
        if(this.position.equals("GD")) return 500;
        else if (this.position.equals("PGD")) return 400;
        else if (this.position.equals("TP")) return 300;
        else if (this.position.equals("KT")) return 250;
        else return 100;
    }
    public long calCashAdvance(){
        if(((this.payroll() + this.getSubsidy()) *2.0/3) < 25000) {
            long res = round(((this.payroll() + this.getSubsidy())*2.0/3)/1000)*1000;
            return res;
        }
        else return 25000;
    }
    public long payroll(){
        return this.salary * this.workdays;
    }

    public String getCode() {
        return code;
    }
    @ Override
    public String toString(){
        return code + " " + name + " " + this.getSubsidy() + " " + this.payroll() + " " + this.calCashAdvance() + " " +
                (this.payroll() + this.getSubsidy() - this.calCashAdvance());
    }
}



public class J05045 {
    public static <ArrayLisy> void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);

        int n  = Integer.parseInt(sc.nextLine());

        ArrayList<Employee> emps = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            String code = "NV" + String.format("%02d", i+1);
            String name = sc.nextLine().trim();
            String position = sc.nextLine().trim();
            long salary = Long.parseLong(sc.nextLine().trim());
            long workdays = Long.parseLong(sc.nextLine().trim());
            Employee emp = new Employee(code, name, position, salary, workdays);
            emps.add(emp);
        }

        Collections.sort(emps, new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2) {
                long checkoute1 = e1.payroll() + e1.getSubsidy();
                long checkoute2 = e2.payroll() + e2.getSubsidy();
                if(checkoute1 == checkoute2) return e1.getCode().compareTo(e2.getCode());
                else if (checkoute1 > checkoute2) return -1;
                else return 1;
            }
        });

        for (Employee e : emps) {
            System.out.println(e);
        }
    }
}
