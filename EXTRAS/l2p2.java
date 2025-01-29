import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class l2p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Enter a date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        newDate = newDate.minusWeeks(3);

        System.out.println("Resulting date: " + newDate.format(formatter));
    }
}