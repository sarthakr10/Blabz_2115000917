import java.util.Scanner;

public class Circle{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    public double Area(){
        return Math.PI * radius *radius;
    }
    public double Circumference(){
        return 2*Math.PI*radius;
    }
    public void display(){
        System.out.println("Circle Radius       : "+radius);
        System.out.printf("Circle Area          : %.2f\n", Area());
        System.out.printf("Circle Circumference : %.2f\n", Circumference());

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius : ");
        int r = sc.nextInt();
        Circle c1 = new Circle(r);
        c1.display();
    }
}
