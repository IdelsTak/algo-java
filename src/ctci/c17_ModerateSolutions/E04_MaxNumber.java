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
public class E04_MaxNumber {
	/*solution 1: this solution may have overflow issue
	 a - b > 0  ==> a>b
	 */
	private static int flip(int sign) {
		return sign ^ 1;
	}

	private static int sign(int z) {
		return (z >> 31) & 1;
	}

	static int max_1_haveProblem(int a, int b) {
		int z = a - b;
		int k = sign(z);
		int q = flip(k);
		int max = b * k + a * q;
		System.out.printf("Max_1   %d, %d  ==>  %d\n", a, b, max);
		return max;
	}

	/*
	 a&b have different sign
	 if diff_sign
	 .	if(a > 0 && b<0)		ka = sign(a), ka = 0, qa = 1
	 .	if(a < 0 && b>0)		ka = sign(a), ka = 1, qa = 0
	 .	max = q * a + k * b;
	 else diff_sign_flip
	 .	c = a - b
	 .		if(c>0, a>b)		kc = sign(c), kc = 0, qc = 1
	 .		else(c<0, a<b)			    , kc = 1, qc = 0
	 .	max = qc * a + kc * b
	 .
	 . Summary:
	 .		max = diff_sign * (qa * a + ba*b) + diff_sign_flip * (qc * a + kc * b)
	 */
	static int diffSign(int a, int b) {
		int sA = sign(a);
		int sB = sign(b);
		return sA ^ sB;
	}

	static int max_2(int a, int b) {
		int diff_sign = diffSign(a, b);
		int diff_sign_flip = flip(diff_sign);
		int ka = sign(a);
		int qa = flip(ka);
		int c = a - b;
		int kc = sign(c);
		int qc = flip(kc);
		int max = diff_sign * (qa * a + ka * b) + diff_sign_flip * (qc * a + kc * b);
		System.out.printf("Max_2   %d, %d  ==>  %d\n", a, b, max);
		return max;
	}

	public static void main(String[] argv) {
		max_1_haveProblem(Integer.MAX_VALUE, Integer.MIN_VALUE);
		max_1_haveProblem(Integer.MIN_VALUE, Integer.MAX_VALUE);
		max_1_haveProblem(2, 10);
		max_1_haveProblem(-2, -10);
		max_1_haveProblem(2, -10);
		max_1_haveProblem(-2, 10);
		//
		max_2(Integer.MAX_VALUE, Integer.MIN_VALUE);
		max_2(Integer.MIN_VALUE, Integer.MAX_VALUE);
		max_2(2, 10);
		max_2(-2, -10);
		max_2(2, -10);
		max_2(-2, 10);
	}
}
