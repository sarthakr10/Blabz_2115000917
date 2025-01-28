public class q8 {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        double fahrenheit = 98.6;
        double celsius = 37;

        System.out.println(fahrenheit + " Fahrenheit is " + fahrenheitToCelsius(fahrenheit) + " Celsius");
        System.out.println(celsius + " Celsius is " + celsiusToFahrenheit(celsius) + " Fahrenheit");
    }
}