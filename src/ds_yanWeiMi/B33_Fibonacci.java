/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_yanWeiMi;

/**
 *
 * @author andy
 */
public class B33_Fibonacci {

	public int calc_1_iterative(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return calc_1_iterative(n - 1) + calc_1_iterative(n - 2);
		}
	}//calc

	public int calc_2_loop(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int a0 = 0;
			int a1 = 1;
			int a2 = a0 + a1;
			for (int i = 1; i <= n; i++) {
				a2 = a0 + a1;
				a0 = a1;
				a1 = a2;
			}
			return a2;
		}//if
	}//function

}
