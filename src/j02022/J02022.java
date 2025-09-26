
package j02022;
import java.util.*; 

public class J02022 {
    
    static int N; 
    static ArrayList<Integer> comb; 
    static ArrayList<ArrayList<Integer>> listComb; 
    static int[] arr = new int[100]; 
    static void generate(){
        if(comb.size() == N){
            listComb.add(new ArrayList<>(comb)); 
            return; 
        }
        for(int i=1; i<=N ; i++){
            if((arr[i] == 0 && comb.isEmpty()) || (arr[i] == 0 && Math.abs(i - comb.get(comb.size() - 1)) != 1)){
                arr[i] = 1; 
                comb.add(i); 
                generate();
                arr[i] = 0; 
                comb.remove(comb.size() - 1); 
            }
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        while(t --> 0){
            N = sc.nextInt(); 
            comb = new ArrayList<>(); 
            listComb = new ArrayList<>(); 
            arr = new int[100]; 
            generate(); 
            for(ArrayList<Integer> a: listComb){
                for(Integer x : a){
                    System.out.print(x);
                }
                System.out.println();
            }
            System.out.println("");
        }
    
    }
}
