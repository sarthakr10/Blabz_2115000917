package Oops;

public class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(String name , int id , double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void display(){
        System.out.println("Employee Details");
        System.out.println("Employee name   : "+ name);
        System.out.println("Employee id     : "+id);
        System.out.println("Employee salary : "+salary);
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ayan", 49 , 50000);
        emp1.display();
    }
}