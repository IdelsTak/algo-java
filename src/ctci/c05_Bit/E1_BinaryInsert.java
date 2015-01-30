/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t05_Bit;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E1_BinaryInsert {
	int insert(int m, int n, int i, int j){
		int mask = 0;
		for(int tmp = i; tmp <=j; tmp++){
			mask |= (1 << tmp);
		}
		mask = ~mask;
		//set bits to 0
		n &= mask;
		//insert bits
		n |= (m << i);		
		return n;
	}
	
	@Test
	public void test(){
		//        a9876543210
		int E = 0b10001001100;//expected
		int N = 0b10000000000;
		int M =       0b10011;
		int I = 2;
		int J = 6;
		int R = insert(M, N, I, J);//result
		
		assertTrue(Integer.toBinaryString(R) + " == " + 
			Integer.toBinaryString(E), 
			E == R);
	}
}
