package j01001;

import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long len = sc.nextInt();
        long wid = sc.nextInt();

        if (len<=0 || wid<=0) System.out.println(0);
        else{
            long perimeter = 2*(len+wid);
            long area = len*wid;
            System.out.println(perimeter + " " + area);
        }
    }
}
