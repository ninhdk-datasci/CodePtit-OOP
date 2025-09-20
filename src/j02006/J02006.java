package j02006;

import java.util.*;

public class J02006 {
    public static void input(Scanner sc, int[] A, int n){
        for(int i=0; i<n ; i++){
            A[i] = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        input(sc, A , n);
        input(sc, B , m);

        Set<Integer> merge = new TreeSet<>();

        for(int a: A) merge.add(a);
        for(int b: B) merge.add(b);

        for(int c : merge) System.out.print(c + " ");
    }
}
