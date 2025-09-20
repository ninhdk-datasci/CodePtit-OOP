package j04001;

import java.util.*;

class Point{
    private double x;
    private double y;
    // default constructor
    Point(){

    }
    // parameterized constructor
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    // copy constructor
    Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double distance(Point secondPoint){
        double res = Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
        return res;
    }

    public double distance(Point p1, Point p2){
        double res = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return res;
    }

    @Override
    public String toString(){
        return "j04001.Point{x=" + this.x + ", y=" + this.y + "}";
    }
}



public class J04001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            double d = sc.nextDouble();

            Point p1 = new Point(a,b);
            Point p2 = new Point(c,d);

//            System.out.println(p1);
//            System.out.println(p2);

            double dis = p1.distance(p2);

            System.out.println(String.format("%.4f", dis));

        }
    }
}
