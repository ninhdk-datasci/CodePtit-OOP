
package j02026;
import java.util.*; 

public class J02026 {
    static int n, k; 
    static ArrayList<Integer> comb, arr; 
    static ArrayList<ArrayList<Integer>> listComb; 
    
    static void generate(int st){
        if(comb.size() == k){
            listComb.add(new ArrayList<>(comb)); 
            return; 
        }
        for(int i=st; i<n; i++) {
            comb.add(arr.get(i)); 
            generate(i+1); 
            comb.remove(comb.size() - 1); 
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int t = sc.nextInt(); 
        while(t-->0){
            arr = new ArrayList<>(); 
            comb = new ArrayList<>(); 
            listComb = new ArrayList<>();
            n = sc.nextInt(); 
            k = sc.nextInt(); 
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
            generate(0); 
            for(ArrayList<Integer> a: listComb){
                for(Integer x : a){
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
