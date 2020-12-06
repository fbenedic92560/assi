/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Message {
    
    private static final Integer QUANTITY_BITS_OF_BYTE = 8;
    private static final Character ZERO_CHARACTER = '0';
    
    private String addInitialQuantityOfCharacter(String binaryString, Character character, Integer quantityCharacters) {
        String paddedBinaryString;
        Character[] padArray = new Character[quantityCharacters];
        
        Arrays.fill(padArray, character);
        paddedBinaryString = "";
        for (Integer i = 0; i < quantityCharacters; i++) {
            paddedBinaryString += padArray[i];
        }
        for (Integer i = 0; i < binaryString.length(); i++) {
            paddedBinaryString += binaryString.charAt(i);
        }
        return paddedBinaryString;
    }
    
    public String convertStringToBitsArray(String message) {
        Integer asciiValue, quantityInitialZeroCharacters;
        String binaryPortionOfMessage, paddedBinaryPortionOfMessage;
        String binaryMessage = "";
        
        for (char c : message.toCharArray()) {
            asciiValue = (int) c;
            binaryPortionOfMessage = Integer.toBinaryString(asciiValue);
            quantityInitialZeroCharacters = QUANTITY_BITS_OF_BYTE - binaryPortionOfMessage.length();
            
            paddedBinaryPortionOfMessage = this.addInitialQuantityOfCharacter(binaryPortionOfMessage, ZERO_CHARACTER, quantityInitialZeroCharacters);
            binaryMessage = binaryMessage + paddedBinaryPortionOfMessage;
        }
        
        for (char c : binaryMessage.toCharArray()) {
            System.out.print(c);
        }
        
        return binaryMessage;
    }    
}
