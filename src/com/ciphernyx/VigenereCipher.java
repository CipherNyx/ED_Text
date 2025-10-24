package com.ciphernyx;

/**
 *
 * @author SASB
 */
public class VigenereCipher {

    private static final int ALPHABET_SIZE = 26;

    // Normalize key character into a shift value
    private static int getShift(char k) {
        if (Character.isLetter(k)) {
            return Character.toUpperCase(k) - 'A'; // A=0, B=1, ...
        } else if (Character.isDigit(k)) {
            return k - '0'; // '0' = 0, '9' = 9
        } else {
            // fallback: map any other char into 0–25 range
            return (k % ALPHABET_SIZE);
        }
    }

    public static String encrypt(String text, String key) {
        StringBuilder encrypted = new StringBuilder();
        int keyLength = key.length();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = getShift(key.charAt(keyIndex % keyLength));
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int encryptedChar = (c - base + shift) % ALPHABET_SIZE;
                encrypted.append((char) (encryptedChar + base));
                keyIndex++;
            } else {
                encrypted.append(c); // keep non-letters unchanged
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder decrypted = new StringBuilder();
        int keyLength = key.length();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = getShift(key.charAt(keyIndex % keyLength));
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int decryptedChar = (c - base - shift + ALPHABET_SIZE) % ALPHABET_SIZE;
                decrypted.append((char) (decryptedChar + base));
                keyIndex++;
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }

}
