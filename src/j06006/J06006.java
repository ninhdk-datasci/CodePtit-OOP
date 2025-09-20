package j06006;
import java.util.*;
import java.io.*;


class Customer{
    private String code, name, gender, date, address;

    public Customer(String code, String name, String gender, String date, String address) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}

class Product {
    private String code, name, unit;
    private long buyPrice, sellPrice;

    public Product(String code, String name, String unit, long buyPrice, long sellPrice) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public long getProfit(){
        return -buyPrice + sellPrice;
    }

}

class Invoice{
    private String code, cusCode, proCode;
    private long quantity;
    private long profit;
    public long amount;
    public Invoice(String code, String cusCode, String proCode, long quantity, long profit) {
        this.code = code;
        this.cusCode = cusCode;
        this.proCode = proCode;
        this.quantity = quantity;
        this.profit = profit;
    }
    public void setAmount(long amount){
        this.amount = amount;
    }
    public String getCode() {
        return code;
    }

    public String getCusCode() {
        return cusCode;
    }

    public String getProCode() {
        return proCode;
    }

    public long getProfit() {
        return profit;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getAmount() {
        return amount;
    }

}


public class J06006 {
    public static void main(String[] args)  {
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));

        Scanner sc = new Scanner(System.in);

        long N = Long.parseLong(sc.nextLine().trim());
        HashMap<String, Customer> customers = new HashMap<>();

        for(long i=0; i<N ; i++){
            String code = "KH" + String.format("%03d", i+1);
            String name = sc.nextLine().trim();
            String gender = sc.nextLine().trim();
            String date = sc.nextLine().trim();
            String address = sc.nextLine().trim();
            Customer c = new Customer(code, name, gender, date, address);

            customers.put(code, c);
        }

        long M = Long.parseLong(sc.nextLine().trim());
        HashMap<String, Product> products = new HashMap<>();

        for(long i=0 ; i<M ; i++){
            String code = "MH" + String.format("%03d", i+1);
            String name = sc.nextLine().trim();
            String unit = sc.nextLine().trim();
            long buyPrice = Long.parseLong(sc.nextLine().trim());
            long sellPrice = Long.parseLong(sc.nextLine().trim());
            Product p = new Product(code, name, unit, buyPrice, sellPrice);
            products.put(code, p);
        }

        long K = Long.parseLong(sc.nextLine().trim());
        ArrayList<Invoice> invoices = new ArrayList<>();

        for(long i=0; i<K ; i++){
            String code = "HD" +  String.format("%03d", i+1);
            String[] parts = sc.nextLine().trim().split(" ");
            String cusCode = parts[0];
            String proCode = parts[1];
            long quantity = Long.parseLong(parts[2]);
            long profit = products.get(proCode).getProfit() * quantity;
            long amount =  products.get(proCode).getSellPrice() * quantity;
            Invoice inv = new Invoice(code, cusCode, proCode, quantity, profit);
            inv.setAmount(amount);
            invoices.add(inv);
        }

        Collections.sort(invoices, new Comparator<Invoice>(){
            @Override
            public int compare(Invoice o1, Invoice o2) {
                return Long.compare(o2.getProfit(), o1.getProfit());
            }
        });

        for(Invoice inv : invoices){
            String cusname = customers.get(inv.getCusCode()).getName();
            String address = customers.get(inv.getCusCode()).getAddress();
            String proname = products.get(inv.getProCode()).getName();
            String res = inv.getCode() + " " + cusname + " " + address + " " + proname + " " + inv.getQuantity() + " " + inv.getAmount() + " " + inv.getProfit();
            System.out.println(res);
        }
    }
}






























































