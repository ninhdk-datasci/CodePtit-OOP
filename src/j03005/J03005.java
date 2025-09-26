
package j03005;
import java.util.*; 

public class J03005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int N = Integer.parseInt(sc.nextLine()); 
        
        for (int n=0 ; n<N ; n++){
            String name = sc.nextLine().trim(); 
            
            name = name.toLowerCase(); 
            
            String[] parts = name.split("\\s+"); 
            
            for(int i=0 ; i<parts.length ; i++){
                parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1); 
            } 
            String res = "";
            
            for(int i=1 ; i<parts.length ; i++) {
                res = res + (parts[i] + " "); 
            }
            res = res.trim(); 
            res = res + "," + " " + parts[0].toUpperCase(); 
            System.out.println(res);
        }
    }
}
