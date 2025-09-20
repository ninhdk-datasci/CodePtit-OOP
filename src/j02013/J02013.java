package j02013;

import java.util.*;

public class J02013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0 ; i<n-1 ; i++) {
            boolean check = true;
            for(int j=0 ; j<n-i-1 ; j++) {
                if(arr[j] > arr[j+1]) {
                    check = false;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(check) break;
            System.out.print("Buoc " + (i+1) + ": ");
            for(int x : arr) System.out.print(x + " ");
            System.out.println();
        }
    }
}
