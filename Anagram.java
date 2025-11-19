import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		if (str1 == null || str2 == null) {
			return false;
		}
		String newString1 = str1.toLowerCase();
		String newString2 = str2.toLowerCase();

		if (newString1.length() != newString2.length()) {
			return false;
		}

		if(newString1.length() == 0) {
			return true;
		}

		for (int i = 0; i < newString1.length(); i++) {

			char currentChar = newString1.charAt(i);
			boolean found = false;

			for (int j = 0; j < newString2.length(); j ++) {

				if(currentChar == newString2.charAt(j)) {

					String partBefore = newString2.substring(0, j);
					String partAfter = newString2.substring(j + 1);

					newString2 = partBefore + partAfter;

					found = true;

					break;

				}

			}

			if(!found) {
				return false;
			} 

			
		}
		return newString2.length() == 0;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		char currentChar;
		String newStr = "";
		for (int i = 0; i < str.length(); i ++) {

			currentChar = str.charAt(i);
			if (Character.isUpperCase(currentChar)) {

				currentChar = Character.toLowerCase(currentChar);
				newStr = newStr + currentChar;

			} else if (Character.isLowerCase(currentChar)) {

				newStr = newStr + currentChar;

			}

		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

		String anagram = "";
		double rnd = Math.random();
		int position = (int)(rnd * str.length());
		char currentChar = str.charAt(position);
		
		for (int i = 0; i < str.length() + 1; i ++) {

			String first = str.substring(0, position);
			String second = str.substring(position + 1, str.length());

			anagram = currentChar + first + second;

		}

		rnd = Math.random();
	    position = (int)(rnd * str.length());
	    currentChar = str.charAt(position);

		
		return anagram;
	}
}
