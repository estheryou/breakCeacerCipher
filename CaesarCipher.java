import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetL = alphabet.toLowerCase();
        //Compute the shifted alphabet
        String shiftedAlphabetU = alphabet.substring(key)+
        alphabet.substring(0,key);
        String shiftedAlphabetL = alphabetL.substring(key)+
        alphabetL.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            char lower=Character.toLowerCase(currChar);
            //Find the index of currChar in the alphabet (call it idx)
            
            if(currChar==lower){
                int idx = alphabetL.indexOf(currChar);
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetL.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        else {
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetU.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
        }
       }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key1 = 21;
        int key2 = 8;
        int key =15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
         //String encrypted = encryptTwoKeys(message, key1,key2);
        //System.out.println(encrypted);
        //String decrypted = encryptTwoKeys(encrypted, 26-key1,26-key2);
        //System.out.println(decrypted);
    }
    public void testCaesar2() {
        int key1 = 14;
        int key2 = 24;
        int key =15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        //String encrypted = encrypt(message, key);
        //System.out.println(encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
         String encrypted = encryptTwoKeys(message, 26-key1,26-key2);
        System.out.println(encrypted);
        //String decrypted = encryptTwoKeys(encrypted, 26-key1,26-key2);
        //System.out.println(decrypted);
    }
    public String  encryptTwoKeys (String input, int key1,int key2){
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetL = alphabet.toLowerCase();
        //Compute the shifted alphabet
        String shiftedAlphabet1U = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet1L = (alphabet.substring(key1)+alphabet.substring(0,key1)).toLowerCase();
        String shiftedAlphabet2U = alphabet.substring(key2)+alphabet.substring(0,key2);
        String shiftedAlphabet2L = (alphabet.substring(key2)+alphabet.substring(0,key2)).toLowerCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            char lower=Character.toLowerCase(currChar);
            if(currChar==lower){
            int idx = alphabetL.indexOf(currChar);
            if(i%2==0 && idx!=-1){
                char newChar = shiftedAlphabet1L.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }else if(i%2==1&&idx!=-1){
               char newChar = shiftedAlphabet2L.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            }
            else{
                int idx = alphabet.indexOf(currChar);
            if(i%2==0 && idx!=-1){
                char newChar = shiftedAlphabet1U.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }else if(i%2==1&&idx!=-1){
               char newChar = shiftedAlphabet2U.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            }
        } 
            
         return encrypted.toString(); 
        } 
        }
     