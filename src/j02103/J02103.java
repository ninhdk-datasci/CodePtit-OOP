package j02103;
import java.util.*;

public class J02103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt(); // số bộ test
        for(int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[][] arr = new long[n][m];

            // nhập ma trận
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextLong();
                }
            }

            // nhân A với A^T
            long[][] res = new long[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    long sum = 0;
                    for(int k = 0; k < m; k++) {
                        sum += arr[i][k] * arr[j][k];
                        // lưu ý: nhân trực tiếp mà không cần tạo A^T
                    }
                    res[i][j] = sum;
                }
            }

            // in kết quả
            System.out.println("Test " + t + ":");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(res[i][j]);
                    if(j < n - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}