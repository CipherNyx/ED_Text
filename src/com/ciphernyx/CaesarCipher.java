package com.ciphernyx;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SASB
 */
public class CaesarCipher {

    private int turns;
    private String lettersUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private String lettersLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private String numberAndSymbols = "0123456789./*-+!@#$%^&(),?|';]}{[=_`~";
    private Map<Character, Character> code = new HashMap<>();

    public CaesarCipher(int turns) {
        this.turns = turns;
    }

    public String encrypt(String text) {
        
        encodeData(text, lettersUpperCase);
        encodeData(text, lettersLowerCase);
        encodeData(text, numberAndSymbols);
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : text.toCharArray()){
            sb.append(code.get(c));
        }
        
        return sb.toString();
    }
    
    public String decrypt(String text){
        
        decodeData(text, lettersUpperCase);
        decodeData(text, lettersLowerCase);
        decodeData(text, numberAndSymbols);
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : text.toCharArray()){
            sb.append(code.get(c));
        }
        
        return sb.toString();
    }
    
    private void encodeData(String text, String characters){
        
        char[] characterArray = characters.toCharArray();

        for (int i = 0; i < characterArray.length; i++) {
            char luc = characterArray[i];
            for (char c : text.toCharArray()) {
                if (luc == c) {
                    if (i == characterArray.length) {
                        code.put(c, characterArray[3]);
                    } else if (i == (characterArray.length - 1)) {
                        code.put(c, characterArray[2]);
                    } else if (i == (characterArray.length - 2)) {
                        code.put(c, characterArray[1]);
                    } else if (i == (characterArray.length - 3)) {
                        code.put(c, characterArray[0]);
                    } else {
                        code.put(c, characterArray[i + 3]);
                    }
                }
            }
        }
    }
    
    private void decodeData(String text, String characters){
        
        char[] characterArray = characters.toCharArray();
        
        for (int i = 0; i < characterArray.length; i++) {
            char luc = characterArray[i];
            for (char c : text.toCharArray()) {
                if (luc == c) {
                    if (i == 0) {
                        code.put(c, characterArray[characterArray.length-3]);
                    } else if (i == 1) {
                        code.put(c, characterArray[characterArray.length-2]);
                    } else if (i == 2) {
                        code.put(c, characterArray[characterArray.length-1]);
                    } else {
                        code.put(c, characterArray[i - 3]);
                    }
                }
            }
        }
        
    }

}
