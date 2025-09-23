package j02101;

import java.util.*;
import java.io.*;

public class J02101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());

        while(t-->0){
            int n = Integer.parseInt(sc.nextLine().trim());
            int[] arr = new int[n*n];
            String[] addValues = sc.nextLine().trim().split("\\s+");
            for(int i=0; i<n*n;i++){
                arr[i] = Integer.parseInt(addValues[i]);
            }
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for(int i=0 ; i<n*n ; i+=n){
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=i; j<i+n ; j++) {
                    row.add(arr[j]);
                }
                matrix.add(row);
            }
            for(int i=0 ; i<matrix.size() ; i++){
                if(i % 2 == 0){
                    for(Integer j : matrix.get(i)){
                        System.out.print(j + " ");
                    }
                }
                else{
                    Collections.reverse(matrix.get(i));
                    for(Integer j : matrix.get(i)){
                        System.out.print(j + " ");
                    }
                }
            }
            System.out.println();
        }

    }
}
