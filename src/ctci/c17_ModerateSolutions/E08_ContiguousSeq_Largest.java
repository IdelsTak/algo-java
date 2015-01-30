/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

/**
 *
 * @author andy
 */
public class E08_ContiguousSeq_Largest {

	//have both postive and negative, so ignore smaller data
	public int sum(int[] a) {
		int n = a.length;
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + a[i];
			sum += a[i];
			if (sum > maxSum)
				maxSum = sum;
			else
				sum = 0;
		}
		return maxSum;
	}
}
