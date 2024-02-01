import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day10 {

    public static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] encodedHash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String inputString = "Hello, Hashing!";
        String hashedResult = hashString(inputString);

        System.out.println("Original String: " + inputString);
        System.out.println("Hashed Result: " + hashedResult);
    }
}
