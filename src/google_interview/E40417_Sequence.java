/*
Solutions to http://www.careercup.com/question?id=4669539153346560
 The input is a sequence x1,x2,...,xn of integers in an arbitrary order, and another sequence
 a1,a2,..,an of distinct integers from 1 to n (namely a1,a2,...,an is a permutation of
 1, 2,..., n).

 Both sequences are given as arrays. Design an 0(n logn) algorithm to order
 the first sequence according to the order imposed by the permutation.

 In other words, for each i, Xi should appear in the position given in ai.

 For example, if x = 17, 5, 1,9, and a = 3, 2, 4, 1,
 then the outcome should be x = 9, 5, 17, 1.

 The algorithm should be in-place, so you cannot use an additional array.
 */

package google_interview;

/**
 *
 * @author andy
 */
public class E40417_Sequence {

	public static void main(String[] argc) {
		int[] ai = butil.SortUtil.getArray(20);
		int[] am = butil.SortUtil.getArray(30);
		System.out.println("Before Sort");
		System.out.println(java.util.Arrays.toString(ai));
		System.out.println(java.util.Arrays.toString(am));
		sort(ai, am);
		System.out.println("After Sort");
		System.out.println(java.util.Arrays.toString(ai));
		System.out.println(java.util.Arrays.toString(am));
	}

	public static void sort(int[] ai, int[] am) {
		orgHeap(ai, am);
		sortHeap(ai, am);
	}//method

	private static void orgHeap(int[] ai, int[] am) {
		int N = ai.length;
		for (int i = N / 2; i < N - 1; i++) {
			for (int j = i, parent = (j - 1) / 2; j > 0; j = parent, parent = (j - 1) / 2) {
				if (ai[j] > ai[parent]) {
					butil.SortUtil.swap(ai, j, parent);
					butil.SortUtil.swap(am, j, parent);
				}//if
			}//for
		}//for
	}//method

	private static void sortHeap(int[] ai, int[] am) {
		int N = ai.length;
		for (int i = N - 1; i > 0; i--) {
			butil.SortUtil.swap(ai, i, 0);
			butil.SortUtil.swap(am, i, 0);
			adjustHeap(ai, am, i);
		}//for
	}//method

	private static void adjustHeap(int[] ai, int[] am, int N) {
		int i = 0;
		while (2 * i + 1 < N) {
			int lChild = 2 * i + 1;
			int childIdx = (lChild + 1 < N && ai[lChild + 1] > ai[lChild]) ? lChild + 1 : lChild;
			if (ai[childIdx] > ai[i]) {
				butil.SortUtil.swap(ai, i, childIdx);
				butil.SortUtil.swap(am, i, childIdx);
			}
			i = childIdx;
		}//while
	}//method
}//class
