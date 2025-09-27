
package j02024;
import java.util.*; 

public class J02024 {
    
    static int n; 
    static ArrayList<Integer> comb; 
    static ArrayList<ArrayList<Integer>> listComb; 
    static ArrayList<Integer> arr; 
    static void generate(int k, int st){
        if(comb.size() == k){
            int sum = 0; 
            for(Integer x : comb) sum += x; 
            if(sum % 2 != 0)listComb.add(new ArrayList<>(comb));
        }
        for(int i=st; i<n; i++){
            comb.add(arr.get(i)); 
            generate(k, i+1); 
            comb.remove(comb.size() - 1); 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int t = sc.nextInt(); 
        
        while(t-->0){
            comb = new ArrayList<>(); 
            listComb = new ArrayList<>();
            arr = new ArrayList<>();
            n = sc.nextInt(); 
            for(int i=0 ; i<n ; i++) {
                arr.add(sc.nextInt());
            }
            Collections.sort(arr, new Comparator<Integer>(){
               @Override 
               public int compare(Integer o1, Integer o2){
                   return o2 - o1; 
               }
            });
            for(int k=1; k<=n ; k++) {
                generate(k, 0); 
            }
            Collections.sort(listComb, new Comparator<ArrayList<Integer>>(){
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int minLen = Math.min(o1.size(), o2.size()); 
                   
                    for(int i=0 ; i<minLen; i++){
                        if(o1.get(i) != o2.get(i)){
                            return o1.get(i) - o2.get(i); 
                        }
                    }
                    
                    return o1.size() - o2.size(); 
                }
            });
            for(ArrayList<Integer> a : listComb){
                for(Integer x: a){
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
