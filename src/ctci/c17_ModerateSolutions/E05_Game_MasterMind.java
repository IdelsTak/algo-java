/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

/**
 *
 * @author andy
 */
public class E05_Game_MasterMind {

	public static class Answer {

		int hit = 0;
		int pseudo = 0;

		@Override
		public String toString() {
			String str = String.format("hit = %d, pse = %d", hit, pseudo);
			System.out.println(str);
			return str;
		}
	}

	static int code(char c) {
		switch (c) {
			case 'B':
				return 0;
			case 'G':
				return 1;
			case 'R':
				return 2;
			case 'Y':
				return 3;
			default:
				return -1;
		}
	}

	public static int MAX_COLOR = 4;
	static Answer guess(String guess, String solution) {
		if (guess.length() != solution.length()) {
			return null;
		}
		Answer a = new Answer();
		int[] frequency = new int[MAX_COLOR];
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				a.hit++;
			} else {
				frequency[code(solution.charAt(i))]++;
			}
		}
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && frequency[code] > 0
				&& guess.charAt(i) != solution.charAt(i)) {
				frequency[code]--;
				a.pseudo++;
			}
		}
		System.out.printf("gu = %s, so = %s,  answer = %s\n", guess, solution, a);
		return a;
	}

	public static void main(String[] argv) {
		guess("RGBY", "GGRR");
	}

}
