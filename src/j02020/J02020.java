package j02020;

import java.util.*;

public class J02020 {

    static int N, K;

    static ArrayList<Integer> comb = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static void generateComb(int start){
        if(comb.size() == K) {
            list.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start; i<=N ; i++) {
            comb.add(i);
            generateComb(i+1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split("\\s+");
        N = Integer.parseInt(parts[0]);
        K = Integer.parseInt(parts[1]);
        generateComb(1);
        for(ArrayList<Integer> c : list) {
            String combine = c.get(0) + "";
            for(int i=1; i<c.size() ; i++) combine = combine + " " + c.get(i);
            System.out.println(combine);
        }
        System.out.println("Tong cong co " + list.size() + " to hop");
    }
}
