package crackingcoding_chapter1;

public class Q3ReplaceSpacesInString {

	/**
	 * URLify: Write a method to replace all spaces in a string with '%20'. You may
	 * assume that the string has sufficient space at the end to hold the additional
	 * characters, and that you are given the "true" length of the string. (Note: If
	 * implementing in Java, please use a character array so that you can perform
	 * this operation in place.) EXAMPLE Input: "Mr 3ohn Smith 13 Output:
	 * "Mr%203ohn%20Smith"
	 **/

	public void replaceStrings(String str, int realLength) {
		char[] stringCharArray = str.toCharArray();

		// count the total number of spaces
		int spaceCount = 0;

		for (int a = 0; a < stringCharArray.length; a++) {
			if (stringCharArray[a] == ' ') {
				spaceCount++;
			}
		}

		int newLength = (2 * spaceCount) + stringCharArray.length;
		char[] charsNew = new char[newLength];
		for (int i = stringCharArray.length - 1; i >= 0; i--) {

			if (stringCharArray[i] == ' ')// If you encounter the space, for next 3 spaces put %,2,0.
			{
				charsNew[newLength - 1] = '0';
				charsNew[newLength - 2] = '1';
				charsNew[newLength - 3] = '2';
				newLength = newLength - 3;
			} else // else copy it
			{
				charsNew[newLength - 1] = stringCharArray[i];
				newLength = newLength - 1;
			}
		}

		System.out.println("Output String : " + String.valueOf(charsNew));

	}

	public static void main(String[] args) {

		String s1 = " I am Rahul Thakur  ";
		String s2 = s1.trim();

		int realLength = s2.length();
		System.out.println("Input String: " + s1);
		Q3ReplaceSpacesInString r = new Q3ReplaceSpacesInString();
		r.replaceStrings(s1, realLength);
	}
}
