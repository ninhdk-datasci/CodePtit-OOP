
package j03020;

import java.util.*; 



public class J03020 {
    static boolean check(String s){
        if (s.isEmpty()) return false; 
        int n = s.length(); 
        
        int left = 0; 
        int right = n-1; 
        
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false; 
            left += 1; 
            right -= 1; 
        }
        return true; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(); 
        int maxLen = 0; 
        
        while(sc.hasNext()){
            String s = sc.next(); 
//            if(s.equals("-1")) break; 
            if(check(s)){
                int n = s.length(); 
                maxLen = Math.max(n, maxLen); 
                
                if(!map.containsKey(s)){
                    map.put(s, 1); 
                }
                else {
                    int fre = map.get(s); 
                    map.put(s, fre + 1); 
                }
            }
        }
        
        for(String key: map.keySet()){
            if(key.length() == maxLen){
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
