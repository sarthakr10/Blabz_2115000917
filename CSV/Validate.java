import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Validate {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void main(String[] args) {
        String csvFile = "csvfile.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);
                String email = columns[0];
                String phoneNumber = columns[1];

                if (!isValidEmail(email)) {
                    System.out.println("Invalid email: " + email + " in row: " + line);
                }

                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid phone number: " + phoneNumber + " in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.compile(PHONE_REGEX).matcher(phoneNumber).matches();
    }
}