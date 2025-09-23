package j02023;
import java.util.*;
import java.io.*;


public class J02023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().trim().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        if (S == 0){
            if (N == 1) {
                System.out.println(0 + " " + 0);
                return;
            }
            else {
                System.out.println(-1 + " " + -1);
                return;
            }
        }
        if(9 * N < S) {
            System.out.println(-1 + " " + -1);
            return;
        }

        StringBuilder maxnum = new StringBuilder();
        int tmp = S;
        for(int i=0 ; i<N ; i++) {
            maxnum.append(Math.min(tmp, 9));
            tmp -= Math.min(tmp, 9);
        }
        StringBuilder minnum = new StringBuilder();
        for(int i=0 ; i<N ; i++) {
            int st = 0;
            if(i == 0 && N > 1) st = 1;
            else st = 0;
            for(int j=st ; j<=9 ; j++) {
                if((S - j >= 0) && ((S-j) <= 9*(N - i - 1))){
                    minnum.append(j);
                    S -= j;
                    break;
                }
            }
        }
        System.out.println(minnum.toString() + " "  + maxnum.toString());
    }
}
