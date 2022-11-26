package crackingcoding_chapter1;

public class Q2PermutationCheck {

	public boolean checkPermutation(String str1, String str2) {
		// 1) check length of both strings
		// 2) Sort both strings
		// 3) Compare the sorted strings

		int n1 = str1.length();
		int n2 = str2.length();

		// check length
		if (n1 != n2) {
			System.out.println("The strings are not permuations, different lengths");
			return false;
		} else {
			char charArr1[] = str1.toCharArray();
			char[] sortedCharArr1 = sortedChar(charArr1);

			char charArr2[] = str2.toCharArray();
			char[] sortedCharArr2 = sortedChar(charArr2);

			System.out.println("Sorted String1: ");
			for (int i = 0; i < sortedCharArr1.length; i++) {
				System.out.print(sortedCharArr1[i]);
			}

			System.out.println();
			System.out.println("Sorted String2: ");
			for (int i = 0; i < sortedCharArr2.length; i++) {
				System.out.print(sortedCharArr2[i]);
			}
			System.out.println();

			// check for permutation
			for (int i = 0; i < n1; i++) {
				if (charArr1[i] != charArr2[i]) {
					System.out.println("The words are not permuations of each other");
					return false;
				}

			}
			return true;
		}
	}

	public char[] sortedChar(char[] charArr) {
		char temp;
		for (int a = 0; a < charArr.length; a++) {
			for (int j = a + 1; j < charArr.length; j++) {
				if (charArr[a] > charArr[j]) {
					temp = charArr[a];
					charArr[a] = charArr[j];
					charArr[j] = temp;
				}
			}
		}

		return charArr;
	}

	public static void main(String[] args) {
		Q2PermutationCheck permCheck = new Q2PermutationCheck();
		boolean result = permCheck.checkPermutation("test", "ttse");
		if (result == true) {
			System.out.println("The words are permutations of each other!");
		} else {
			System.out.println("The words are NOT permuations of each other");
		}

	}
}
