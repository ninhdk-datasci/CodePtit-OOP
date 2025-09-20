package j01003;

import java.util.Scanner;

public class J01003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float a = sc.nextFloat();
        float b = sc.nextFloat();

        if (a == 0) {
            if (b == 0) System.out.println("VSN");
            else System.out.println("VN");
        }
        else {
            float res = -b / a;
            System.out.printf("%.2f\n", res);
        }
    }
}
