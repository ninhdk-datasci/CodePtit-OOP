
package j02027;

import java.util.*; 


public class J02027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int t = sc.nextInt(); 
        
        while(t-->0){
            int n = sc.nextInt(); 
            int k = sc.nextInt(); 
            
            ArrayList<Integer> arr = new ArrayList<>(); 
            for(int i=0 ; i<n ; i++) {
                int x = sc.nextInt(); 
                arr.add(x); 
            }
            
            Collections.sort(arr, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2; 
                }
            });
            long count = 0; 
            for(int i=0 ; i<n-1 ; i++){
//                if(i > 0 && (arr.get(i) == arr.get(i-1))) continue;
                int x = arr.get(i); 
                
                x = x + k; 
                
                int left = i+1; 
                int right = n - 1; 
                int r = i; 
                while(left <= right){
                    int mid = left + (right - left)/2;
                    int numMid = arr.get(mid); 
                    
                    if(numMid >= x) right = mid - 1; 
                    else {
                        r = mid; 
                        left = mid + 1; 
                    }
                }
                count += (r - i); 
            }
            System.out.println(count);
        }
    }
}
