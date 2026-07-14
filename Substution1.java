import java.util.Scanner;

public class Substution{
   static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   static  String sub = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

   public static String encrypt(String plaintext){
       StringBuilder chipherText = new StringBuilder();
           for (char ch : plaintext.toUpperCase().toCharArray()) {
                 int index = alphabet.indexOf(ch);
                       if(index != -1){
                            chipherText.append(sub.charAt(index));
 			}
                       else{
 		           chipherText.append(ch);
                           }
                    }
                  return chipherText.toString();
            
     }
  public static String decrypt(String chipherText){
      StringBuilder plainText = new StringBuilder();
          for(char ch : chipherText.toUpperCase().toCharArray()){
                int index = sub.indexOf(ch);
                     if(index !=-1){
                         plainText.append(alphabet.charAt(index));
                      }
                     else{
                       plainText.append(ch);
                     }
          }
              return plainText.toString();
           
      }
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter The plain Text:");
    String plainText = sc.nextLine();
    String encrypted = encrypt(plainText);
    System.out.println("Encrypted Text:"+ encrypted);
    String decrypted = decrypt(encrypted);
    System.out.println("Decrypted Text :" + decrypted);
    sc.close();
 }
}
