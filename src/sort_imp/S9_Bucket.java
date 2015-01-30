/*this algorithm is quite easy, as long as you understand the problem
 */

package sort_imp;

/**
 *
 * @author andy
 */
public class S9_Bucket extends S0_SortCommon {

	class Bucket extends java.util.ArrayList<Integer> {

		void sort() {
			java.util.Arrays.sort(this.toArray());
		}
	}

	@Override
	void sort(int[] a) {
		int min = min(a);
		int max = max(a);
		int n = a.length;
		Bucket[] bucket = new Bucket[n];
		for (int d : a) {
			int nBucket = (d - min) / (max - min - 1);
			bucket[nBucket].add(d);
		}
		int i = 0;
		for (int j = 0; j < n; j++) {
			bucket[j].sort();
			for (int tmp : bucket[j]) {
				a[i++] = tmp;
			}
		}
	}

	int min(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int d : a) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

	int max(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int d : a) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}

}
