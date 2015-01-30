/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort_imp;

import org.junit.Test;

/**
 *
 * @author andy
 */
public abstract class S0_SortCommon {

	@Test
	public void print() {
		//int[] a = {17, 7, 13, 4, 10, 9, 20, 12, 11, 1, 15, 6, 16, 3, 19, 5, 18, 8, 14, 2};
		int[] a = getArray();
		sort(a);
		System.out.println("Result: " + java.util.Arrays.toString(a));
	}

	abstract void sort(int[] a);

	int[] getArray() {
		int[] a = {7, 4, 9, 1, 6, 3, 5, 8, 2};
		return a;
	}
}
