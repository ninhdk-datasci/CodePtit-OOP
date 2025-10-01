
package j03022;
import java.util.*; 

public class J03022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        String text = ""; 
        
        while(sc.hasNext()){
            String s = sc.next();
//            if(s.equals("-1")) break; 
            text += (s + " "); 
        }
        text = text.trim(); 
        text = text.toLowerCase(); 
        int n = text.length(); 
        
        text = text.replace('.', '-'); 
        text = text.replace('?', '-'); 
        text = text.replace('!', '-'); 

        String[] sentence = text.split("-"); 
        
        for(String s: sentence){
            s = s.trim(); 
            s = s.substring(0, 1).toUpperCase() + s.substring(1); 
            System.out.println(s);
        }
    }
}
