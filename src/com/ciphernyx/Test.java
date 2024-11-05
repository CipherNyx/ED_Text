package com.ciphernyx;

/**
 *
 * @author SASB
 */
public class Test {

    public static void main(String[] args) {
        
        // Caesar Cipher
//        CaesarCipher cipher = new CaesarCipher(3);
//
//        String encryptedText = cipher.encrypt("@#$%^&*(DFGHJKL/.");
//        System.out.println("Encrypted: " + encryptedText);
//
//        String decryptedText = cipher.decrypt(encryptedText);
//        System.out.println("Decrypted: " + decryptedText);

        // Vigenere Cipher
        String encryptedText = VigenereCipher.encrypt("@#$%^&*(DFGHJKL/.", "xyz");
        System.out.println(encryptedText);
        
        String decryptedText = VigenereCipher.decrypt(encryptedText, "xyz");
        System.out.println(decryptedText);
    }
}
