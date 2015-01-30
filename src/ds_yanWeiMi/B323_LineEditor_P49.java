/*
 */

package ds_yanWeiMi;

import java.util.LinkedList;

/**
 *
 * @author andy
 */
public class B323_LineEditor_P49 {
	public static void main(String[] argc) {
		String s = "whi##hilr#e(s#*s)\noutcha@putchar(*s=#++);";
		String o = getOutput(s);
		System.out.println(o);
	}

	public static String getOutput(String s) {
		LinkedList<Character> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '\n') {
				sb.append(getString(list));
				sb.append('\n');
			} else if (ch == '@') {
				list.clear();
			} else if (ch == '#') {
				list.removeLast();
			} else {
				list.addLast(ch);
			}
		}//for
		sb.append(getString(list));
		return sb.toString();
	}

	private static String getString(LinkedList<Character> list) {
		StringBuilder sb = new StringBuilder();
		while (!list.isEmpty()) {
			sb.append(list.removeFirst());
		}
		return sb.toString();
	}
}
