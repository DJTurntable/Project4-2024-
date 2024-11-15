import java.util.List;
import java.util.ArrayList;

public class VigenereCipher extends Cipher {

	private List<Integer> shifts;  // List to store the shift values

	// Constructor to initialize the shifts
	public VigenereCipher(List<Integer> shifts) {
		this.shifts = shifts;
	}

	// Override the encrypt method to apply Vigenère cipher encryption
	@Override
	public char encrypt(char c) {
		if (Character.isLetter(c)) {
			char base = Character.isUpperCase(c) ? 'A' : 'a';  // Determine base (A or a)
			int shift = shifts.get(0);  // Get the first shift value
			shifts.add(shifts.remove(0));  // Rotate the shifts (shift for next character)
			return (char) ((c - base + shift) % 26 + base);  // Apply the shift
		}
		return c;  // Non-letter characters remain unchanged
	}

	// Override the decrypt method to apply Vigenère cipher decryption
	@Override
	public char decrypt(char c) {
		if (Character.isLetter(c)) {
			char base = Character.isUpperCase(c) ? 'A' : 'a';  // Determine base (A or a)
			int shift = shifts.get(0);  // Get the first shift value
			shifts.add(shifts.remove(0));  // Rotate the shifts (shift for next character)
			return (char) ((c - base - shift + 26) % 26 + base);  // Apply the reverse shift
		}
		return c;  // Non-letter characters remain unchanged
	}

	// Create a new copy of the VigenereCipher instance
	@Override
	public Cipher newCopy() {
		return new VigenereCipher(new ArrayList<>(this.shifts));  // Copy the shifts list
	}
}
