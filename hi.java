import java.util.*;
import java.io.*;
public class TranspositionChipher{
  //encryptyion
  public static String encrypt(String text  , int key){
     text = text.replaceAll("\\s" , "");
     int rows = (int) Math.ceil((double) text.length() / key);
     char[][] matrix = new char[rows][key];
     int k =0;
     for(int i=0; i<rows; i++){
        for(int j=0; j<key; j++){
           if(k< text.length())
             matrix[i][j] = text.charAt(k++); 
           else
             matrix[i][j] = 'X';     
        }
     }
   StringBuilder chipher = new StringBuilder();
   for(int j=0; j<key; j++){  
      for(int i=0; i<rows; i++){ 
         chipher.append(matrix[i][j]);
       }
   }
   return chipher.toString();
 }
public static String decrypt(String chipher , int key){
   int rows = chipher.length() / key;
   char[][] matrix = new char[rows][key];
   int k=0;
   for(int j=0; j<key; j++){
      for(int i=0; i<rows; i++){
         matrix[i][j] = chipher.charAt(k++);
      }
   }
 StringBuilder plain = new StringBuilder();
 for(int i=0; i<rows; i++){
    for(int j=0; j<key; j++){
       plain.append(matrix[i][j]);
    }
 }
return plain.toString().replace("X" , "");
}
public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter The Plain Text : ");
   String text = sc.nextLine();
   System.out.println("Enter The Key(Number of columns) : ");
   int key = sc.nextInt();
   String chipher = encrypt(text , key);
   System.out.println("Encrypted text : " + chipher);
   String decrypted = decrypt(chipher , key);
   System.out.println("Decrypted text : " + decrypted);
 }
}
