import java.util.*;

public class TokenAuthentication {
     public static void main(String[] args){
           Scanner sc = new Scanner(System.in);
           String token = UUID.randomUUID().toString();
           System.out.println("Generated Token:");
           System.out.println(token);
           System.out.println("Enter the User Token");
           String userToken = sc.nextLine();
           if(token.equals(userToken)){
              System.out.println("It was Verified");
           }
           else{
              System.out.println("It was not Verified");
           }
   }
}
