public class CaesarCipher extends Cipher {
	private int shift;

	public CaesarCipher(int shift) {
		this.shift = shift;
	}

	@Override
	public char encrypt(char c) {
		if (Character.isAlphabetic(c)) {
			char base = (Character.isLowerCase(c) ? 'a' : 'A');
			return (char) ((c - base + shift) % 26 + base);
		}
		return c;
	}

	@Override
	public char decrypt(char c) {
		if (Character.isAlphabetic(c)) {
			char base = (Character.isLowerCase(c) ? 'a' : 'A');
			return (char) ((c - base - shift + 26) % 26 + base);
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
		return new CaesarCipher(this.shift);
	}
}
