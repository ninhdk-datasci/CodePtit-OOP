package j02011;

import java.util.*;


public class J02011 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0 ; i<n-1 ; i++){
            int min = i;
            for(int j=i+1; j<n ; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
            System.out.print("Buoc " + (i+1) + ": ");
            for(int x: arr){
                System.out.print(x + " ");
            }
            System.out.println();


        }
    }
}
