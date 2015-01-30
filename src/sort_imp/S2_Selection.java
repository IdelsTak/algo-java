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
public class S2_Selection extends S0_SortCommon {

	@Override
	public void sort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			int m = 0;
			for (int j = 1; j <= i; j++) {
				if (a[j] > a[m]) {
					m = j;
				}
			}//for j
			butil.SortUtil.swap(a, i, m);
		}
	}
}
