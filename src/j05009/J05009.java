package j05009;

import java.util.*;
import java.io.*;

class Contestant{
    private int code;
    private String name, date;
    float score1, score2, score3;

    public Contestant(int code, String name, String date, float score1, float score2, float score3) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    public float score(){
        return score1 +  score2 + score3;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + date + " ";
    }

}


public class J05009 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Contestant> cons = new  ArrayList<Contestant>();

        for(int i=0; i<n ; i++){
            int code = i + 1;
            String name = sc.nextLine().trim();
            String date = sc.nextLine().trim();
            float score1 = Float.parseFloat(sc.nextLine().trim());
            float score2 = Float.parseFloat(sc.nextLine().trim());
            float score3 = Float.parseFloat(sc.nextLine().trim());
            Contestant c = new Contestant(code, name, date, score1, score2, score3);
            cons.add(c);
        }

        Collections.sort(cons, new Comparator<Contestant>() {
            @Override
            public int compare(Contestant o1, Contestant o2) {
                float scoreO1 = o1.score();
                float scoreO2 = o2.score();
                if(scoreO1 == scoreO2) return o1.getCode() - o2.getCode();
                else if (scoreO1 < scoreO2) return 1;
                else return -1;
            }
        });

        float highestScore = cons.get(0).score();

        for(Contestant c : cons){
            if(c.score() == highestScore){
                float score = c.score();
                System.out.println(c + String.format("%.1f", score));
            }
        }

























    }
}
