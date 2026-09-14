import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * Application that lets you encrypt and decrypt 
 * messages using a caesar cypher with a custom shift
 * 
 * @author Byron Edward Moores
 * @version 1.0, 15 Sep 2026
 */
public class App {
    public static void main(String[] args) throws Exception {
        String[] choices = {"Encrypt", "Decrypt"};
        String input = "";

        while (input != null){
            input = (String) JOptionPane.showInputDialog( // Create an input dialogue with choices as the dropdown options
                null,
                "What would you like to do?",
                "Caesar Cypher",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]
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
        JOptionPane.showMessageDialog(null, CopyableText(encryptedMessage), "Your encrypted message is", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void DecryptMessage(){
        int caesarShift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift for your decryption"));
        CaesarCypherHashMap caesarCypher = new CaesarCypherHashMap(caesarShift);
        String message = JOptionPane.showInputDialog("Enter the message you wish to decrypt");
        String decryptedMessage = caesarCypher.decrypt(message);
        JOptionPane.showMessageDialog(null, CopyableText(decryptedMessage), "Your decrypted message is", JOptionPane.INFORMATION_MESSAGE);
    }

    public static JTextField CopyableText(String message){
        JTextField textField = new JTextField(message); // Create a text field with message
        
        textField.setEditable(false); // Set textbox uneditable
        
        textField.setBorder(null); // Make it blend in by removing the border and background box
        textField.setBackground(null);

        return textField;
    }
}