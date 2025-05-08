package a1template;

/**
 * Implements a Caesar Cipher for lowercase English letters.
 * Only lowercase characters ('a' to 'z') are encoded or decoded;
 * all other characters are left unchanged.
 */
public class CaesarCipher {

    /** The standard alphabet: 'a' to 'z'. */
    Character[] alphabet;

    /** The shifted cipher alphabet used for encoding and decoding. */
    DynamicArray<Character> cipher;

    /** The offset used to shift letters in the cipher. */
    private int offset;

    /**
     * Constructs a CaesarCipher with the specified offset.
     * The cipher shifts each letter backwards by the offset value.
     *
     * @param offset the number of positions to shift in the Caesar cipher
     */
    CaesarCipher(int offset) {
        this.offset = offset;

        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            this.alphabet[i] = (char) ('a' + i);
        }

        // Create shifted cipher alphabet based on offset
        Character[] shifted = new Character[26];
        for (int i = 0; i < 26; i++) {
            int shiftedIndex = (i - offset + 26) % 26; 
            shifted[i] = this.alphabet[shiftedIndex];
        }

        this.cipher = new DynamicArray<>(26, shifted);
    }

    /**
     * Finds the index of the given character in the alphabet array.
     *
     * @param val the character to look for
     * @return the index of the character if found, or -1 if not found
     */
    public int findIndex(char val) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the character at the given index from the cipher.
     *
     * @param index the index to access
     * @return the cipher character at that index
     */
    public char get(int index) {
        return cipher.get(index);
    }

    /**
     * Encodes a message using the Caesar cipher.
     * Only lowercase alphabetic characters are transformed;
     * all other characters are left unchanged.
     *
     * @param message the original message to encode
     * @return the encoded message
     */
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

    /**
     * Decodes a message encoded with the Caesar cipher.
     * Only lowercase alphabetic characters are transformed;
     * all other characters are left unchanged.
     *
     * @param message the encoded message to decode
     * @return the original decoded message
     */
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
