package j02008;

import java.util.*;

public class J02008 {
    public static long gcd(long a, long b){
        if(b == 0) return a + b;
        return gcd(b, a%b);
    }

    public static long bcnn(long a, long b){
        long mul = a*b;
        return (long)mul/gcd(a,b);
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int t = sc.nextInt();

       for(int i=0; i<t ; i++){

           int n = sc.nextInt();
           long[] pre = new long[n+1];
           pre[1] = 1;

           for(int x=2; x<=n; x++){
                pre[x] = bcnn(x, pre[x-1]);
           }

           System.out.println(pre[n]);
       }
    }
}
