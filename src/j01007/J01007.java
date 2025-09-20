package j01007;

import java.util.Scanner;

public class J01007 {
    public static void main(String[] args) {
        long[] fibo = new long[93];

        fibo[0] = 0;
        fibo[1] = 1;

        for(int i=2; i<93; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            long n = sc.nextLong();
            boolean check = false;
            for(int ind=0; ind<93; ind++){
                if(fibo[ind] == n){
                    check = true;
                    break;
                }
            }
            if(check) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
