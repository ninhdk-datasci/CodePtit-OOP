package j02012;

import java.util.*;


public class J02012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Buoc 0: " + arr[0]);

        for(int i=1; i<n ; i++){
            int key = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;

            System.out.print("Buoc " + i + ": ");

            for(int x=0; x<=i; x++) {
                System.out.print(arr[x] + " ");
            }

            System.out.println();
        }
    }
}
