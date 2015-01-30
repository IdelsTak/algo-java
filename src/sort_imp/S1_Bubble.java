/*
	worst cast O(N2), best n
 */

package sort_imp;

/**
 *
 * @author andy
 */
public class S1_Bubble extends S0_SortCommon {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		for (int i = n - 1; i > 0; i--) {
			boolean bubbled = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					butil.SortUtil.swap(a, j, j + 1);
					bubbled = true;
				}
			}//for j
			if (!bubbled) {
				return;
			}
		}//for i
	}//sort

}
