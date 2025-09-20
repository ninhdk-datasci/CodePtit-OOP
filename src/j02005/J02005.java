package j02005;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class J02005 {
    public static void input(Scanner sc, int[] A, int n){
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        input(sc, A, n);  Arrays.sort(A);
        input(sc, B, m);  Arrays.sort(B);

        int iter_A = 0;
        int iter_B = 0;

        Set<Integer> list = new TreeSet<>();

        while(iter_A < n && iter_B < m) {
            if(A[iter_A] == B[iter_B]) {
                list.add(A[iter_A]);
                iter_A += 1; iter_B += 1;
            }
            else if(A[iter_A] < B[iter_B]){
                iter_A += 1;
            }
            else {
                iter_B += 1;
            }
        }
        for(int num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
