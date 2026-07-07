import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESExample{
  public static void main(String[] args) throws Exception {
     KeyGenerator keyGen  = KeyGenerator.getInstance("AES");
     keyGen.init(128);
     SecretKey secretKey = keyGen.generateKey();
     String plainText = "Bala Murugan P";

     Cipher cipher = Cipher.getInstance("AES");
     cipher.init(Cipher.ENCRYPT_MODE ,secretKey);

     byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
     String encryptedText= Base64.getEncoder().encodeToString(encryptedBytes);

     System.out.println("PlainText " + plainText);
     System.out.println("Encrypted" + encryptedText);
     
     // Decryption
     
    
     cipher.init(Cipher.DECRYPT_MODE , secretKey);
     byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
     String decryptedText = new String(decryptedBytes);
     System.out.println("Decrypted Text : " + decryptedText);
  }
}
