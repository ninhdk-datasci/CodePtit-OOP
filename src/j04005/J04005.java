package j04005;
import java.util.*;

class Candidate{
    private String name;
    private String date;
    private double score1, score2, score3;

    public void input(){
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        this.date = sc.nextLine();
        this.score1 = Double.parseDouble(sc.nextLine());
        this.score2 = Double.parseDouble(sc.nextLine());
        this.score3 = Double.parseDouble(sc.nextLine());
    }

    public void output(){
        Double total = this.score1 + this.score2 + this.score3;
        System.out.println(this.name + " " + this.date + " " + String.format("%.1f", total));
    }
}


public class J04005 {
    public static void main(String[] args) {
        Candidate c = new Candidate();
        c.input();
        c.output();
    }
}
