package a1template;

public class CaesarCipher {

    Character[] alphabet;

    DynamicArray<Character> cipher;

    private int offset;

    CaesarCipher(int offset) {
        this.offset = offset;

        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            this.alphabet[i] = (char) ('a' + i);
        }

        Character[] shifted = new Character[26];
        for (int i = 0; i < 26; i++) {
            int shiftedIndex = (i - offset + 26) % 26; 
            shifted[i] = this.alphabet[shiftedIndex];
        }

        this.cipher = new DynamicArray<>(26, shifted);
    }

    public int findIndex(char val) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public char get(int index) {
        return cipher.get(index);
    }

    public String encode(String message) {
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            int idx = findIndex(c);
            if (idx != -1) {
                encoded.append(cipher.get(idx));
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

    public String decode(String message) {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            int idx = -1;
            for (int i = 0; i < 26; i++) {
                if (cipher.get(i) == c) {
                    idx = i;
                    break;
                }
            }
            if (idx != -1) {
                decoded.append(alphabet[idx]);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}
