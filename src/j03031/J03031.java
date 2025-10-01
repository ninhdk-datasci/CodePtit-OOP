
package j03031;

import java.util.*;
public class J03031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        
        
        int t = sc.nextInt(); 
        sc.nextLine(); 
        while(t-->0){
            HashSet<Character> set = new HashSet<>(); 
            String s = sc.nextLine(); 
            int k = Integer.parseInt(sc.nextLine()); 
            
            int n = s.length(); 
            for(int i=0; i<n; i++){
                char c = s.charAt(i); 
                set.add(c); 
            }
            
            int shortageChar = 26 - set.size(); 
            
            int replacePlace = n - set.size(); 
            
            if(replacePlace < shortageChar) System.out.println("NO");
            else{
                if(shortageChar > k) System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }
}
