/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t05_Bit;

/**
 *
 * @author andy
 */
public class E5_Convert {
	int start_1(int a, int b){
		int count = 0;
		for(int c = a^b; c!=0; c >>=1){
			count += (c&1);
		}
		return count;
	}
	
	int start_2(int a, int b){
		int count = 0;
		for (int c = a^b; c!=0; c = c&(c-1)){
			count++;
		}
		return count;
	}
}
