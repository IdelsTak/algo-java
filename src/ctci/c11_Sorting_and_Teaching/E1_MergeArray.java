/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t11_Sorting_and_Teaching;

import org.junit.Test;

/**
 *
 * @author andy
 */
public class E1_MergeArray {

	//pre-condition: l1 should be long enough
	void merge(int[] s1, int[] s2, int i1, int i2) {
		int i = i1 + i2 + 1;
		for (int j = i; i1 >= 0 && i2 >= 0; j--) {
			if (s1[i1] > s2[i2]) {
				s1[i--] = s1[i1--];
			} else {
				s1[i--] = s2[i2--];
			}
		}
		while (i2 >= 0) {
			s1[i--] = s2[i2--];
		}
	}

	@Test
	public void test() {
		int[] s1 = new int[20];
		int[] s3 = {1, 3, 5, 7, 9};
		for (int i = 0; i < s3.length; i++) {
			s1[i] = s3[i];
		}
		int[] s2 = {2, 4, 6};
		merge(s1, s2, s3.length - 1, s2.length - 1);

		butil.Print.intArrayPrint(s1);
	}
}
