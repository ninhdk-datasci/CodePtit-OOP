package j04002;

import java.util.*;

class Rectange {
    private double width;
    private double height;
    private String color;

    Rectange(){
        this.width = 1;
        this.height = 1;
    }

    Rectange(double width, double height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth(){
        return this.width;
    }

    public void setWidth(double newWidth){
        this.width = newWidth;
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double newHeight){
        this.height = newHeight;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String newColor){
        this.color = newColor;
    }

    public double findArea(){
        double res = this.width * this.height;
        return res;
    }

    public double findPerimeter(){
        double res = (this.width + this.height)*2;
        return res;
    }

    @Override
    public String toString(){
        return "j04002.Rectange [width=" + this.width + ", height=" + this.height +  ", color=" + this.color + "]";
    }
}


public class J04002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] inputs = input.split(" ");

        double width = Double.parseDouble(inputs[0]);
        double height = Double.parseDouble(inputs[1]);
        String color = inputs[2];


        if(width <= 0 ||  height <= 0){
            System.out.println("INVALID");
        }
        else {
            Rectange rect = new Rectange(width, height, color);

            String col = rect.getColor();
            col = col.substring(0,1).toUpperCase() + col.substring(1).toLowerCase();
            rect.setColor(col);
//            System.out.println(rect);
            System.out.println(String.format("%.0f",rect.findPerimeter()) + " " + String.format("%.0f",rect.findArea()) + " " + rect.getColor());
        }
    }
}
