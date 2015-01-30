/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t07_Mathematics;

/**
 *
 * @author andy
 */
public class E4_BasicOper {
	int negate(int a){
		int d = a < 0 ? 1 : -1;
		int neg = 0;
		while(a != 0){
			a += d;
			neg += d;
		}
		return neg;
	}
	
	
	public int abs(int a){
		if(a<0){
			return negate(a);
		}else{
			return a;
		}
	}
	
	
	int multiply(int a, int b){
		if(Math.abs(a) < Math.abs(b)){
			return multiply(b, a);
		}
		int sum = 0;
		for (int i = Math.abs(b); i > 0; i--) {
			sum += a;
		}
		if(b<0) sum = negate(sum);
		return sum;
	}
	
	int subtract(int a, int b){
		return a + negate(b);
	}
	
	int divide(int a, int b){
		if(b == 0){
			throw new java.lang.ArithmeticException();
		}
		int c = Math.abs(a);
		int d = Math.abs(b);
		int product = 0;
		int x = 0;
		while(product + d <= c){
			product += d;
			x++;
		}
		if((a<0 && b<0) || (a>0 && b>0)){
			return x;
		}else{
			return negate(x);
		}
	}
}
