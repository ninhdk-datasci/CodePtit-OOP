
package j03007;

import java.util.*; 

public class J03007 {
    static boolean checkSum(String num){
        int sum = 0; 
        int n = num.length(); 
        
        for(int i=0; i<n ; i++) {
            sum = sum + (num.charAt(i)-'0'); 
            sum = sum % 10; 
        }        
        return sum == 0; 
    }
    static boolean checkReverse(String num){
        int n = num.length(); 
        
        int left = 0; 
        int right = n-1; 
        
        if((num.charAt(left)-'0') != 8 || (num.charAt(right)-'0') != 8) return false; 
        
        while(left <= right){
            if(num.charAt(left) != num.charAt(right)) return false; 
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
            if(checkSum(num) && checkReverse(num)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
