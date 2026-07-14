import java.math.BigInteger;
import java.util.Scanner;
public class RSA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//Step 1: Choose Prime number
		
		System.out.print("Enter Prime Number p:");
		BigInteger p = sc.nextBigInteger();
		
		System.out.print("Enter Prime Number q: ");
		BigInteger q = sc.nextBigInteger();

//Step 2: Calculate n= p *q
		
		BigInteger n = p.multiply(q);

//Step 3: Calculate pie(n) = (p-1)(q-1)
		
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

//Step 4: Choose public key e

		BigInteger e = BigInteger.valueOf(65537);

//Step 5: Calculate private key

		BigInteger d = e.modInverse(phi);
		System.out.println("\nPublic Key (e, n) = (" + e + ", " + n + ")");
		System.out.println("Private Key (d, n) = (" + d + ", " + n + ")");

//Step 6: Enter message
		System.out.print("\nEnter Message (number): ");
		BigInteger message = sc.nextBigInteger();


//Encryption c = M^e mod n
	
		BigInteger cipher = message.modPow(e, n);
		System.out.println("Encrypted Message: " + cipher);

//Decryption c= M^d mod n

		BigInteger decrypted = cipher.modPow(d, n);
		System.out.println("Decrypted Message: " + decrypted);
		sc.close();

	}
}
