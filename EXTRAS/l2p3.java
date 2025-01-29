import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class l2p3 {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        String formattedDate1 = currentDate.format(formatter1);
        String formattedDate2 = currentDate.format(formatter2);
        String formattedDate3 = currentDate.format(formatter3);

        System.out.println("Current date in format dd/MM/yyyy: " + formattedDate1);
        System.out.println("Current date in format yyyy-MM-dd: " + formattedDate2);
        System.out.println("Current date in format EEE, MMM dd, yyyy: " + formattedDate3);
    }
}