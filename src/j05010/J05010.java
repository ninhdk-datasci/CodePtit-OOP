package j05010;
import java.util.*;
import java.io.*;

class Product {
    private int code;
    private String name, group;
    private double sellPrice, buyPrice;
    public Product(int code, String name, String group, double sellPrice, double buyPrice) {
        this.code = code;
        this.name = name;
        this.group = group;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
    }
    public double calProfit(){
        return this.sellPrice -  this.buyPrice;
    }
    @Override
    public String toString() {
        return code + " " + name + " " +  group;
    }
}


public class J05010 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Product> pros = new ArrayList<Product>();

        for(int i=0 ; i<n ; i++){
            int code = i + 1;
            String name = sc.nextLine().trim();
            String group = sc.nextLine().trim();
            double buyPrice = Double.parseDouble(sc.nextLine().trim());
            double sellPrice = Double.parseDouble(sc.nextLine().trim());
            Product p = new Product(code, name, group, sellPrice, buyPrice);
            pros.add(p);
        }
        Collections.sort(pros, new Comparator<Product>() {
           @Override
           public int compare(Product o1, Product o2) {
               if(o1.calProfit() < o2.calProfit()) return 1;
               else return -1;
           }
        });
        for(Product p : pros){
            double profit = p.calProfit();
            System.out.println(p + " " +  String.format("%.2f", profit));
        }
    }
}
