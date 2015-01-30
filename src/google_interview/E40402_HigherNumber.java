/*
Solutions to http://www.careercup.com/question?id=4869907900530688
 Example 1 : if num = 25468, o/p = 25486
 Example 2 : if num = 21765, o/p = 25167
 Example 3 : If num = 54321, o/p = 54321 (cause it's not possible to gen a higher num than tiz with given digits ).
 */
package google_interview;

import butil.SortUtil;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author andy
 */
public class E40402_HigherNumber {

	public static void main(String[] argv) {
		long[] a = {25468, 21765, 54321};
		System.out.println("Sol_1 --------------------");
		for (long i : a) {
			long r = Sol_1_my_asDigit.next(i);
			System.out.printf("%d %d\n", i, r);
		}

		System.out.println("Sol_2 --------------------");
		for (long i : a) {
			long r = Sol_2_my_asString.next(i);
			System.out.printf("%d %d\n", i, r);
		}

		System.out.println("Sol_3 --------------------");
		long r1 = Sol_3_my_improvedOn_2.next(21765);
		for (long i : a) {
			long r = Sol_3_my_improvedOn_2.next(i);
			System.out.printf("%d %d\n", i, r);
		}

		System.out.println("Sol_4 --------------------");
		for (long i : a) {
			long r = Sol_4_basedOnWeb_Heavy_use_of_collection_codeIsClear.next(i);
			System.out.printf("%d %d\n", i, r);
		}
	}

	//disorganize to string O(N*N)
	public static class Sol_1_my_asDigit {// <editor-fold defaultstate="collapsed" desc="Hidden Code">

		public static long next(long num) {
			int[] a = getArray(num);
			boolean isNext = nextNumber(a);
			if (isNext) {
				return getNumber(a);
			}
			return num;
		}

		public static boolean nextNumber(int[] a) {
			for (int i = a.length - 2; i >= 0; i--) {
				//find minLarger
				int iMinLarger = i;
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] > a[i]) {
						if (i == iMinLarger) {
							iMinLarger = j;
						} else {
							iMinLarger = (a[iMinLarger] < a[j]) ? iMinLarger : j;
						}
					}
				}//for
				if (iMinLarger != i) {
					SortUtil.swap(a, i, iMinLarger);
					sort(a, i + 1, a.length - 1);
					return true;
				}//if
			}//for
			return false;
		}

		public static void sort(int[] a, int start, int end) {
			for (int i = start; i <= end - 1; i++) {
				int k = i;
				for (int j = i + 1; j <= end; j++) {
					if (a[j] < a[k]) {
						k = j;
					}
				}
				SortUtil.swap(a, i, k);
			}
		}

		private static long getNumber(int[] a) {
			long num = 0;
			for (int i = 0; i < a.length; i++) {
				num = num * 10 + a[i];
			}
			return num;
		}

		private static int[] getArray(long num) {
			int len = (int) (Math.log10(num) + 1);
			int[] a = new int[len];
			long n = num;
			int i = 0;
			while (n > 0) {
				a[len - 1 - (i++)] = (int) (n % 10);
				n /= 10;
			}
			return a;
		}
	}// </editor-fold>

	//disorganize to chars O(N*N)
	public static class Sol_2_my_asString {

		// <editor-fold defaultstate="collapsed" desc="Hidden Code">
		static long next(long n) {
			char[] cs = Long.toString(n).toCharArray();
			nextNumber(cs);
			String str = String.copyValueOf(cs);
			return Long.parseLong(str);
		}

		//find the relative min digit that is larger than the prev digit
		private static void nextNumber(char[] cs) {
			for (int i = cs.length - 2; i >= 0; i--) {
				//find the min value larger than cs[i], but
				int relativeMinIdx = i;
				for (int j = i + 1; j < cs.length; j++) {
					if (cs[j] > cs[i]) {//swap
						if (relativeMinIdx == i) {
							relativeMinIdx = j;
						} else {//both larger than i, get the smaller one
							relativeMinIdx = (cs[relativeMinIdx] < cs[j]) ? relativeMinIdx : j;
						}
					}//if
				}//if
				if (relativeMinIdx != i) {
					SortUtil.swap(cs, i, relativeMinIdx);
					sort(cs, i + 1, cs.length - 1);
					return;
				}
			}//for
		}//public

		private static void sort(char[] cs, int start, int end) {
			for (int i = start; i < end; i++) {
				int k = i;
				for (int j = i + 1; j <= end; j++) {
					if (cs[j] < cs[k]) {
						k = j;
					}
				}
				SortUtil.swap(cs, i, k);
			}
		}
		// </editor-fold>
	}

	//huge improve based previous solution, complicity O(N)
	//this is my best solution
	public static class Sol_3_my_improvedOn_2 {

		public static long next(long n) {
			char[] a = String.valueOf(n).toCharArray();
			int len = a.length, idx;
			//find first index not increase from right
			for (idx = len - 2; idx >= 0 && a[idx] > a[idx + 1]; idx--) {
			}
			if (idx < 0) {
				return n;
			}
			//find min value larger than @digit idx, the right part alrady increase mode, find the first one
			int minLarger;
			for (minLarger = len - 1; minLarger > idx && !(a[minLarger] > a[idx]); minLarger--) {
			}
			//swap
			SortUtil.swap(a, idx, minLarger);
			//sort elemnts from idx+1 ~ len-1, first increase from right, then reverse order
			for (int k = minLarger; k < len - 1 && a[k] < a[k + 1]; k++) {
				SortUtil.swap(a, k, k + 1);
			}
			for (int k = minLarger; k > idx && a[k - 1] < a[k]; k--) {
				SortUtil.swap(a, k, k - 1);
			}
			//reverse order from idx+1 ~ len-1
			for (int low = idx + 1, high = len - 1; high > low; low++, high--) {
				SortUtil.swap(a, low, high);
			}
			long result = Long.valueOf(String.valueOf(a));
			return result;
		}
	}

	//this is different approach, low efficient
	public static class Sol_4_basedOnWeb_Heavy_use_of_collection_codeIsClear {

		// <editor-fold defaultstate="collapsed" desc="Hidden Code">
		public static long next(long n) {
			ArrayList<Long> list = new ArrayList<>();
			String data = String.valueOf(n);
			createPermutations("", data, list);
			Collections.sort(list);
			int index = list.indexOf(n);
			if (index + 1 < list.size()) {
				return list.get(index + 1);
			} else {
				return n;
			}
		}

		public static void createPermutations(String pre, String str, ArrayList<Long> list) {
			if (str.length() == 0) {
				list.add(Long.valueOf(pre));
			}
			for (int i = 0; i < str.length(); i++) {
				createPermutations(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1), list);
			}
		}
	}//Sol_3_basedOnWeb

}
