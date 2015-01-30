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
public class E01_Swap {
	public static void swap(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println(a);
	}

	public static void swap_opt(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
	}
}
