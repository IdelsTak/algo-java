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
public class S4_Shell extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		int d = 1;
		int n = a.length;
		while (9 * d < n) {
			d = 3 * d + 1;
		}
		//hell sort
		while (d > 0) {

			for (int i = d; i < a.length; i++) {
				int j, v = a[i];
				for (j = i; j >= d && v < a[j - d]; j -= d) {
					a[j] = a[j - d];
				}//for j
				a[j] = v;
			}//for i

			d /= 3;
		}
	}

}
