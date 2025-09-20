package j06001;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;

class Store{
    private String code;
    private String name;
    private int price1, price2;


    public void input(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, Integer> orders = new HashMap<>();
        HashMap<String, Store> stores = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            int price1 = Integer.parseInt(sc.nextLine());
            int price2 = Integer.parseInt(sc.nextLine());
            Store s = new  Store();
            s.code = code;
            s.name = name;
            s.price1 = price1;
            s.price2 = price2;
            stores.put(code, s);
        }
        int bill = Integer.parseInt(sc.nextLine());
        for(int i=1 ; i<=bill ; i++){
            String[] part =  sc.nextLine().split(" ");
            String code = part[0];
            String fullCode = code + "-" + String.format("%03d", i);
            int orderNumber = Integer.parseInt(part[1]);
            String subCode = code.substring(0,2);
            String digit = code.substring(2);
            int total = 0;
            if (digit.equals("1")){
                total = stores.get(subCode).price1 * orderNumber;
            }
            else{
                total = stores.get(subCode).price2 * orderNumber;
            }
            int discount = 0;
            if(orderNumber >= 150) discount = total*1/2;
            else if (orderNumber >= 100) discount = total*3/10;
            else if (orderNumber >= 50) discount = total*15/100;
            System.out.println(fullCode + " " + stores.get(subCode).name + " " + discount + " " + (total - discount));
        }
    }

}


public class J06001 {
    public static void main(String[] args){
//        System.setIn(new FileInputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\input"));
//        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\NinhDB\\IdeaProjects\\CodePtit\\src\\output")));
        Store store = new Store();
        store.input();
    }
}
