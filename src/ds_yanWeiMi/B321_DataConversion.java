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
public class B321_DataConversion {

	public static void main(String[] arg) {
		String r1 = run(1348); //2504
		System.out.println(r1);
	}

	public static String run(int n) {
		int t = n;
		Stack<String> stack = new Stack<>();
		while (n > 0) {
			String str = String.valueOf(n % 8);
			stack.push(str);
			n /= 8;
		}
		String result = "";
		while (!stack.empty()) {
			result += stack.pop();
		}
		return result;
	}
}
