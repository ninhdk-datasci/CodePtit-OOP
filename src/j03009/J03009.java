
package j03009;

import java.util.*; 


public class J03009 {
    
    static String createEmail(String name){
        name = name.toLowerCase(); 
        String[] parts = name.split("\\s+"); 
        String res = ""; 
        int n = parts.length; 
        for(int i=0; i<n-1; i++){
            String s = parts[i]; 
            res = res + s.substring(0,1);
        }
        res = parts[n-1] + res; 
        return res; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int n = Integer.parseInt(sc.nextLine()); 
        HashMap<String, Integer> fre = new HashMap<>(); 
        ArrayList<String> res = new ArrayList<>(); 
        
        for(int i=0; i<n; i++) {
            String name = sc.nextLine().trim(); 
            String email = createEmail(name); 
            int count = fre.getOrDefault(email, 0) + 1; 
            fre.put(email, count); 
            if(count == 1) email = email + "@ptit.edu.vn"; 
            else email = email + count + "@ptit.edu.vn";
            res.add(email); 
        }
        for(String e: res){
            System.out.println(e);
        }
    }
}
