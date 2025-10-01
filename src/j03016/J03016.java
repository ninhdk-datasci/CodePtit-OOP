
package j03016;
import java.util.*; 

public class J03016 {
    
    static boolean check(String s){
        int n = s.length(); 
        
        int oddSum = 0; 
        int evenSum = 0; 
        
        for(int i=0; i<n; i++){
            char digit = s.charAt(i); 
            if(i%2 == 0){
                evenSum += (digit - '0'); 
            }
            else{
                oddSum += (digit - '0'); 
            }
        }
        
        return Math.abs(evenSum - oddSum) % 11 == 0; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int t = sc.nextInt(); 
        sc.nextLine(); 
        
        while(t-->0){
            String num = sc.nextLine(); 
            
            if(check(num)) System.out.println("1");
            else System.out.println("0");
        }
    }
}
