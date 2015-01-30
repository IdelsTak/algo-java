/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort_imp;

/**
 *
 * @author andy
 */
public class S5_Merge extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		sortHelper(a, 0, a.length - 1);
	}

	//inclusive
	private void sortHelper(int[] a, int l, int h) {
		if (l >= h) {
			return;
		}
		int m = (l + h) / 2;
		sortHelper(a, l, m);
		sortHelper(a, m + 1, h);
		//now that both part is orded, merge
		int[] aClone = a.clone();
		int l0 = l, l1 = l, l2 = m + 1;
		while (l1 <= m && l2 <= h) {
			if (aClone[l1] < aClone[l2]) {
				a[l0++] = aClone[l1++];
			} else {
				a[l0++] = aClone[l2++];
			}
		}
		while (l1 <= m) {
			a[l0++] = aClone[l1++];
		}
	}
}
