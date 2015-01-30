/*

 */
package ds_yanWeiMi;

import java.util.ArrayList;

/**
 *
 * @author andy
 */
public class Permutations {

	public static void main(String[] arg) {
		String str = "123";
		Sol_1_Str.perm("", str);
		//
		System.out.println("Solution 2");
		char[] a = str.toCharArray();
		ArrayList<Character> list = new ArrayList<>();
		for (char c : a) {
			list.add(c);
		}

		char[] perm = new char[a.length];
		Sol_2_Array.perm(list, perm, 0);

	}

	public static class Sol_1_Str {	// <editor-fold defaultstate="collapsed" desc="Generated Code">
		private static String removeAt(String str, int i) {
			String first = str.substring(0, i);
			String second = str.substring(i + 1);
			return first + second;
		}//removeAt

		public static void perm(String pre, String str) {
			if (str.length() == 1) {
				System.out.println(pre + str);
			} else {
				for (int i = 0; i < str.length(); i++) {
					String newPre = pre + str.charAt(i);
					String newStr = removeAt(str, i);
					perm(newPre, newStr);
				} //for
			}//if
		}//per
	}// </editor-fold>

	public static class Sol_2_Array {
		public static void perm(ArrayList<Character> list, char[] perm, int n) {
			if (list == null || list.isEmpty()) {
				System.out.println(String.valueOf(perm));
			} else {
				int len = list.size();
				for (int i = 0; i < len; i++) {
					ArrayList<Character> newList = (ArrayList<Character>) list.clone();
					perm[n] = newList.get(i);
					newList.remove(i);
					perm(newList, perm, n + 1);
				}//for
			}//if
		}//perm
	}//class
}
