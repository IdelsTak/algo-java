/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds_yanWeiMi;

import java.util.Stack;

/**
 *
 * @author andy
 */
public class B322_BrackMatching_P49 {
	public static void main(String[] arg) {
		System.out.println(isMatching("[{(d})"));
		System.out.println(isMatching("[{(d)}]"));
	}

	public static boolean isMatching(String expr) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			if ("[{(".indexOf(ch) >= 0) {
				stack.push(ch);
			} else if ("}])".indexOf(ch) >= 0) {
				if (stack.isEmpty()) {
					return false;
				}
				char ch1 = stack.pop();
				if (!isMatching(ch1, ch)) {
					return false;
				}
			}
		}//for
		return true;
	}

	public static boolean isMatching(char ch1, char ch2) {
		if (ch1 == '(' && ch2 == ')'
			|| ch1 == '{' && ch2 == '}'
			|| ch1 == '[' && ch2 == ']') {
			return true;
		}
		return false;
	}
}
