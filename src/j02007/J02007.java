package j02007;

import java.util.*;


public class J02007 {
    public static boolean isPrime(int n){
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return n>1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=1; i<=t; i++){

            int n = sc.nextInt();
            int[] nums = new int[n];

            for(int ind=0; ind<n; ind++){
                nums[ind] = sc.nextInt();
            }

            Map<Integer, Integer> map = new LinkedHashMap<>();

            for(int num: nums){
                if(map.containsKey(num)){
                    map.put(num, map.get(num) + 1);
                }
                else{
                    map.put(num, 1);
                }
            }
            System.out.println("Test " + i + ":");
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");
            }
        }
    }
}
