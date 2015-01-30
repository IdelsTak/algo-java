/*
This code is much much better than my code
 */

package sort_imp;

/**
 *
 * @author andy
 */
public class S6_Quick_bk extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	void sort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}
		int m = partition(a, low, high);
		sort(a, low, m - 1);
		sort(a, m + 1, high);
	}

	int partition(int[] a, int L, int h) {
		int pivot = a[L];
		while (L < h) {
			while (L < h && a[h] >= pivot) {
				h--;
			}
			if (L < h) {
				a[L++] = a[h];
			}
			//up
			while (L < h && a[L] <= pivot) {
				L++;
			}
			if (L < h) {
				a[h] = a[L];
			}
		}
		a[h] = pivot;
		return h;
	}

}
