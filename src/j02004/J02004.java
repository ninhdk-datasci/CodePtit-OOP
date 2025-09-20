package j02004;

import java.util.Scanner;

public class J02004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int j=0; j<n ; j++){
                nums[j] = sc.nextInt();
            }
            boolean flag = true;
            int left = 0;
            int right = n-1;
            while(left <= right){
                if(nums[left] != nums[right]){
                    flag = false;
                    break;
                }
                left += 1;
                right -= 1;
            }
            if(flag){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
