package crackingcoding_chapter1;

public class Q1UniqueCharacters {

	public boolean checkUniqueCharacters(String word) {
		int size = word.length();
		word = word.toLowerCase();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (word.charAt(i) == word.charAt(j)) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Q1UniqueCharacters uC = new Q1UniqueCharacters();
		String word = "ABCDEE";
		boolean result = uC.checkUniqueCharacters(word);

		if (result == true) {
			System.out.println("The word: " + word + " :: has " + "All Unique letters");

		} else {
			System.out.println("The word: " + word + " :: does not have " + "All Unique letters");

		}
	}

}
