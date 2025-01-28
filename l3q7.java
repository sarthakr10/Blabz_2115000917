import java.util.HashSet;
import java.util.Set;

public class l3q7 {
    
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> uniqueOTPs = new HashSet<>();
        for (int otp : otps) {
            if (!uniqueOTPs.add(otp)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otps[i]);
        }
        
        if (areOTPsUnique(otps)) {
            System.out.println("All generated OTPs are unique.");
        } else {
            System.out.println("Generated OTPs are not unique.");
        }
    }
}