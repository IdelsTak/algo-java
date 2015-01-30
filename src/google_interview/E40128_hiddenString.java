/*
Solutions for http://www.careercup.com/question?id=6666552321507328

Find all the combinations of a string in lowercase and uppercase. For example, string "ab" -> "ab", "Ab", "aB", "AB". So, you will have 2^n (n = number of chars in the string) output strings. 
The goal is for you to test each of these string and see if it match a hidden string.
 */

package google_interview;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class E40128_hiddenString {

public static void main(String args[]) {
		System.out.println(findSecret("abcdefghijklm"));
	}

	public static boolean isTheSecret(String input) {
		return input.equals("abCdeFGhiJklM");
	}

	public static String findSecret(String input) {
		Queue<String> queue = new ArrayBlockingQueue<String>((int)Math.pow(2, input.length()+1));
		queue.add("");

		while (true) {
			String lastText = queue.poll();
			if (isTheSecret(lastText))
				return lastText;
			if (input.length() == lastText.length())
				continue;
			String fork1 = lastText + Character.toUpperCase(input.charAt(lastText.length()));
			String fork2 = lastText + Character.toLowerCase(input.charAt(lastText.length()));
			queue.add(fork1);
			queue.add(fork2);
		}
	}
}
