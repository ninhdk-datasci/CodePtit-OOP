
package j05006;
import java.util.*;
class Employee{
    private String code, name, gender, date, address, taxCode, contractDate; 

    public Employee(String code, String name, String gender, String date, String address, String taxCode, String contractDate) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.taxCode = taxCode;
        this.contractDate = contractDate;
    }
    @ Override
    public String toString(){
        return code + " " +  name + " " + gender + " " + date + " " + address + " " + taxCode + " " +  contractDate; 
    }
    
}
public class J05006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int n = sc.nextInt(); 
        sc.nextLine(); 
        
        for(int i=0; i<n; i++) {
            String code = String.format("%05d", i+1); 
            String name = sc.nextLine().trim(); 
            String gender = sc.nextLine().trim(); 
            String date = sc.nextLine().trim(); 
            String address = sc.nextLine().trim(); 
            String taxCode = sc.nextLine().trim(); 
            String contractDate = sc.nextLine().trim(); 
            Employee e = new Employee(code, name, gender, date, address, taxCode, contractDate); 
            System.out.println(e);
        }
    }
}
