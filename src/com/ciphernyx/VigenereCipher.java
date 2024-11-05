package com.ciphernyx;

/**
 *
 * @author SASB
 */
public class VigenereCipher {
    
    private static final int ALPHABET_SIZE = 26;
    
    public static String encrypt(String text, String key){
        
        StringBuilder encryptedText = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        
        int keyLength = key.length();
        int keyIndex = 0;
        
        for(char c : text.toCharArray()){
            
            // Check is Character a Letter
            if(Character.isLetter(c)){
                
                // Converting letters to 0-25 range
                int textCharacter = c - 'A';
                int keyCharacter = key.charAt(keyIndex % keyLength)-'A';
                
                // VigenereCipher Applying
                int encryptedCharacter = (textCharacter + keyCharacter) % ALPHABET_SIZE;
                
                // Appending the letter to encrypted text
                encryptedText.append((char) (encryptedCharacter + 'A'));
                
                keyIndex++;
                
            } else {
                // If non-letter character, it will not change
                encryptedText.append(c);
            }
        }
        
        return encryptedText.toString();
    }
    
    public static String decrypt(String encryptedText, String key){
        
        StringBuilder text = new StringBuilder();
        
        encryptedText = encryptedText.toUpperCase();
        key = key.toUpperCase();
        
        int keyLength = key.length();
        int keyIndex = 0;
        
        for(char c : encryptedText.toCharArray()){
        
            // Check is Character a Letter 
            if(Character.isLetter(c)){
                
                // Converting letters to 0-25 range
                int encryptedTextCharacter = c - 'A';
                int keyCharacter = key.charAt(keyIndex % keyLength)-'A';
                
                // VigenereCipher Applying
                int decryptedCharacter = (encryptedTextCharacter - keyCharacter + ALPHABET_SIZE) % ALPHABET_SIZE;
                
                // Converting letter and appending to the decrypted text
                text.append((char) (decryptedCharacter + 'A'));
                
                keyIndex++;
                
            } else {
                // If non-letter character, it will not change
                text.append(c);
            }
        }
        
        return text.toString();
    }
    
}
