package j02036;

import java.util.*;

public class J02036 {

    static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    static int calculateLCM(int a, int b) {
        if(a == 0 || b == 0) return 0; 
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] A = new int[n];
            int[] B = new int[n + 1];

            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            B[0] = A[0];
            B[n] = A[n - 1];

            for (int i = 1; i < n; i++) {
                B[i] = calculateLCM(A[i], A[i - 1]);
            }

            for (int i = 0; i < n + 1; i++) {
                System.out.print(B[i] + " ");
            }
            System.out.println();

        }
    }
}
