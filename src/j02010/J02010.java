package j02010;

import java.util.*;


public class J02010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int step = 0;
        for(int i=0 ; i<n ; i++){
            boolean check = false;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[i]) {
                    check = true;
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
            if(check){
                step += 1;
                System.out.print("Buoc " + step + ": ");
                for(int x: arr){
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
