import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
public class MACDemo {
     public static void main(String[] args){
          try{
              Scanner sc = new Scanner(System.in);
              System.out.println("Enter The Message: ");
              String message = sc.nextLine();
    	      String secretKey = "mysecretkey"; 
              Mac mac = Mac.getInstance("HmacSHA256");
              SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes() , "HmacSHA256");
              mac.init(keySpec);
              byte[] macBytes = mac.doFinal(message.getBytes());
              StringBuilder sb = new StringBuilder();
              for(byte b : macBytes) {
                  sb.append(String.format("%02x",b));
              }
	      System.out.println("Message Authentication Code (MAC) : " );
              System.out.println(sb.toString());
                       
          }
          catch (Exception e){
               System.out.println("Error."+e);
          }
     }
}
