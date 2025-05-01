// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    @Test
    public void testEncodeFullAlphabet() {
        CaesarCipher cipher = new CaesarCipher(1);
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expected = "zabcdefghijklmnopqrstuvwxy";
        assertEquals(expected, cipher.encode(input));
    }
    @Test
    public void testEncodeWithNumbersAndSymbols() {
        CaesarCipher cipher = new CaesarCipher(4);
        String input = "abc123!@#xyz";
        String expected = "wxy123!@#tuv";
        assertEquals(expected, cipher.encode(input));
    }

    @Test
    public void testDecodeWraparound() {
        CaesarCipher cipher = new CaesarCipher(3);
        String input = "wxyz";
        String expected = "zabc";
        assertEquals(expected, cipher.decode(input));
    }

    @Test
    public void testDecodeSymbolsOnly() {
        CaesarCipher cipher = new CaesarCipher(10);
        String input = "12345!$%^&*()";
        String expected = "12345!$%^&*()";
        assertEquals(expected, cipher.decode(input));
    }


}