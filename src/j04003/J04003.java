package j04003;
import  java.util.*;

import j04003.Fraction;

class Fraction{
    private long numerator;
    private long denominator;

    Fraction(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public long getNumerator(){
        return this.numerator;
    }

    public void setNumerator(long newNumerator){
        this.numerator = newNumerator;
    }

    public long getDenominator(){
        return this.denominator;
    }

    public void setDenominator(long newDenominator){
        this.denominator = newDenominator;
    }

    static long GCD(long a, long b){
        if(b==0) return a;
        return GCD(b, a%b);
    }

    @Override
    public String toString(){
        return String.valueOf(this.numerator) + "/" + this.denominator;
    }
}

public class J04003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long numerator = sc.nextLong();
        long denominator = sc.nextLong();

        Fraction frac = new Fraction(numerator, denominator);

        long gcd = Fraction.GCD(frac.getNumerator(), frac.getDenominator());

        numerator /= gcd;
        denominator /= gcd;

        frac.setNumerator(numerator);
        frac.setDenominator(denominator);

        System.out.println(frac);
    }
}
