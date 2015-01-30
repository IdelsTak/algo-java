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
public class S6_Quick extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		sortH(a, 0, a.length - 1);
	}

	static int steps = 0;

	//return the index of pivot, p
	void sortH(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}

		System.out.print("" + (steps++) + "  " + java.util.Arrays.toString(a));

		int L = low, h = high, p = low;
		boolean highOper = true;//direction
		while (L < h) {
			if (highOper) {//h move down
				while (a[h] >= a[p] && h != p) {
					h--;
				}
				if (h == p) {
					break;
				} else {
					butil.SortUtil.swap(a, h, p);
					L = p + 1;
					p = h;
				}
			} else {
				while (a[L] < a[p]) {
					L++;
				}
				butil.SortUtil.swap(a, L, p);
				h = p - 1;
				p = L;
			}
			highOper = !highOper;
		}
		System.out.printf("	l = %s, h = %d, p = %d\n", low, high, p);
		sortH(a, low, p - 1);
		sortH(a, p + 1, high);
	}

}
