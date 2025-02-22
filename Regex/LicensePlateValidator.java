import java.util.regex.Pattern;

public class LicensePlateValidator {
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("^[A-Z]{2}\\d{4}$");

    public static boolean isValidLicensePlate(String plate) {
        return plate != null && LICENSE_PLATE_PATTERN.matcher(plate).matches();
    }
}
