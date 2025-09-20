package j02017;
import java.util.*;
import java.io.*;


public class J02017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1; i<n ; i++) {
            if(!st.isEmpty()){
                int top = st.pop();
                if((top + arr[i]) % 2 == 0) continue;
                else {
                    st.push(top);
                    st.push(arr[i]);
                }
            }
            else{
                st.push(arr[i]);
            }
        }
        System.out.println(st.size());
    }
}
