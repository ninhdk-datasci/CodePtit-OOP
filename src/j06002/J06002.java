package j06002;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

class Product {
    private String code;
    private String name;
    private long price1, price2;
    private long discount, price;
    public void solve(){
        Scanner sc = new Scanner(System.in);

        long n = Long.parseLong(sc.nextLine());

        HashMap<String, Product> pros = new HashMap<>();

        for(long i=0 ; i<n ; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            long price1 = Long.parseLong(sc.nextLine());
            long price2 = Long.parseLong(sc.nextLine());
            Product p = new Product();
            p.code = code;
            p.name = name;
            p.price1 = price1;
            p.price2 = price2;
            pros.put(p.code, p);
        }
        ArrayList<Product> products = new ArrayList<>();
        long inv = Long.parseLong(sc.nextLine());
        for(long i=1 ; i<=inv ; i++){
            String[] par = sc.nextLine().split(" ");
            String code = par[0];
            long am = Long.parseLong(par[1]);
            String subCode = code.substring(0, 2);
            String type = code.substring(2);
            String fullCode = code + "-" + String.format("%03d", i);
            Product p = pros.get(subCode);
            Product p2 = new Product();
            p2.code = fullCode;
            p2.name = p.name;
            if(type.equals("1")){
                p2.price = am * p.price1;
            }
            else {
                p2.price = am * p.price2;
            }
            if (am >= 150) p2.discount = p2.price*1/2;
            else if (am >= 100) p2.discount = p2.price*3/10;
            else if (am >= 50) p2.discount = p2.price*15/100;
            products.add(p2);
        }
        Collections.sort(products, new Comparator<Product>(){
           @Override
           public int compare(Product o1, Product o2) {
               if(o1.price - o1.discount > o2.price - o2.discount) return -1;
               else return 1;
           }
        });
        for(Product p : products){
            System.out.println(p);
        }

    }
    @Override
    public String toString() {
        return code + " " + name + " " + discount + " " + (price - discount);
    }
}



public class J06002 {
    public static void main(String[] args) {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Product p = new Product();
        p.solve();
//        System.out.println(95*80000*15/100);
    }
}
