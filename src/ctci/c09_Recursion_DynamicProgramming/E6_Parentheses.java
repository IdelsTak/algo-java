/*
 */

package t09_Recursion_DynamicProgramming;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.LinkedList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class E6_Parentheses {
	/*
	 Solution 1: My solution, similar with solution 1 in the book
	 */
	HashSet<String> getSet(int n) {
		if (n <= 0) {
			return null;
		}

		HashSet<String> set = new HashSet<String>();

		if (n == 1) {
			set.add("()");
		}

		HashSet<String> subSet = getSet(n - 1);
		if (null != subSet) {
			for (String str : subSet) {
				int len = str.length();
				for (int i = 0; i <= len; i++) {
					String s = insertStr(str, i);
					if (!set.contains(s)) {
						set.add(s);
					}
				}
			}
		}//if
		return set;
	}//function

	private String insertStr(String str, int i) {
		String start = str.substring(0, i);
		String end = str.substring(i);
		return start + "()" + end;
	}

	/*
	 Solution 2: Solution from book, still have difficulty to catch up.
	 Basic:
	 1. leftRemain > 0
	 2. rightRemain > leftRemain
	 TODO: Even after I read the code once, I still could not write the code correctly.
	 */
	void getSetHelper(LinkedList<String> set, char[] cache, int leftRemain, int rightRemain, int count) {
		if (leftRemain == 0 && rightRemain == 0) {
			String str = String.copyValueOf(cache);
			set.add(str);
			return;
		}
		if (leftRemain > 0) {
			cache[count] = '(';
			getSetHelper(set, cache, leftRemain - 1, rightRemain, count + 1);
			//count++;  getSetHelper(set, cache, leftRemain - 1, rightRemain, count);
		}
		if (rightRemain > leftRemain) {
			cache[count] = ')';
			getSetHelper(set, cache, leftRemain, rightRemain - 1, count + 1);
			//count++;  getSetHelper(set, cache, leftRemain, rightRemain - 1, count);
		}
	}

	LinkedList<String> getSet_bk(int n) {
		LinkedList<String> set = new LinkedList<>();
		char[] cache = new char[2 * n];
		getSetHelper(set, cache, n, n, 0);
		return set;
	}

	/*
	 Test
	 */
	@Test
	public void test() {
		AbstractCollection<String> set;
		int size;
		/*Solution 1:*/
		set = getSet(3);
		size = set.size();
		assertTrue("length should be 5", set.size() == 5);
		/*Solution 2:*/
		set = getSet_bk(3);
		size = set.size();
		assertTrue("length should be 5", set.size() == 5);
		butil.Print.printList(set, true);

	}

}
