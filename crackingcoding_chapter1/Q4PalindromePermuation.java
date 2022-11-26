package crackingcoding_chapter1;

public class Q4PalindromePermuation {

	// check if it is a palindrome
	// then check if it is a permutation

	public boolean isPermuation(String word, String word2) {

		if (word.length() != word2.length()) {
			System.out.println("Lengths of the words are different, not a permuation");
			return false;
		} else {

			char[] wordChars = word.toCharArray();
			char temp;
			for (int x = 0; x < wordChars.length; x++) {
				for (int z = x + 1; z < wordChars.length; z++) {
					if (wordChars[x] > wordChars[z]) {
						// then swap
						temp = wordChars[x];
						wordChars[x] = wordChars[z];
						wordChars[z] = temp;
					}
				}
			}

			System.out.println(wordChars);

			char[] word2Array = word2.toCharArray();
			char temp1;
			for (int x = 0; x < word2Array.length; x++) {
				for (int z = x + 1; z < word2Array.length; z++) {
					if (word2Array[x] > word2Array[z]) {
						// then swap
						temp1 = wordChars[x];
						word2Array[x] = word2Array[z];
						word2Array[z] = temp1;
					}
				}
			}

			String str1 = String.valueOf(wordChars);
			String str2 = String.valueOf(word2Array);

			if (str1.equals(str2)) {
				return true;
			} else {
				return false;
			}

		}

	}

	public boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;

	}

	public static void main(String[] args) {
		String first = "Tact Coa";
		String second = "taco cat";

		first = first.toLowerCase();
		second = second.toLowerCase();

		Q4PalindromePermuation pP = new Q4PalindromePermuation();
		if (pP.isPalindrome(first) && pP.isPalindrome(second) && pP.isPermuation(first, second)) {
			System.out.println("The words are palindromes and permuations");
		} else {
			System.out.println("NOT a palindrome or permuation");
		}

	}
}
