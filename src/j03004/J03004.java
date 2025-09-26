package j03004;

import java.util.*;
//import java.io.*;

public class J03004 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int t = Integer.parseInt(sc.nextLine().trim()); 
        
        while(t --> 0) { 
            String str = sc.nextLine().trim(); 
            str = str.toLowerCase(); 
            
            String[] parts = str.split("\\s+"); 
            
            String res = ""; 
            for(String s: parts){
                s = s.substring(0, 1).toUpperCase() + s.substring(1); 
                res += (s + " "); 
            }
            res = res.trim();
            
            System.out.println(res);
        }
    }

}
