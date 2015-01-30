/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t09_Recursion_DynamicProgramming;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class EB_Bool {

	static class Unit {

		//leaf node
		boolean data;//value of the whole tree
		//tree node
		boolean isOper;		//char data;//store operator or data
		char oper;
		Unit d1, d2;

		public Unit(char ch) {
			if ("|&^".indexOf(ch) >= 0) {
				isOper = true;
				oper = ch;
			} else {
				isOper = false;
				this.data = ('1' == ch);
				d1 = null;
				d2 = null;
			}
		}

		public Unit(Unit d1, Unit oper, Unit d2) {
			this.d1 = d1;
			this.d2 = d2;
			this.isOper = true;
			this.data = calc(d1, oper, d2);//update d1 according to sub value
			this.oper = oper.oper;
		}

		//before call this, should be 3 elements
		public static boolean calc(ArrayList<Unit> list) {
			return calc(list.get(0), list.get(1), list.get(2));
		}

		public static boolean calc(Unit d1, Unit oper, Unit d2) {
			boolean result = true;
			switch (oper.oper) {
				case '|':
					result = d1.data | d2.data;
					break;
				case '&':
					result = d1.data & d2.data;
					break;
				case '^':
					result = d1.data ^ d2.data;
					break;
			}
			return result;
		}

		@Override
		public String toString() {
			String s;
			if (isOper) {//if this is oper, then there are two sub trees
				if (d1 == null || d2 == null) {
					s = "" + oper;
				} else {
					s = String.format("(%s%s%s)", d1, oper, d2);
				}
			} else {
				s = data ? "1" : "0";
			}
			return s;
		}
	}

	void getComb(ArrayList<Unit> list, boolean expected, ArrayList<String> result) {
		if (list == null) {
			return;
		}
		int len = list.size();
		if (len < 3) {
			System.out.println("Invalid");
		} else if (len == 3) {
			if (Unit.calc(list) == expected) {
				String s = "" + list.get(0) + list.get(1) + list.get(2);
				result.add(s);
			}
		} else {
			for (int i = 1; i < list.size(); i += 2) {
				ArrayList<Unit> newList = combineList(list, i);
				getComb(newList, expected, result);
			}
		}
	}

	ArrayList<Unit> combineList(ArrayList<Unit> list, int i) {
		ArrayList<Unit> newList = new ArrayList<>();
		for (int j = 0; j < i - 1; j++) {
			newList.add(list.get(j));
		}
		newList.add(new Unit(list.get(i - 1), list.get(i), list.get(i + 1)));
		for (int j = i + 2; j < list.size(); j++) {
			newList.add(list.get(j));
		}
		return newList;
	}

	@Test
	public void test() {
		char expr[] = "1^0|0|1".toCharArray();
		ArrayList<Unit> list = new ArrayList<>();
		for (char ch : expr) {
			list.add(new Unit(ch));
		}
		ArrayList<String> result = new ArrayList<>();
		getComb(list, false, result);
		butil.Print.printList(result, true);
	}
}
