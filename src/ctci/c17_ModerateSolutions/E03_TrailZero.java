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
public class E03_TrailZero {

	/*solution*/
	//25 -> 5 -> 1
	public static int factorOf5(int n) {
		int count = 0;
		while (n % 5 == 0) {
			count++;
			n /= 5;
		}
		return count;
	}

	public static int zeroOfFactorial_1(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			count += factorOf5(i);
		}
		return count;
	}

	/*solution 2*/
	public static int zeroOfFactorial_2(int n) {
		if (n < 5) {
			return 0;
		}
		int nZeros = n / 5;
		nZeros += zeroOfFactorial_2(nZeros);
		return nZeros;
	}
	/*test*/
	public static void main(String argv[]) {
		int n = 26;
		System.out.println(zeroOfFactorial_1(n));
		System.out.println(zeroOfFactorial_2(n));
	}
}
