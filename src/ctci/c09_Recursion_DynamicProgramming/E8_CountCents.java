/*

 */

package t09_Recursion_DynamicProgramming;

import java.util.LinkedList;
import org.junit.Test;

public class E8_CountCents {

	/*
	 Solution 1: my Solutions
	 */
	class CountWays {
		int c;
		LinkedList<String> paths = new LinkedList<>();
	}

	int getCountWays(int n) {
		CountWays c = new CountWays();
		runHelper(n, c, "");

		butil.Print.printList(c.paths, true);
		return c.c;
	}

	String normalize(String path) {
		String[] numbers = path.split(" ");
		java.util.Arrays.sort(numbers);
		String str = String.join(" ", numbers);
		return str;
	}

	void runHelper(int n, CountWays c, String path) {
		if (n == 0) {
			path = normalize(path);
			if (!c.paths.contains(path)) {
				c.c++;
				c.paths.add(path);
			}
		} else if (n > 0) {
			runHelper(n - 1, c, path + " 1");
			runHelper(n - 5, c, path + " 5");
			runHelper(n - 10, c, path + " 10");
			runHelper(n - 25, c, path + " 25");
		}
	}

	/*
	 this solution is from book:
	 TODO: I need to understand in more detail, page 330
	 It looks like the program in the book is much better.

	 This solution is far much better thank my solution.
	 */
	public int makeChange_bk(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
			case 25:
				next_denom = 10;
				break;
			case 10:
				next_denom = 5;
				break;
			case 5:
				next_denom = 1;
				break;
			case 1:
				return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange_bk(n - i * denom, next_denom);
		}
		return ways;
	}


	@Test
	public void test() {
		int totalSum = 21;
		getCountWays(totalSum);
		System.out.println("========book=======");
		System.out.println(makeChange_bk(totalSum, 25));
	}
}
