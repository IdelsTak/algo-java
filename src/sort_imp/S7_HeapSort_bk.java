/*
 */

package sort_imp;

public class S7_HeapSort_bk extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(a, i, n);
		}
		for (int i = n - 1; i > 0; i--) {
			butil.SortUtil.swap(a, 0, i);
			heapify(a, 0, i);
		}
	}

	//j is the last location
	private void heapify(int[] a, int i, int j) {
		int ai = a[i];
		while (2 * i + 1 < j) {
			int k = 2 * i + 1;//paent
			if (k + 1 < j && a[k + 1] > a[k]) {//if k+1 exist && a[k+1] is larger
				++k;//a[k] is the larger one
			}
			if (ai >= a[k]) {
				break;
			}
			a[i] = a[k];
			i = k;
		}
		a[i] = ai;
	}
}
