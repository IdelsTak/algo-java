/*
Summary: the code from the book is much than my book
 */

package t09_Recursion_DynamicProgramming;

import java.util.LinkedList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E5_StringPerm {
	/*
	 Solution 1:
	 */
	LinkedList<String> run1(String base, int len) {
		LinkedList<String> list;
		if (len == 0) {
			list = new LinkedList<>();
			list.add(base.substring(len, len + 1));
			return list;
		} else {
			list = run1(base, len - 1);
			LinkedList<String> listNew = new LinkedList<>();
			char chNew = base.charAt(len);
			for (String str : list) {
				for (int i = 0; i <= str.length(); i++) {//clone
					StringBuilder sb = new StringBuilder(str);
					sb.insert(i, chNew);
					listNew.add(sb.toString());
				}
			}//for
			return listNew;
		}//if
	}

	/*
	 Solution 2: from book, this code is more tight
	 */
	LinkedList<String> run_bk(String base) {
		if (base == null) {
			return null;
		}
		LinkedList<String> perms = new LinkedList<>();
		if (base.length() == 0) {
			perms.add("");
			return perms;
		}

		char ch = base.charAt(0);
		LinkedList<String> partialPerms = run_bk(base.substring(1));

		for (String str : partialPerms) {
			for (int i = 0; i <= str.length(); i++) {
				String s = insertCharAt(str, ch, i);
				perms.add(s);
			}
		}
		return perms;
	}

	private String insertCharAt(String str, char ch, int i) {
		String start = str.substring(0, i);
		String end = str.substring(i);
		return start + ch + end;
	}

	@Test
	public void test() {
		/* my solution*/
		String str = "abcd";
		int expected = 4 * 3 * 2;
		LinkedList<String> list = run1(str, str.length() - 1);
		assertTrue("should equal" + Integer.toString(list.size()),
			expected == list.size());
		butil.Print.printList(list);
		/* book solution*/
		list = run_bk(str);
		assertTrue("should equal" + Integer.toString(list.size()),
			expected == list.size());
		butil.Print.printList(list);
	}
}
