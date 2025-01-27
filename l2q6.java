public class l2q6 {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

public static void main(String[] args) {
    double fahrenheit = 100;
    double celsius = convertFahrenheitToCelsius(fahrenheit);
    System.out.println(fahrenheit + " Fahrenheit is " + celsius + " Celsius");

    celsius = 37;
    fahrenheit = convertCelsiusToFahrenheit(celsius);
    System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");

    double pounds = 150;
    double kilograms = convertPoundsToKilograms(pounds);
    System.out.println(pounds + " Pounds is " + kilograms + " Kilograms");

    kilograms = 68;
    pounds = convertKilogramsToPounds(kilograms);
    System.out.println(kilograms + " Kilograms is " + pounds + " Pounds");

    double gallons = 10;
    double liters = convertGallonsToLiters(gallons);
    System.out.println(gallons + " Gallons is " + liters + " Liters");

    liters = 25;
    gallons = convertLitersToGallons(liters);
    System.out.println(liters + " Liters is " + gallons + " Gallons");
    }
}