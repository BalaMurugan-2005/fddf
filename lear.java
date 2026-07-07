import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class DESExample{
  public static void main(String[] args) throws Exception {
     KeyGenerator keyGen  = KeyGenerator.getInstance("DES");
     SecretKey secretKey = keyGen.generateKey();
     String plainText = "Hello World";
     Cipher encryptCipher = Cipher.getInstance("DES");
     encryptCipher.init(Cipher.ENCRYPT_MODE ,secretKey);
     byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());
     String encryptedText= Base64.getEncoder().encodeToString(encryptedBytes);
     System.out.println("PlainText " + plainText);
     System.out.println("Encrypted" + encryptedText);
     
     // Decryption
     
     Cipher decryptCipher = Cipher.getInstance("DES");
     decryptCipher.init(Cipher.DECRYPT_MODE , secretKey);
     byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
     String decryptedText = new String(decryptedBytes);
     System.out.println("Decrypted Text : " + decryptedText);
  }
}
