package j02021;

import java.util.*;
import java.io.*;

public class J02021 {
    static int N, K;

    static ArrayList<Integer> comb = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> list = new  ArrayList<>();

    static void generateComb(int st){
        if(comb.size() == K) {
            list.add(new ArrayList<>(comb));
            return;
        }
        for(int i=st; i<=N ; i++) {
            comb.add(i);
            generateComb(i+1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        comb = new ArrayList<>();
        list = new ArrayList<>();
        generateComb(1);
        int quantity = list.size();
        for(ArrayList<Integer> i : list){
            for(Integer j : i){
                System.out.print(j+ "");
            }
            System.out.print(' ');
        }
        System.out.println();
        System.out.println("Tong cong co " + quantity + " to hop");
    }
}
