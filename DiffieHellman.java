import java.util.Scanner;
public class DiffieHellman {
	
//Function to calcuate (base^exp) % mod
 
	public static long power(long base, long exp, long mod) {
		long result = 1;
		while (exp > 0) {
			result = (result * base) % mod;
			exp--;
		}
		return result;	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Prime Number (p): ");
		long p = sc.nextLong();
		System.out.print("Enter Primitive root (g): ");
		long g = sc.nextLong();

		System.out.print("Enter the private key of Alice: ");
		long a = sc.nextLong();
		System.out.print("Enter the private key of Bob: ");
		long b = sc.nextLong();


//public keys

		long A = power(g, a, p);
		long B = power(g, b, p);

		System.out.println("\nAlice Public Key = " + A);
		System.out.println("Bob Public Key = " + B);

//Shared secret keys

		long keyAlice = power(B, a, p);
		long keyBob = power(A, b, p);

		System.out.println("\nSecret Key Computed by Alice = " + keyAlice);
		System.out.println("Secret Key Computed by Bob = " + keyBob);
		sc.close();
	}
}
