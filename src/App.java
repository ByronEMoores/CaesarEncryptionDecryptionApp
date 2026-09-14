import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String[] choices = {"Encrypt", "Decrypt"};
        String input = " ";

        while (input != null){
            input = (String) JOptionPane.showInputDialog(
                null,                           // Parent component (null means centered on screen)
                "What would you like to do?", // The message inside the window
                "Caesar Cypher",              // The title of the window
                JOptionPane.QUESTION_MESSAGE,   // The type of message (shows a question icon)
                null,                           // Icon (null uses the default icon)
                choices,                        // The array of selection options
                choices[0]                      // The default choice selected at startup
            );

            if (input == "Encrypt"){
                EncryptMessage();
            }
            if (input == "Decrypt"){
                DecryptMessage();
            }
        }
    }

    public static void EncryptMessage(){
        int caesarShift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift for your encryption"));
        CaesarCypherHashMap caesarCypher = new CaesarCypherHashMap(caesarShift);
        String message = JOptionPane.showInputDialog("Enter the message you wish to encrypt");
        String encryptedMessage = caesarCypher.encrypt(message);
        JOptionPane.showMessageDialog(null, "Your encrypted message is " + encryptedMessage);
    }

    public static void DecryptMessage(){
        int caesarShift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift for your decryption"));
        CaesarCypherHashMap caesarCypher = new CaesarCypherHashMap(caesarShift);
        String message = JOptionPane.showInputDialog("Enter the message you wish to decrypt");
        String decryptedMessage = caesarCypher.decrypt(message);
        JOptionPane.showMessageDialog(null, "Your decrypted message is " + decryptedMessage);
    }
}