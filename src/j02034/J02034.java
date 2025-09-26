
package j02034;

import java.util.*; 

public class J02034 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int N = sc.nextInt(); 
        int[] mark = new int[1000]; 
        ArrayList<Integer> arr = new ArrayList<>(N); 
        
        while(sc.hasNextInt()){
            int x = sc.nextInt();
//            if(x == -1) break; 
            mark[x] = 1; 
            arr.add(x); 
        }
        Collections.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; 
            } 
        });
        boolean check = true; 
        int maxValue = arr.get(N-1); 
        ArrayList<Integer> res = new ArrayList<>(); 
        for(int i=1; i<= maxValue; i++){
            if(mark[i] == 0){
                check = false; 
                res.add(i); 
            }
        }
        if(check) System.out.println("Excellent!");
        else {
            for(Integer x: res){
                System.out.println(x);
            }
        }
    }
}
