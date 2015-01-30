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
public class S3_Insert extends S0_SortCommon {
	@Override
	public void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j, v = a[i];
			for (j = i; j > 0 && v < a[j - 1]; j--) {
				a[j] = a[j - 1];
			}//for j
			a[j] = v;
		}//for i
	}
}
