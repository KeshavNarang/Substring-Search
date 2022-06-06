import java.io.*;
import java.util.*;
public class Palindrome
{
	public static void main (String [] args) throws IOException
	{
		Scanner user = new Scanner (System.in);
		
		String input = "";
		String letters = "";
		
		long forwardHash = 0;
		long backwardHash = 0;
		
		System.out.print("Type a series of characters, pressing enter after each. ");
		System.out.println("Then, the program will let you know whether your current string is a palindrome or not.");
		System.out.println("Or, type QUIT to end the program.");
		System.out.println();
		
		while (true)
		{
			input = user.next();
			
			if (input.equalsIgnoreCase("QUIT"))
			{
				System.out.println("Thank you. Goodbye!");
				return;
			}
			
			letters += input;
			
			// The large prime I am using for my hash is 2029. No reason other than its the closest one more than 2022.
			
			// For the forward hash, multiply the current hash by 256. Then add the new character. Mod everything by 2029.
			forwardHash = ((forwardHash*256) + (long)input.charAt(0)) % 2029;
			
			// For the backwards hash, leave the current hash as it is. Add the new character times 256^(length-1). Mod it.
			backwardHash = (backwardHash + ((long)input.charAt(0) * (long)Math.pow(256, letters.length()-1))) % 2029;
			
			// If equal, check for collisions
			if (forwardHash == backwardHash)
			{
				boolean palindrome = true;
				
				for (int index = 0; index < letters.length()/2; index++)
				{
					int reverseIndex = letters.length() - index - 1;
					if (letters.charAt(index) != letters.charAt(reverseIndex))
					{
						palindrome = false;
						break;
					}
				}
				
				if (palindrome)
				{
					System.out.println("YES");
					continue;
				}
			}
			System.out.println("NO");
		}
	}
}