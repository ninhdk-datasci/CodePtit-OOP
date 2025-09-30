
package j03006;

import java.util.*; 

public class J03006 {
    static boolean check(String s){
        if(s.isEmpty()) return false; 
        int len = s.length(); 
        
        int left = 0; 
        int right = len - 1; 
        
        while(left <= right){
            char leftC = s.charAt(left); 
            char rightC = s.charAt(right); 
            
            if(leftC % 2 != 0 || rightC % 2 != 0) return false; 
            if(leftC != rightC) return false;
            
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
            String s = sc.nextLine(); 
            
            if (check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
