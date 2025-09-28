
package j04007;
import java.util.*; 

class Employee{
    private String code, name, gender, date, address, taxCode, contractDate; 
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        String name = sc.nextLine().trim(); 
        String gender = sc.nextLine().trim(); 
        String date = sc.nextLine().trim(); 
        String address = sc.nextLine().trim(); 
        String taxCode = sc.nextLine().trim(); 
        String contractDate = sc.nextLine().trim(); 
        this.code = "00001"; 
        this.name = name; 
        this.gender = gender; 
        this.date = date; 
        this.address = address; 
        this.taxCode = taxCode; 
        this.contractDate = contractDate; 
    }
    public void output(){
        System.out.println(this);
    }
    @ Override 
    public String toString(){
        return this.code + " " + this.name + " " + this.gender + " " + this.date + " " + this.address + " " + this.taxCode + " " + this.contractDate; 
    }
}

public class J04007 {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.input();
        e.output();
    }
}
