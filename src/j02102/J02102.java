
package j02102;

import java.util.*; 
public class J02102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int N = sc.nextInt(); 
        
        int[][] matrix = new int[N][N]; 
        int[] arr = new int[N*N]; 
        for(int i=0 ; i<N; i++){
            for(int j=0; j<N; j++){
                matrix[i][j] = sc.nextInt();
                arr[i*N + j] = matrix[i][j]; 
            }
        }
        Arrays.sort(arr);
        int top = 0, bottom = N-1, left = 0, right = N-1; 
        int ind = 0; 
        while (top <= bottom && left <= right){
            for(int i=left ; i<=right ; i++) {
                matrix[top][i] = arr[ind++];
            }
            top += 1; 
            for(int i=top; i <= bottom; i++){
                matrix[i][right] = arr[ind++]; 
            }
            right -= 1; 
            for(int i=right; i>=left; i--){
                matrix[bottom][i] = arr[ind++]; 
            }
            bottom -= 1;
            for(int i=bottom; i>=top; i--) {
                matrix[i][left] = arr[ind++]; 
            }
            left += 1; 
        }
        for(int i=0; i<N; i++) {
            for(int j=0 ; j<N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
