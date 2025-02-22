import java.util.regex.Pattern;

public class IPAddressValidator1 {
    private static final String IP_PATTERN =
            "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

    private static final Pattern pattern = Pattern.compile(IP_PATTERN);

    public static boolean isValidIP(String ip) {
        return pattern.matcher(ip).matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.1.1",   // ✅ Valid
            "255.255.255.255", // ✅ Valid
            "0.0.0.0",         // ✅ Valid
            "256.100.50.25",   // ❌ Invalid (256 is out of range)
            "192.168.1",       // ❌ Invalid (missing one octet)
            "192.168.1.999",   // ❌ Invalid (999 out of range)
            "abc.def.ghi.jkl"  // ❌ Invalid (non-numeric)
        };

        for (String ip : testIPs) {
            System.out.println(ip + " → " + (isValidIP(ip) ? "Valid" : "Invalid"));
        }
    }
}

