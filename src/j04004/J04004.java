package j04004;
import java.util.*;

import j04004.Fraction;

class Fraction{

    private long numerator;
    private long denominator;
    private Fraction res;

    public static long GCD(long a, long b){
        if (b == 0) return a;
        return GCD(b, a%b);
    }

    public Fraction simplifyFraction(Fraction f){
        long gcd = GCD(f.numerator, f.denominator);
        f.numerator /= gcd;
        f.denominator /= gcd;
        return f;
    }

    public static Fraction add(Fraction a, Fraction b){
        a = a.simplifyFraction(a);
        b = b.simplifyFraction(b);

        Fraction res = new Fraction();
        res.denominator = a.denominator * b.denominator;
        res.numerator = (a.numerator * (res.denominator/a.denominator)) + (b.numerator * (res.denominator/b.denominator));
        return res.simplifyFraction(res);
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        Fraction p = new Fraction();
        Fraction q = new Fraction();

        p.numerator = sc.nextLong();
        p.denominator = sc.nextLong();
        q.numerator = sc.nextLong();
        q.denominator = sc.nextLong();

        res = add(p, q);
    }

    public void output(){
        System.out.println(res.toString());
    }

    @Override
    public String toString(){
        return this.numerator +  "/" + this.denominator;
    }
}

public class J04004 {
    public static void main(String[] args) {
        Fraction f = new Fraction();
        f.input();
        f.output();
    }
}
