package hellojar;

import  java.util.*;

class Invoice{
    String code;
    String name;
    ArrayList<String> subject;
    double tuition;
    String QD_number;
    String QD_name;
    double unitPrice;
    Invoice(String code, String name, ArrayList<String> subject, double tuition, String QD_number, String QD_name, double unitPrice) {
        this.code = code;
        this.name = name;
        this.subject = subject;
        this.tuition = tuition;
        this.QD_name= QD_name;
        this.QD_number = QD_number;
        this.unitPrice = unitPrice;
    }
}

class PaymentController {
    public Invoice getInvoice(){
        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();
        String name = sc.nextLine();

        int numSubject = Integer.parseInt(sc.nextLine());
        ArrayList<String> subject = new ArrayList<String>();
        double totalCredit = 0;

        for(int i=0 ; i<numSubject; i++){

            String subjectCode = sc.nextLine();
            String subjectName = sc.nextLine();
            double credit = Double.parseDouble(sc.nextLine());

            subject.add(subjectName);
            totalCredit += credit;
        }

        String QD_number = sc.nextLine();
        String QD_name = sc.nextLine();
        double unitPrice = Double.parseDouble(sc.nextLine());

        double tuition = totalCredit * unitPrice;

        Invoice res = new Invoice(code, name, subject, tuition, QD_number, QD_name, unitPrice);
        return res;
    }
}
class InvoiceView{
    static void show(Invoice invoice){
        System.out.println("Mã sinh viên: " + invoice.code);
        System.out.println("Họ tên: " +  invoice.name);
        System.out.println("Các môn học:");
        for(String s : invoice.subject){
            System.out.println(s);
        }
        System.out.println("Học phí phải nộp là: " + String.format("%.1f", invoice.tuition));
        System.out.println("Theo QĐ: " +  invoice.QD_number);
    }
}

public class HELLOJAR {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}
