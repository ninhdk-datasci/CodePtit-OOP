package j02014;
import java.util.*;
import java.io.*;


public class J02014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=0 ; i<t; i++) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            int sum = 0;
            for(int ind = 0 ; ind<n ; ind++){
                arr[ind] = sc.nextInt();
                sum += arr[ind];
            }
            int[] pre = new int[n];
            pre[0] = arr[0];
            int res = -1;
            for(int j=1 ; j<n ; j++) {
                pre[j] = pre[j-1] + arr[j];
                int left = pre[j-1];
                int right = sum - pre[j];
                if(left == right) {
                    res = j ;
                    break;
                }
            }
            if(res != -1) System.out.println(res+1);
            else System.out.println("-1");
        }
    }
}
