
package j02025;
import java.util.*; 


public class J02025 {
    static int n; 
    static ArrayList<Integer> arr; 
    static ArrayList<Integer> comb; 
    static ArrayList<ArrayList<Integer>> listComb; 
    static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num) ; i++){
            if(num % i == 0) return false; 
        }
        return num > 1; 
    }
    static void generate(int st, int k){
        if(comb.size() == k){
            int sum = 0; 
            for(Integer x : comb)sum += x; 
            if(isPrime(sum)) listComb.add(new ArrayList<>(comb)); 
            return; 
        }
        for(int i=st; i<n; i++) {
            comb.add(arr.get(i)); 
            generate(i+1, k); 
            comb.remove(comb.size() - 1); 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        
        while(t-->0){
            n = sc.nextInt(); 
            arr = new ArrayList<>(n); 
            comb = new ArrayList<>(); 
            listComb = new ArrayList<>(); 
            for(int i=0 ; i<n ; i++) {
                int x = sc.nextInt(); 
                arr.add(x); 
            }
            Collections.sort(arr, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1; 
                }
            
            });
            
            for(int i=1; i<=n ; i++) {
                generate(0, i); 
            }
            Collections.sort(listComb, new Comparator<ArrayList<Integer>>(){
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int minLen = Math.min(o1.size(), o2.size()); 
                    for(int i=0; i<minLen ; i++){
                        if(o1.get(i) != o2.get(i)) return o1.get(i) - o2.get(i); 
                    }
                    return o1.size() - o2.size(); 
                }   
            });
            
            for(ArrayList<Integer> a: listComb){
                for(Integer x : a){
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
        
    }
}
