/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t07_Mathematics;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class Prime {
	
	/*
	Solution 1: 
	*/	
	boolean primeNaive(int n){
		if(n<2){
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}	
	
	/*
	Solution 2: prime efficient: list of primes
	*/
	boolean[] primeList_optimal(int max){
		boolean[] flags = new boolean[max + 1];
		java.util.Arrays.fill(flags, 2, flags.length - 1, true);
		int prime = 2;
		while(prime < flags.length){
			crossout(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		return flags;
	}


	private void crossout(boolean[] flags, int prime) {
		for (int i = prime*prime; i < flags.length; i++) {
			if(flags[i] && (i%prime)==0) flags[i] = false;
		}
	}


	private int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while(next < flags.length && !flags[next]){
			next++;
		}
		return next;
	}


	@Test
	public void test(){
		int[] datas = {2, 3, 4, 77};
		System.out.println("\n=============== primeNaive");
		for (int data : datas) {
			System.out.println(Integer.toString(data) + "  " + (primeNaive(data) ? 'v' : 'x'));
		}
		System.out.println("\n=============== primeOptimal");
		boolean[] flags = primeList_optimal(100);
		for (int i = 0; i < flags.length; i++) {
			if(flags[i]) System.out.print(i + "  ");
		}
	}
}
