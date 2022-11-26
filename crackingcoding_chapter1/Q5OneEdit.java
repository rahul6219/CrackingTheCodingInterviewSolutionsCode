package crackingcoding_chapter1;

import java.util.Scanner;

/**
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE p a l e , pie -> true p a l e s , pale -> true p a l e , bale -> true
 * p a l e , bake -> false
 **/

public class Q5OneEdit {

	public static boolean oneEditAway(String word1, String word2) {
		if (word1.length() == word2.length()) {
			return oneEditReplace(word1, word2);
		} else if (word1.length() + 1 == word2.length()) {
			return oneEditInsert(word1, word2);
		} else if (word1.length() - 1 == word2.length()) {
			return oneEditInsert(word1, word2);
		}

		return false;
	}

	public static boolean oneEditReplace(String s1, String s2) {

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String word = sc.next();
		System.out.println("Enter a word");
		String changedWord = sc.next();
		sc.close();

	}
}