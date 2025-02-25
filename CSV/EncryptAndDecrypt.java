import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptAndDecrypt {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567890123456".getBytes();
    public static void main(String[] args) throws Exception {
        String[] data = {"John Doe", "john.doe@example.com", "50000"};
        String filePath = "/Users/Sarthak/labz/CSV/data.csv";

        writeEncryptedCSV(data, filePath);
        readDecryptedCSV(filePath);
    }

    public static void writeEncryptedCSV(String[] data, String filePath) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String encryptedEmail = encrypt(data[1]);
            String encryptedSalary = encrypt(data[2]);
            writer.write(data[0] + "," + encryptedEmail + "," + encryptedSalary);
        }
    }

    public static void readDecryptedCSV(String filePath) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                String[] data = line.split(",");
                String decryptedEmail = decrypt(data[1]);
                String decryptedSalary = decrypt(data[2]);
                System.out.println("Name: " + data[0]);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
            }
        }
    }

    public static String encrypt(String valueToEnc) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        SecretKey secretKey = new SecretKeySpec(keyValue, ALGORITHM);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        return Base64.getEncoder().encodeToString(encValue);
    }

    public static String decrypt(String encryptedValue) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        SecretKey secretKey = new SecretKeySpec(keyValue, ALGORITHM);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }
}