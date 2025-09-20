package j01005;

import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=0; i<t; i++){

            double N = sc.nextFloat();
            double H = sc.nextFloat();
            double h1 = H/(Math.sqrt(N));

            System.out.printf("%.6f ", h1);
            for(int x=2; x<=N-1 ; x++){
                double num = h1*(Math.sqrt(x));
                System.out.printf("%.6f ", num);
            }
            System.out.println();
        }
    }
}
