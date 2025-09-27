
package j02028;
import java.util.*; 

public class J02028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int t = sc.nextInt(); 
        
        while(t-->0){
            int N = sc.nextInt(); 
            long k = sc.nextLong(); 
            
            long[] arr = new long[N]; 
            long[] pref = new long[N + 1]; 
            pref[0] = 0; 
            
            for(int i=0 ; i<N; i++) {
                arr[i] = sc.nextLong();
                pref[i+1] = pref[i] + arr[i]; 
            }
            boolean check = false; 
            
            int left = 1, right = 1; 
            while(left <= right && right <= N){
                if(pref[left] == k){
                    check = true; 
                    break; 
                }
                long sum = pref[right] - pref[left - 1]; 
                if(sum > k) left += 1; 
                else if(sum < k) right += 1; 
                else {
                    check = true; 
                    break; 
                }
            }
            if(check) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
