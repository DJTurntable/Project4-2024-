import java.util.ArrayList;
import java.util.List;

public class CompositionCipher extends Cipher {
    private List<Cipher> ciphers = new ArrayList<>();

    public void add(Cipher cipher) {
        ciphers.add(cipher);
    }

    @Override
    public char encrypt(char c) {
        for (Cipher cipher : ciphers) {
            c = cipher.encrypt(c);
        }
        return c;
    }

    @Override
    public char decrypt(char c) {
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            c = ciphers.get(i).decrypt(c);
        }
        return c;
    }

    @Override
    public String encrypt(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            result.append(encrypt(c));
        }
        return result.toString();
    }

    @Override
    public String decrypt(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            result.append(decrypt(c));
        }
        return result.toString();
    }

    @Override
    public Cipher newCopy() {
        CompositionCipher copy = new CompositionCipher();
        for (Cipher cipher : ciphers) {
            copy.add(cipher.newCopy());
        }
        return copy;
    }
}
