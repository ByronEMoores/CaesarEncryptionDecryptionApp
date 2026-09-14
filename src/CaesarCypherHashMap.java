import java.util.HashMap;

/**
 * Class for creating a hash map for encrypting or decrypting
 * 
 * @author Byron Edward Moores
 * @version 1.0, 15 Sep 2026
 */
public class CaesarCypherHashMap {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final HashMap<Character, Character> encryptionMap = new HashMap<>();
    private final HashMap<Character, Character> decryptionMap = new HashMap<>();

    // Constructor for creating HashMap
    public CaesarCypherHashMap(int shift){
        shift = (shift % 26 + 26) % 26;

        for (int i = 0; i < alphabet.length(); i++) {
            char originalChar = alphabet.charAt(i);
            
            // Find the new shifted position using math modulo % 26
            int shiftedIndex = (i + shift) % 26;
            char shiftedChar = alphabet.charAt(shiftedIndex);

            // Populate the encryption map (A -> D)
            encryptionMap.put(originalChar, shiftedChar);
            
            // Populate the decryption map (D -> A)
            decryptionMap.put(shiftedChar, originalChar);
        }
    }

    // Encrypts text using the encryption map
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        String upperText = text.toUpperCase(); // Code handles uppercase letters

        for (int i = 0; i < upperText.length(); i++) {
            char currentChar = upperText.charAt(i);

            // If the character is in our map, swap it. Otherwise, keep it (like spaces or exclamation marks).
            if (encryptionMap.containsKey(currentChar)) {
                result.append(encryptionMap.get(currentChar));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    // Decrypts text using the decryption map
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        String upperText = text.toUpperCase();

        for (int i = 0; i < upperText.length(); i++) {
            char currentChar = upperText.charAt(i);

            if (decryptionMap.containsKey(currentChar)) {
                result.append(decryptionMap.get(currentChar));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}