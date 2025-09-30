
package j03008;

import java.util.*; 
public class J03008 {
    
    static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) return false; 
        }
        return n > 1; 
    }
    
    static boolean isBeautiNum(String num){
        int n = num.length(); 
        
        int left = 0; 
        int right = n - 1; 
        
        while(left <= right){
            char leftChar = num.charAt(left); 
            char rightChar = num.charAt(right); 
            
            if(!isPrime(leftChar-'0') || !isPrime(rightChar-'0')) return false; 
            
            if(leftChar != rightChar) return false; 
            
            left += 1; 
            right -= 1; 
        }
        return true; 
    }
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        
        int t = sc.nextInt(); 
        sc.nextLine(); 
        
        while(t-->0){
            String num = sc.nextLine(); 
            
            if(isBeautiNum(num)) System.out.println("YES");
            else System.out.println("NO");
        }
        
    }
}
