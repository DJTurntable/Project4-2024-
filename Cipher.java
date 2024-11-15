import java.util.Scanner;

public abstract class Cipher {

    // Abstract methods for encryption and decryption on a single character
    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    // Encrypts a whole string by calling encrypt() on each character
    public String encrypt(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(encrypt(s.charAt(i)));  // Process each character
        }
        return sb.toString();
    }

    // Decrypts a whole string by calling decrypt() on each character
    public String decrypt(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(decrypt(s.charAt(i)));  // Process each character
        }
        return sb.toString();
    }

    // Create a new copy of this cipher. This needs to be overridden in the subclass.
    public abstract Cipher newCopy();
}
