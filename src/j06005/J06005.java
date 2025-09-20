package j06005;
import java.io.*;
import java.util.*;


class Customer {
    private String code;
    private String name;
    private String gender;
    private String date;
    private String address;

    public Customer(String code, String name, String gender, String date, String address) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
    }
    @Override
    public String toString() {
        return name + " " + address;
    }
}

class Product{
    private String code;
    private String name;
    private String unit;
    private long buyPrice;
    private long sellPrice;

    public Product(String code, String name, String unit, long buyPrice, long sellPrice) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
    public long getSellPrice(){
        return sellPrice;
    }
    @Override
    public String toString() {
        return name + " " + unit + " " + buyPrice + " " + sellPrice;
    }
}

class Invoice{
    private String code;
    Customer customer;
    Product product;
    private long quantity;

    Invoice(String code, Customer customer, Product product, long quantity) {
        this.code = code;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }
    public long getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return code + " " + customer + " " + product + " " + quantity;
    }
}


public class J06005 {
    public static void main(String[] args)  {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        HashMap<String, Customer> customers = new HashMap<>();
        for(int i=1; i<=N; i++){
            String code = "KH" + String.format("%03d", i);
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String date = sc.nextLine();
            String address = sc.nextLine();
            Customer c = new  Customer(code, name, gender, date, address);
            customers.put(code, c);
        }

        int M = Integer.parseInt(sc.nextLine());

        HashMap<String, Product> products = new HashMap<>();
        for(int i=1; i<=M; i++){
            String code = "MH" + String.format("%03d", i);
            String name = sc.nextLine();
            String unit = sc.nextLine();
            long buyPrice = Long.parseLong(sc.nextLine());
            long sellPrice = Long.parseLong(sc.nextLine());
            Product p = new  Product(code, name, unit, buyPrice, sellPrice);
            products.put(code, p);
        }

        int K = Integer.parseInt(sc.nextLine());
        for(int i=1; i<=K ; i++) {
            String code = "HD" + String.format("%03d", i);
            String[] in = sc.nextLine().split(" ");
            String cusCode = in[0];
            String proCode = in[1];
            long quantity = Long.parseLong(in[2]);
            Invoice inv = new Invoice(code, customers.get(cusCode),  products.get(proCode), quantity);
            long amount = inv.getQuantity() * products.get(proCode).getSellPrice();
            System.out.println(inv + " " + amount);
        }


    }
}
