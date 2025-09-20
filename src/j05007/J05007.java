package j05007;
import java.util.*;
import java.io.*;


class Employee {
    private String code, name, gender, date, address, taxCode, contract;

    public Employee(String code, String name, String gender, String date, String address, String taxCode, String contract) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.taxCode = taxCode;
        this.contract = contract;
    }

    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return code + " " + name + " " + gender + " " +  date + " " + address + " " + taxCode + " " + contract;
    }
}



public class J05007 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Employee> emps = new ArrayList<Employee>();

        for(int i=0 ; i<n ; i++){
            String code = String.format("%05d", i+1);
            String name = sc.nextLine().trim();
            String gender = sc.nextLine().trim();
            String date = sc.nextLine().trim();
            String address = sc.nextLine().trim();
            String taxCode = sc.nextLine().trim();
            String contract = sc.nextLine().trim();
            Employee e = new Employee(code, name, gender, date, address, taxCode, contract);
            emps.add(e);
        }
        Collections.sort(emps, new Comparator<Employee>(){
           @Override
           public int compare(Employee e1, Employee e2) {
               String d1 = e1.getDate();
               String d2 = e2.getDate();
               String[] p1 =  d1.split("/");
               String[] p2 =  d2.split("/");
               int day1 = Integer.parseInt(p1[0]);
               int day2 = Integer.parseInt(p2[0]);
               int month1 = Integer.parseInt(p1[1]);
               int month2 = Integer.parseInt(p2[1]);
               int year1 = Integer.parseInt(p1[2]);
               int year2 = Integer.parseInt(p2[2]);
               if(year1 == year2){
                   if(month1 == month2){
                       if(day1 > day2) return 1;
                       else return -1;
                   }
                   else if (month1 > month2) return 1;
                   else return -1;
               }
               else if(year1 > year2) return 1;
               else return -1;
           }
        });

        for(Employee e: emps){
            System.out.println(e);
        }
    }
}
